package com.fpinjava.recursion.exercise04_03;

import java.util.List;

import com.fpinjava.common.Function;
import com.fpinjava.recursion.listing04_03.TailCall;

import static com.fpinjava.common.CollectionUtilities.head;
import static com.fpinjava.common.CollectionUtilities.tail;
import static com.fpinjava.recursion.listing04_03.TailCall.ret;
import static com.fpinjava.recursion.listing04_03.TailCall.sus;


public class FoldLeft {

  public static <T, U> U foldLeft(List<T> ts, U identity, Function<U, Function<T, U>> f) {
    return foldLeft_(ts, identity, f).eval();
  }

  private static <U, T> TailCall<U> foldLeft_(List<T> ts, U acc, Function<U, Function<T, U>> f) {
    return ts.isEmpty() ? ret(acc)
                        : sus(() -> foldLeft_(tail(ts), f.apply(acc).apply(head(ts)), f));
  }
}
