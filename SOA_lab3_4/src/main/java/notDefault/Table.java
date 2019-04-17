package notDefault;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ManagedBean(name="Table")
@ApplicationScoped
public class Table {
    private List<Book> books;

    private double minPrice=0;
    private double maxPrice=1000;
    private List<String> categories = Arrays.asList("Fantastyka", "Romans", "Dramat");
    private String displayedCurrency = "oryg";
    private double totalPrice = 0;
    private int selected = 0;
    private Map<String, Double> currencies = Map.of("EUR",4.29,"USD",3.81,"PLN",1.0);


    public void init(){
        books = new ArrayList<Book>();
        books.add(new Book("Władca Pierścieni", "Tolkien", "Fantastyka", 50, "PLN", "PLN", 600));
        books.add(new Book("Duma i uprzedzenie", "Austin", "Romans", 7, "EUR", "EUR", 130));
        books.add(new Book("Śniadanie u Tiffany'ego", "Capote", "Dramat", 5, "EUR", "EUR",60));
    }

    public void changeCurrency(AjaxBehaviorEvent event){
        if(displayedCurrency.equals("oryg")){
            for(Book b : books){
                b.setPrice(b.getOrygPrice());
                b.setDisplayedCurrency(b.getCurrency());
            }
        }else{
            for(Book b : books) {
                b.setPrice(toPLN(b));
                b.setDisplayedCurrency("PLN");
            }
        }
    }

    public void countTotalPrice(AjaxBehaviorEvent event){
        totalPrice = 0;
        for(Book b : books){
            if(b.getIsSelected()){
                selected ++;
                if(!b.getCurrency().equals("PLN")){
                    totalPrice += toPLN(b);
                }else{
                    totalPrice += b.getPrice();
                }
            }
        }

    }

    private double toPLN(Book b){
        return b.getOrygPrice() * currencies.get(b.getCurrency());
    }

    public void changeBooksEvent(AjaxBehaviorEvent event){
        System.out.println("EVENT"+minPrice);
        System.out.println(maxPrice);
        System.out.println(categories);
    }
    public List<Book> getBooks() {
        if(books==null){
            init();
        }
        List<Book> toReturn = new ArrayList<Book>();
        for(Book a : books){
            if((a.getPrice() >= minPrice && a.getPrice() <= maxPrice) && categories.contains(a.getType())){
                toReturn.add(a);
            }
        }
        return toReturn;
    }

    public String getDisplayedCurrency() {
        return displayedCurrency;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<String, Double> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Map<String, Double> currencies) {
        this.currencies = currencies;
    }

    public void setDisplayedCurrency(String displayedCurrency) {
        this.displayedCurrency = displayedCurrency;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
