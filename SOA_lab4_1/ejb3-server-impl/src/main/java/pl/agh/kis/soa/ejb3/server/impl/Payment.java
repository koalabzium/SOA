package pl.agh.kis.soa.ejb3.server.impl;

import javax.ejb.Stateful;

@Stateful
public class Payment {

    public void checkPayment(Seat seat, User user) throws Exception {
        boolean enoughBudget = checkBudget(seat, user);
        boolean available = checkAvailability(seat);
        if(!available){
            throw new Exception("To miejsce nie jest dostępne.");
        }
        if(!enoughBudget){
            throw new Exception("Nie masz wystarczająco dużo pieniędzy. Twój budże to " + user.getBudget());
        }
    }


    public boolean checkAvailability(Seat seat){
        return !seat.getReserved().equals("niedostępne");
    }

    public boolean checkBudget(Seat seat, User user){
        return user.getBudget() - seat.getPrice() >= 0;
    }
}
