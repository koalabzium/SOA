import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.List;
//import javax.validation.constraints;

@ManagedBean(name="Client")
@SessionScoped
public class Client implements Serializable {

    private String name;
    private String email;
    private int age;
    private String gender;
    private String edu;
    private double cup;
    private double waist;
    private double hips;
    private double chest;
    private int height;
    private String howMuch;
    private String howOften;
    private String colors;
    private List<String> what;


    public Client(){}

    public void changeGender(ValueChangeEvent e) {
        gender = e.getNewValue().toString();
    }


    public double getCup() {
        return cup;
    }

    public void setCup(double cup) {
        this.cup = cup;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getHips() {
        return hips;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHowMuch() {
        return howMuch;
    }

    public void setHowMuch(String howMuch) {
        this.howMuch = howMuch;
    }

    public String getHowOften() {
        return howOften;
    }

    public void setHowOften(String howOften) {
        this.howOften = howOften;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public List<String> getWhat() {
        return what;
    }

    public void setWhat(List<String> what) {
        this.what = what;
    }
}



