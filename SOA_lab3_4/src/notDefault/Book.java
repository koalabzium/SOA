package notDefault;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String type;
    private double price;
    private double orygPrice;
    private String currency;
    private String displayedCurrency;
    private int pages;
    private boolean isSelected;

    public Book(String title, String author, String type, double price, String currency, String displayedCurrency, int pages) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.orygPrice = price;
        this.price = price;
        this.currency = currency;
        this.displayedCurrency = displayedCurrency;
        this.pages = pages;
        this.isSelected = false;
    }


    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean selected) {
        isSelected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplayedCurrency() {
        return displayedCurrency;
    }

    public void setDisplayedCurrency(String displayedCurrency) {
        this.displayedCurrency = displayedCurrency;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOrygPrice() {
        return orygPrice;
    }

    public void setOrygPrice(double orygPrice) {
        this.orygPrice = orygPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
