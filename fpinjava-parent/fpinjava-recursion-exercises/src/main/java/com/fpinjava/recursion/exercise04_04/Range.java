package com.fpinjava.recursion.exercise04_04;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.recursion.listing04_03.TailCall;

import java.util.List;

import static com.fpinjava.recursion.listing04_03.TailCall.ret;
import static com.fpinjava.recursion.listing04_03.TailCall.sus;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return range_(start, end, CollectionUtilities.list()).eval();
  }

  private static TailCall<List<Integer>> range_(Integer start, Integer end, List<Integer> list) {
    return start >= end ? ret(list)
            : sus(() -> range_(start + 1, end, CollectionUtilities.append(list, start)));
  }
}
