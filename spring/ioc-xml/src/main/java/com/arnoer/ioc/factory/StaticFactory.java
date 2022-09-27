package com.arnoer.ioc.factory;

import com.arnoer.ioc.po.People;

public class StaticFactory {
    public static People getPeople() {
        return new People();
    }
}
