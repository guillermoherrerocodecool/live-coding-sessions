package com.codecool.cai.casting;

import com.codecool.cai.Example;
import com.codecool.cai.interfaces.SomeImplementation;
import com.codecool.cai.interfaces.SomeInterface;

public class CastingExample implements Example {
    @Override
    public void show() {
        SomeInterface some = new SomeImplementation();
        some.method1();
        //some.method2();
        SomeImplementation implementation = (SomeImplementation) some;
        implementation.method2();
    }
}
