package pl.agh.kis.soa;

import pl.agh.kis.soa.ejb3.server.impl.Payment;
import pl.agh.kis.soa.ejb3.server.impl.Seat;
import pl.agh.kis.soa.ejb3.server.impl.TheatreSingleton;
import pl.agh.kis.soa.ejb3.server.impl.User;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@ManagedBean(name="TheatreController")
public class TheatreController implements Serializable {

    private List<Seat> seats;
    private Seat chosen;
    private String error = "";


    @EJB
    TheatreSingleton singleton;

    @EJB
    User logged;

    @EJB
    Payment payment;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Seat getChosen() {
        return chosen;
    }

    public void setChosen(Seat chosen) {
        this.chosen = chosen;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getSeats(){
        seats = singleton.getSeatList();
        return seats;
    }

    public void buy(Seat seat){
        if(!error.equals("")){
            error = "";
        }
        chosen = seat;
        System.out.println("KUPUJE " + seat.getPrice() + "BUDŻET: " + logged.getBudget());
        try{
            payment.checkPayment(seat, logged);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            error = e.getMessage();
            return;
        }
        singleton.buyTicket(seat, logged);
    }
}
