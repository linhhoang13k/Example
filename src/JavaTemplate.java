package com.il.training.hackerrank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cesaregb on 3/4/17.
 */
public class JavaTemplate {

  public static void main(String[] args) {
    System.out.println(getParentPath("training_project"));
  }

  public static Scanner getFileScanner(String fileName) {
    try {
      ClassLoader classLoader = JavaTemplate.class.getClassLoader();
      File file = new File(classLoader.getResource(fileName).getFile());
      Scanner in = new Scanner(file);
      return in;
    } catch (Exception e) {
      // do nothing
    }
    return null;
  }

  private static List<String> getFileLines(Scanner in) {
    List<String> stringArrayList = new ArrayList<>();
    String input = null;
    while (in.hasNextLine() && !((input = in.nextLine()).equals(""))) {
      stringArrayList.add(input);
    }
    return stringArrayList;
  }


  private static void writeFile2(String canonicalFilename, List<String> text) {
    try {
      Path file = Paths.get(canonicalFilename);
      Files.write(file, text, Charset.forName("UTF-8"));
    } catch (IOException e) {
      // do something
    }
  }

  /**
   * Save the given text to the given filename.
   *
   * @param canonicalFilename Like /Users/al/foo/bar.txt
   * @param text              All the text you want to save to the file as one String.
   * @throws IOException
   */
  private static void writeFile(String canonicalFilename, List<String> text)
          throws IOException {
    File file = new File(canonicalFilename);
    BufferedWriter out = new BufferedWriter(new FileWriter(file));
    text.forEach(l -> {
      try {
        out.write(l);
      } catch (IOException ignored) {
      }
    });
    out.close();
  }

  private static String getCurrentPath() {
    return JavaTemplate.class.getProtectionDomain().getCodeSource().getLocation().getPath();
  }

  private static String getParentPath(String parent) {
    String r = getCurrentPath();
    String[] parts = r.split(parent);
    StringBuilder sb = new StringBuilder(parts[0]).append(parent).append("/");
    return sb.toString();
  }


}
