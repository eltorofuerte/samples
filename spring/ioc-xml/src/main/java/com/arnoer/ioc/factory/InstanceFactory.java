package com.arnoer.ioc.factory;

import com.arnoer.ioc.po.People;

public class InstanceFactory {
    public People getPeople() {
        return new People();
    }
}
