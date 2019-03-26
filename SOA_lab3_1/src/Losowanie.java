import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="Losowanie")
@RequestScoped
public class Losowanie {
    private static int losowa = losuj();
    private static int[] licznik = {0,0,0,0,0};

    public String spr(int n){

        if(n == losowa){
            losowa = losuj();
            return "trafiony";
        }
        losowa = losuj();
        licznik[n-1]++;
        return Integer.toString(n);
    }

    public int getLicznik(int n){
        return licznik[n-1];
    }

    private static int losuj(){
        return (int)(Math.random()*3+1);
    }
}
