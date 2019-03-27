package notDefault;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ManagedBean(name="commercials")
@SessionScoped
public class Commercials {
    private List<Commercial> com;
    private Commercial current;

    public Commercials(){}

    public void randomize(){
        Random random = new Random();

        if(com == null) {
            createCommersials();
        }
        int index = Math.abs(random.nextInt(com.size()));
        current = com.get(index);

    }

    public void clickedCommercial(AjaxBehaviorEvent event){
        current.incrementCounter();
        System.out.println("KASZA " + com.get(0).getCounter());
        System.out.println("PUDEŁKO " + com.get(1).getCounter());
        System.out.println("KURCZAK " + com.get(2).getCounter());
    }

    public String getRandomImage(){
        if(current==null){
            randomize();
        }
        return current.getImage();
    }


    public int getCounter(){
        if(current==null){
            randomize();
        }
        return current.getCounter();
    }

    public String getRandomUrl(){
        randomize();

        return current.getUrl();

    }

    public void changedGender(AjaxBehaviorEvent event){
        System.out.println("ZMIANA PŁCI <3");
    }

    private void createCommersials() {
        com = new ArrayList<Commercial>();
        com.add(new Commercial("http://tinyurl.com/y52sby6s","https://www.youtube.com/watch?v=Y2XtrR-y4s8&t=354s"));
        com.add(new Commercial("http://tinyurl.com/y4prld6h","https://www.youtube.com/watch?v=UEbML9OddRs&t=22s"));
        com.add(new Commercial("http://tinyurl.com/y2tew5yu","https://www.youtube.com/watch?v=_aTO8kcTSrc"));
    }

    public Commercial getCurrent() {
        return current;
    }

    public void setCurrent(Commercial current) {
        this.current = current;
    }

    public List<Commercial> getCom() {
        return com;
    }

    public void setCom(List<Commercial> com) {
        this.com = com;
    }
}
