  package com.fpinjava.recursion.exercise04_07;

import java.util.List;

import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.foldLeft;
import static com.fpinjava.common.CollectionUtilities.foldRight;

  public class ComposeAll {

  public static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return x -> {
      T t = x;
      for (Function<T, T> function : list) {
        t = function.apply(t);
      }
      return t;
    };
  }
  public static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return x -> foldLeft(list, x, t -> f -> f.apply(t));
  }

  public static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    return x -> foldRight(list, x, f -> t -> f.apply(t));
  }
}
