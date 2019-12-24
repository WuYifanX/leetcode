package utils;

import java.util.List;

public class Logs {
  public static void print(int[] arrays) {
    for (int i = 0; i < arrays.length; i++) {
      System.out.print(arrays[i] + " ");
    }
    System.out.println();
  }

  public static void print(List<Integer> arrays) {
    for (int i = 0; i < arrays.size(); i++) {
      System.out.print(arrays.get(i) + " ");
    }
    System.out.println();
  }
}
