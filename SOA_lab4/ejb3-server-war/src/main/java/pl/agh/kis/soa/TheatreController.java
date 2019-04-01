package pl.agh.kis.soa;

import pl.agh.kis.soa.ejb3.server.impl.Seat;
import pl.agh.kis.soa.ejb3.server.impl.TheatreSingleton;
import pl.agh.kis.soa.ejb3.server.impl.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean(name="TheatreController")
public class TheatreController implements Serializable {

    List<Seat> seats;

    @EJB
    TheatreSingleton singleton;

    @EJB
    User logged = new User(100);

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getSeats(){
        seats = singleton.getSeatList();
        return seats;
    }

    public void buy(Seat seat){
        singleton.buyTicket(seat, logged);
    }
}
