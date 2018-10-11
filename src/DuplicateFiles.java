package com.il.training.hackerrank.sad_examples.test2;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DuplicateFiles {
  List<String> list = new ArrayList<String>();


//	try{
//		Process p = new ProcessBuilder("sh",
//				"/Users/cesaregb/dev/workspace_oracle/upload-common-image/src/main/bin/upload-common-image.sh",
//				paramsMap.get("FILE_NAME"), 
//				paramsMap.get("FILE_B64"), 
//				paramsMap.get("GROUP"), 
//				paramsMap.get("ARTIFACT"), 
//				paramsMap.get("VERSION"), 
//				paramsMap.get("EXTENSION") 
//				)
//			.start();
//		System.out.println("P: " + p.toString());
//		int errCode = p.waitFor();
//		System.out.println("Echo command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
//		System.out.println("Echo Output:\n" + Utils.output(p.getInputStream()));
//		
//	}catch(Exception e){
//		e.printStackTrace();
//	}	    


  public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    System.out.println(cal.getTime());
    cal.add(Calendar.DATE, 2); // number
    System.out.println(cal.getTime());
  }

  public static void main2(String[] args) {
    DuplicateFiles df = new DuplicateFiles();
    df.list.add("AccessKey");
    df.list.add("Address");
    df.list.add("Asset");
    df.list.add("AssetTaskOrder");
    df.list.add("AssetTaskService");
    df.list.add("AssetType");
    df.list.add("Client");
    df.list.add("Employee");
    df.list.add("EmployeeTaskOrder");
    df.list.add("EmployeeTaskService");
    df.list.add("EmployeeType");
    df.list.add("Order");
    df.list.add("OrderTask");
    df.list.add("OrderTemplate");
    df.list.add("OrderTemplateTask");
    df.list.add("PhoneNumber");
    df.list.add("Product");
    df.list.add("ProductType");
    df.list.add("Service");
    df.list.add("ServiceSpec");
    df.list.add("ServiceTask");
    df.list.add("ServiceType");
    df.list.add("ServiceTypeSpec");
    df.list.add("ServiceTypeTask");
    df.list.add("SocialNetwork");
    df.list.add("SocialNetworkData");
    df.list.add("Spec");
    df.list.add("Task");
    System.out.println("===> " + df.list.size());
    String fileName = "ShopServiceDaoImpl.txt";
    for (String item : df.list) {
      String content = df.getFileContent(fileName, "Shop", item);
      String endFileName = fileName.replace("Shop", item).replace("txt", "java");
      df.writeFile(endFileName, content);
    }
  }

  public String getFileContent(String file, String search, String replace) {
    BufferedReader br = null;
    String result = "";
    try {
      String sCurrentLine;
      URL path = DuplicateFiles.class.getResource(file);
      br = new BufferedReader(new FileReader(path.getPath()));
      while ((sCurrentLine = br.readLine()) != null) {
        result += sCurrentLine.replaceAll(search, replace).replaceAll(search.toLowerCase(), replace.toLowerCase()) + "\n";
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
    return result;
  }

  public void writeFile(String filename, String content) {
    BufferedWriter writer = null;
    try {
      URL path = DuplicateFiles.class.getResource(".");
      writer = new BufferedWriter(new FileWriter(path.getPath() + filename));
      writer.write(content);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (writer != null)
          writer.close();
      } catch (IOException e) {
      }
    }
  }

}
