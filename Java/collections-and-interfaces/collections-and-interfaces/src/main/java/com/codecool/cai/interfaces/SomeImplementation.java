package com.codecool.cai.interfaces;

public class SomeImplementation implements SomeInterface {
    @Override
    public void method1() {
        System.out.println("method 1");
        method3();
    }

    public void method2() {
        System.out.println("method 2");
    }

    private void method3() {
        System.out.println("method 3");
    }
}
