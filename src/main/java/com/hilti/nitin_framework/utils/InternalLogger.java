package com.hilti.nitin_framework.utils;

import java.time.LocalDateTime;

public class InternalLogger {
  public static void log(String msg){
    System.out.println("[" + LocalDateTime.now() + "] " + msg);
  }
}
