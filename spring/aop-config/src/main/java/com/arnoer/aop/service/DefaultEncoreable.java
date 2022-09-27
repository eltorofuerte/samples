package com.arnoer.aop.service;

public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("演唱会返场");
    }
}
