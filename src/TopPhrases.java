package com.il.walletHub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by cesaregb on 10/2/16.
 */
public class TopPhrases {

  // normally this type of finding the most common x on a list of y, the data structure priority queue or min or max heap are useful.
  // im not using it because the whole list cannot fit in memory, and unless a db or some IO helper implements it, (that I think it can exist already)
  // I cannot make use of this data structure.

  // due the limitations for the problem
  // I would read the file by x lines at a time. (enough lines to ensure the correct usage of the memory)
  // then I would sort the phrases obtained on those lines in a structure:
  // phrase - count
  // phrases = phrase found in the text; count = number of matches for that phase on the file (readed amount)
  // I would store them in a database with quick read access (____ as the little research i did, is a good option)
  // the store process would have to be cautions.
  // with the y phrases read from the x lines on "memory" I'll iterate them and increment the count on the db (store them if not found)
  // the store process (increment) would have to access directly the file, we cannot read this on memory.
  // (the usage of a db that has precompiled algorithms for the quicker access to data would be better)

  // for the implementation I'll consider:
  // x = 20; limit of lines in memory
  // db = file (just to exemplify the IO access)
  // for iterating in the file I'll read the file in memory. I know this should not be the case but due time contrains I cannot work on a better implementation.
  // sorting  =  I'll use a simple comparator and sorting algorithms that are within the java,
  // as I remember the sorting implementations on java are up to the best sorting algorithms with a complexity of O = n lg(n)
  //

  public static void main(String[] args) {
    // This value reprecents the 100000 that the process requires to query
    int TOP_N_ELEMENTS = 10;
    try {
      int x = 50; // memory limit (by 3rd or something like that because the usage of auxiliar helpers on the process)
      boolean endFile = false;
      int limitI = 0;
      int limitE = limitI + x;
      // iterate thru the file by x lines (being x a good treshold to be stored on memory
      while (!endFile) {
        // read in memory the x * 50 phases
        List<String> phrases = getPhrases("test/TopPhrases.txt", limitI, limitE);
        endFile = phrases == null || phrases.size() == 0;

        if (!endFile) { // skip process if no more records, implemented to ensure safty

          // using implementation of sort, it has a good performance and memory implementation.
          Collections.sort(phrases);

          // count repeated words.
          // helper that is loaded in memory, and it can be avoided if we store the words directly to the IO (db).
          // but given the file IO implementation we can handle the "queries" much better with a hashmap implementation.
          // I'm aware that for calculating the hashkey and equals for each phrase its an expensive operation.
          HashMap<String, Integer> phrasesCounter = new HashMap<>();

          // we could
          // while using streams I think the usage of threads is better handled.
          // we could implement a loop that doest check the hashMap every iteration, but im not sure if at thread level that would be better.
          // still I wanted to mention that we could implement a loop that obtain the count of elements before inserting it, and this avoid the process required to calculate the hash
          // every query and insert.
          phrases.forEach(it -> {
            // possible solution is if increment the amount of each word on the db. or maybe
            phrasesCounter.putIfAbsent(it, 0);
            phrasesCounter.put(it, phrasesCounter.get(it) + 1);
          });

          phrases = null; // cleaning memory; we could even call the gc but that doesnt mean it will collect this object.

          storeValues(phrasesCounter);
          limitI = limitE;
          limitE = limitI + x;
        }
      }

      // testing
      PriorityQueue<KeyValue> queue = getNTopValues(TOP_N_ELEMENTS);
      while (queue.size() != 0) {
        KeyValue kv = queue.poll();
        System.out.println(kv.getKey() + "--" + kv.getValue());
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.print("Error processing file.");
    }

  }

  // this function as a query to the db for the x top values.
  private static PriorityQueue<KeyValue> getNTopValues(int size) throws Exception {
    List<String> lines = getFileContent("db_mock.txt", 0, Integer.MAX_VALUE); // hack for read file method.
    PriorityQueue<KeyValue> pq = new PriorityQueue<>(size, new PQsort());
    lines.forEach(it -> {
      String[] lineParts = it.split("\\|");
      String phrase = lineParts[0];
      Integer count = Integer.valueOf(lineParts[1]);
      KeyValue kv = new KeyValue(count, phrase);
      pq.offer(kv);
      if (pq.size() > size) {
        pq.poll();
      }
    });
    System.out.println(pq.size());
    return pq;
  }

  // these acts like the interaction with the db.
  // values stored on the db would perform much faster
  // I would have a hash or the phrase as key, this will help in db performance.
  private static void storeValues(HashMap<String, Integer> phasesCounter) throws Exception {
    URL path = TopPhrases.class.getResource(".");
    final String fileName = path.getPath() + File.separator + "db_mock.txt";


    // loading file in memory, this is NOT what is expected, but I'm thinking on the usage of a better IO implementation.
    HashMap<String, Integer> dbHashSet = new HashMap<>();
    List<String> lines = getFileContent("db_mock.txt", 0, Integer.MAX_VALUE); // hack for read file method.
    lines.forEach(it -> {
      String[] lineParts = it.split("\\|");
      String phrase = lineParts[0];
      Integer count = Integer.valueOf(lineParts[1]);
      dbHashSet.put(phrase, count);
    });


    // using other array, just to make the code cleaner,
    // we can reuse objects already on the JVM stack, but we could handle memory management
    List<String> fileLines = new ArrayList<>();

    // perfome queries and updates on the db,... but at "memory" level.
    for (Map.Entry<String, Integer> entry : phasesCounter.entrySet()) {
      int countPhrase = (dbHashSet.get(entry.getKey()) != null) ? dbHashSet.get(entry.getKey()) : 0;
      countPhrase += +entry.getValue(); // 2nd line to help code clarity.
      // use pipe char because is mentione that we can deduce is not found on any phrases
      if (entry.getKey().length() > 1)
        fileLines.add(entry.getKey() + "|" + countPhrase);
    }

    // code snippet to delete file
    File helper = new File(fileName);
    if (helper.exists()) {
      helper.delete();
    }
    // create the file as a brand new every iteration
    // this will be hard on memory as is a IO operation, but I'm simulating that the IO operations would be against a db.
    File dbMock = new File(fileName);
    dbMock.createNewFile();
    Path file = Paths.get(fileName);
    Files.write(file, fileLines, Charset.forName("UTF-8"));
  }

  // this is just a helper method to generate tests
  public static void helper2GenerateTest(String[] args) {
//		for (int j = 0; j <= 300; j++){
//			String line = "";
//			for (int i = 0; i<=50; i++){
//				String word = RandomStringUtils.random(10, 0, 10, true, true, "abcdefghij".toCharArray());
//				line += word + " | ";
//			}
//			line = line.substring(0, line.length() - 2).trim();
//			System.out.println(line);
//		}
  }

  // if the lines in the file may be bigger than 2,147,483,647 entries we may require other type different than int.
  private static List<String> getFileContent(String fileName, int initLine, int endLine) throws Exception {
    BufferedReader br = null;
    List<String> result = new ArrayList<>();
    URL path = TopPhrases.class.getResource(fileName);
    if (path != null) {
      try {
        String sCurrentLine;
        br = new BufferedReader(new FileReader(path.getPath()));
        int c = 0;
        boolean exit = false;

        // there is no way to read "lines" from file other than iterating thru it,
        // still this operation maybe heavy on process but not in memory, we are not storing that in memory.
        while (((sCurrentLine = br.readLine()) != null) && !exit) {

          if (c >= initLine && c <= endLine) {
            result.add(sCurrentLine);
          }
          exit = (c > endLine);
          c++;
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (br != null)
            br.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    }
    return result;
  }

  private static List<String> getPhrases(String fileName, int initLine, int endLine) throws Exception {
    List<String> lines = getFileContent(fileName, initLine, endLine);
    List<String> result = lines.stream()
            .map(it -> {
              it = it.replaceAll("\\s+", "");
              return Arrays.asList(it.split("\\|"));
            })
            .flatMap(Collection::stream).collect(Collectors.toList());

    return result;
  }

  static class PQsort implements Comparator<KeyValue> {
    public int compare(KeyValue one, KeyValue two) {
      return one.getKey() - two.getKey();
    }
  }
}

class KeyValue {
  private Integer key;
  private String value;

  public KeyValue(Integer key, String value) {
    this.key = key;
    this.value = value;
  }

  public Integer getKey() {
    return key;
  }

  public void setKey(Integer key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
