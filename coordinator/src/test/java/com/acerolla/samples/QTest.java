package com.acerolla.samples;

/**
 * Created by Evgeniy Solovev
 * Date: 09.08.2018
 * Email: solevur@gmail.com
 */
class A {
    void m1() { throw new MyException1(); }          // 3
    void m2() { throw new MyException2(); }          // 4

    class MyException1 extends Exception { }             // 1
    class MyException2 extends RuntimeException { }
}
