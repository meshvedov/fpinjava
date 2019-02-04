package com.fpinjava.recursion.exercise04_01;

import java.math.BigInteger;

public class Fibonacci {
  
  public static BigInteger fib(int x) {
    return x == 0 ? BigInteger.ZERO
                  : x == 1 ? BigInteger.ONE
                           : fib_(x, BigInteger.ZERO, BigInteger.ONE);
  }

  private static BigInteger fib_(int x, BigInteger acc1, BigInteger acc2) {
    return x == 0 ? acc1
                  : fib_(x - 1, acc2, acc2.add(acc1));
  }
}
