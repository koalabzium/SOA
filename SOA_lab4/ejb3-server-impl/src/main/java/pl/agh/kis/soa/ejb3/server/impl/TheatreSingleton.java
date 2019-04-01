package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.Lock;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TheatreSingleton {

    private List<Seat> seats;

    public TheatreSingleton(){
        seats = new ArrayList<Seat>();
        seats.add(new Seat("tak", 20));
        seats.add(new Seat("nie", 50));
        seats.add(new Seat("nie", 50));
        seats.add(new Seat("nie", 60));
        seats.add(new Seat("nie", 70));
        seats.add(new Seat("tak", 80));
        seats.add(new Seat("tak", 90));
    }

    @Lock
    public int getSeatPrice(Seat seat){
        return seat.getPrice();
    }

    @Lock
    public List<Seat> getSeatList(){
        return seats;
    }

    @Lock
    public void buyTicket(Seat seat, User user){
        seat.setReserved("tak");
        int budget = user.getBudget();
        budget -= seat.getPrice();
        user.setBudget(budget);
    }

}
