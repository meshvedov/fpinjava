package com.fpinjava.recursion.exercise04_08;

import java.util.List;

import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.foldLeft;
import static com.fpinjava.common.CollectionUtilities.foldRight;


public class ComposeAll {

  static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return foldLeft(list, Function.identity(), f -> z -> t -> f.apply(z.apply(t)));
  }

  static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    return x -> foldRight(list, x, f -> t -> f.apply(t));
  }

  static <T> Function<T, T> andThenAllViaFoldLeft(List<Function<T, T>> list) {
    return x -> foldLeft(list, x, t -> f -> f.apply(t));
  }

  static <T> Function<T, T> andThenAllViaFoldRight(List<Function<T, T>> list) {
    return foldRight(list, Function.identity(), f -> z -> t -> z.apply(f.apply(t)));
  }
}
