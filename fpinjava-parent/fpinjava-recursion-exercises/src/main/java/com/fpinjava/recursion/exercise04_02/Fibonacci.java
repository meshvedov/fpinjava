package com.fpinjava.recursion.exercise04_02;

import com.fpinjava.recursion.listing04_03.TailCall;

import java.math.BigInteger;

import static com.fpinjava.recursion.listing04_03.TailCall.ret;
import static com.fpinjava.recursion.listing04_03.TailCall.sus;


public class Fibonacci {

  public static BigInteger fib(int x) {
    return x == 0 ? BigInteger.ZERO
                  : x == 1 ? BigInteger.ONE
                           : fib_(BigInteger.ZERO, BigInteger.ONE, x).eval();
  }

  private static TailCall<BigInteger> fib_(BigInteger acc1, BigInteger acc2, int x) {
    return x == 0 ? ret(acc1)
            : sus(() -> fib_(acc2, acc1.add(acc2), x - 1));
  }
}
