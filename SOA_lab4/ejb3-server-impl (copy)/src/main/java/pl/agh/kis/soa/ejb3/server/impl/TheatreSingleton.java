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
        seats.add(new Seat("dostępne", 20));
        seats.add(new Seat("niedostępne", 50));
        seats.add(new Seat("dostępne", 50));
        seats.add(new Seat("niedostępne", 60));
        seats.add(new Seat("dostępne", 70));
        seats.add(new Seat("dostępne", 80));
        seats.add(new Seat("dostępne", 90));
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
        System.out.println("KUPIONE " + seat.getPrice() );
        seat.setReserved("niedostępne");
        int budget = user.getBudget();
        budget -= seat.getPrice();
        user.setBudget(budget);
    }

}
