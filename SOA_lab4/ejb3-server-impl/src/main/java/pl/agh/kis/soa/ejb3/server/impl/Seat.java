package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.Stateless;

@Stateless
public class Seat {
    private String reserved;
    private int price;

    public Seat() { }


    public Seat(String reserved, int price) {
        this.reserved = reserved;
        this.price = price;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
