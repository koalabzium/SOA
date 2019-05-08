package notDefault;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "books", schema = "public", catalog = "postgres")
public class BooksEntity {
    private int id;
    private String title;
    private String author;
    private String type;
    private Double price;
    private Double orygprice;
    private String currency;
    private String displayedcurrency;
    private Integer pages;
    private Boolean isselected;

    public BooksEntity(String title, String author, String type, Double price, Double orygprice, String currency, String displayedcurrency, Integer pages, Boolean isselected) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.price = price;
        this.orygprice = orygprice;
        this.currency = currency;
        this.displayedcurrency = displayedcurrency;
        this.pages = pages;
        this.isselected = isselected;
    }

    public BooksEntity() {
    }

    public BooksEntity(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.type = "typ";
        this.price = price;
        this.orygprice = price;
        this.currency = "PLN";
        this.displayedcurrency = "PLN";
        this.pages = 100;
        this.isselected = false;

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name="incrementator", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "orygprice")
    public Double getOrygprice() {
        return orygprice;
    }

    public void setOrygprice(Double orygprice) {
        this.orygprice = orygprice;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "displayedcurrency")
    public String getDisplayedcurrency() {
        return displayedcurrency;
    }

    public void setDisplayedcurrency(String displayedcurrency) {
        this.displayedcurrency = displayedcurrency;
    }

    @Basic
    @Column(name = "pages")
    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Basic
    @Column(name = "isselected")
    public Boolean getIsselected() {
        return isselected;
    }

    public void setIsselected(Boolean isselected) {
        this.isselected = isselected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksEntity that = (BooksEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (orygprice != null ? !orygprice.equals(that.orygprice) : that.orygprice != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (displayedcurrency != null ? !displayedcurrency.equals(that.displayedcurrency) : that.displayedcurrency != null)
            return false;
        if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
        if (isselected != null ? !isselected.equals(that.isselected) : that.isselected != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (orygprice != null ? orygprice.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (displayedcurrency != null ? displayedcurrency.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (isselected != null ? isselected.hashCode() : 0);
        return result;
    }
}
