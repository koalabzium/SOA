package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.Stateful;

@Stateful
public class User {
    private int budget;

    public User() {
        this.budget = 100;
    }

    public User(int budget) {
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
