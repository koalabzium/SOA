package notDefault.DataBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Author")
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;

    @OneToMany(mappedBy="author", orphanRemoval=true)
    private List<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String toString() {
        return name + " " + surname;
    }
}
