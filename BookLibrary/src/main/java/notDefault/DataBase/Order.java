package notDefault.DataBase;

import javafx.scene.chart.PieChart;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Order")
public class Order {
    @Id
    private int id;

    @ManyToOne
    private Book book_id;

    @ManyToOne
    private Reader reader_id;
    private Date order_date;
    private Date return_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book) {
        this.book_id = book;
    }

    public Reader getReader_id() {
        return reader_id;
    }

    public void setReader_id(Reader reader) {
        this.reader_id = reader;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date borrow_date) {
        this.order_date = borrow_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
}
