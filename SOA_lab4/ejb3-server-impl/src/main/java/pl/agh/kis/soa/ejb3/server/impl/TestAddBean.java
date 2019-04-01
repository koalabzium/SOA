package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.Stateless;

@Stateless
public class TestAddBean {

    public int add(int a, int b) {
        return a + b;
    }
}
