package Model;

import java.util.Hashtable;


public class EkspertPiwny {

    public Hashtable<String, String> marki;
    public EkspertPiwny(){
        marki = new Hashtable<>();
        marki.put("jasne", "Gold Braynerek");
        marki.put("ciemne", "Staut kawowy");
        marki.put("czerwone", "Czerwony Lager");
    }

    public String getMarka(String kolor){
        return marki.get(kolor);
    }
}
