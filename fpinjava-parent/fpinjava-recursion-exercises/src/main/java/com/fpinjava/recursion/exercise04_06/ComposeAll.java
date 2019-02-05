package com.fpinjava.recursion.exercise04_06;

import java.util.List;

import com.fpinjava.common.Function;
import com.fpinjava.common.TailCall;

import static com.fpinjava.common.CollectionUtilities.*;
import static com.fpinjava.common.TailCall.ret;
import static com.fpinjava.common.TailCall.sus;


public class ComposeAll {

  static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return t -> composeall(list, t).eval();
//    return foldRight(list, Function.identity(), x -> y -> x.compose(y));
  }

  private static <T> TailCall<T> composeall(List<Function<T, T>> list, T acc) {
    return list.isEmpty() ? ret(acc)
                          : sus(() -> composeall(tail(list), head(list).apply(acc)));
  }
}
