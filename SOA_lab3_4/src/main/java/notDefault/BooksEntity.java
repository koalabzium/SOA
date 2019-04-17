package notDefault;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Objects;

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

    @Id
    @Column(name = "id")
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
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(author, that.author) &&
                Objects.equals(type, that.type) &&
                Objects.equals(price, that.price) &&
                Objects.equals(orygprice, that.orygprice) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(displayedcurrency, that.displayedcurrency) &&
                Objects.equals(pages, that.pages) &&
                Objects.equals(isselected, that.isselected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, type, price, orygprice, currency, displayedcurrency, pages, isselected);
    }
}
