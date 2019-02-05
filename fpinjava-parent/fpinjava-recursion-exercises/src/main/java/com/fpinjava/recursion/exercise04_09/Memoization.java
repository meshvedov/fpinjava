package com.fpinjava.recursion.exercise04_09;

import com.fpinjava.common.TailCall;

import java.util.List;

import static com.fpinjava.common.CollectionUtilities.*;


public class Memoization {

  public static String fibo(int number) {
    return fibo_(number, list(0, 1), 1).eval();
  }

  private static TailCall<String> fibo_(int number, List<Integer> list, int index) {
    return number == 1 ? TailCall.ret(makeString(list, ", "))
                       : TailCall.sus(() -> fibo_(number - 1, append(list, list.get(index) + list.get(index - 1)), index + 1));
  }

  public static <T> String makeString(List<T> list, String separator) {
    return list.isEmpty() ? ""
                          : tail(list).isEmpty() ? head(list).toString()
                                                  : head(list) + foldLeft(tail(list), "", x -> y -> x + separator + y);
  }
}
