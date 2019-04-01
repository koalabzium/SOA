package pl.agh.kis.soa;

import pl.agh.kis.soa.ejb3.server.impl.TestAddBean;
import pl.agh.kis.soa.ejb3.server.impl.TestBeanCounter;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class IndexView implements Serializable {

    @EJB
    TestAddBean testAddBean;

    @EJB
    TestBeanCounter testBeanCounter;

    private int a = 0, b = 0;

    public IndexView() {
    }

    public int calculateSum() {
        return testAddBean.add(a, b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
