package com.il.oracle.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Created by cesaregb on 11/24/16.
 */
public class LoggerTest {
  private final static Logger LOGGER = LoggerFactory.getLogger(LoggerTest.class);

  public static void main(String[] args) {
    int val = 1;
    MDC.put("type", "batch");
    MDC.put("id", String.valueOf(1001));
    LOGGER.trace("val: {} ", val);
    LOGGER.debug("val: {} ", val);
    LOGGER.info("val: {} ", val);
    LOGGER.warn("val: {} ", val);
    LOGGER.error("val: {} ", val);
    MDC.remove("type");
    MDC.remove("id");
    LOGGER.info("val: {} ", val);
  }

  public static class Foo {
    private String abc1;
    private int abc2;

    public String getAbc1() {
      return abc1;
    }

    public void setAbc1(String abc1) {
      this.abc1 = abc1;
    }

    public int getAbc2() {
      return abc2;
    }

    public void setAbc2(int abc2) {
      this.abc2 = abc2;
    }
  }

}
