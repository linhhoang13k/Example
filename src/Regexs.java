package com.il.oracle.tests;

/**
 * Created by cesaregb on 12/1/16.
 */
public class Regexs {

  public static void main(String[] args) {
//		System.out.println(validGuid("ABC-123"));
//		System.out.println(validGuid("ABC-12-3"));
//		System.out.println(validGuid("TG-TESTCREATEPUBANDSIMULATEREPLACING-9E97332E-89D5-4F7D-9C3D-945E8AF7E26D"));
//		System.out.println("*******************");
//		StringBuilder sb = new StringBuilder("A");
//		for (int i = 0; i < 7; i++){
//			sb.append(sb.toString());
//		}
//		System.out.println(validGuid(sb.toString()));
    System.out.println(validGuid("SPCOMMON-SHARED-IMAGES"));
  }


  // version
  public static void mainaa(String[] args) {
    System.out.println(validVersion("1"));
    System.out.println(validVersion("1.23"));
    System.out.println(validVersion("v-1"));
    System.out.println(validVersion("v1.1"));
    System.out.println(validVersion("1.2.3"));
    System.out.println("************");
    System.out.println(validVersion("v_1"));
    System.out.println(validVersion("1 2"));
    System.out.println(validVersion("1_-2_3"));
    System.out.println(validVersion(".123"));
    System.out.println(validVersion("1:23"));

  }

  public static boolean validVersion(String version) {
//		if (version.matches("^[a-zA-Z0-9][a-zA-Z.\\-0-9]*$")) {
    if (version.matches("^[a-zA-Z0-9][a-zA-Z0-9.-]*$")) {
      return true;
    }

    return false;
  }

  public static boolean validGuid(String guid) {
    if (guid.matches("^[A-Z0-9][A-Z0-9-]{1,63}[A-Z0-9]$")) {
      return true;
    }

    return false;
  }


}
