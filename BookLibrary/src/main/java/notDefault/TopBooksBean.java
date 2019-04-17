package notDefault;

import notDefault.DataBase.Book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name= "topBooksBean")
@RequestScoped
public class TopBooksBean {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookLibrary");
    EntityManager em = factory.createEntityManager();

    public List<Book> getTopBooks() {
        List<Book> books = new LinkedList<Book>();
        String sql = "select Book.title,count(Book.title) " +
                "from Order right " +
                "join Book on Order.book_id = Book " +
                "group by Book.title " +
                "order by count(Book.title) desc";

        try {
            Query query = em.createQuery(sql);
            query.setMaxResults(3);
            books = query.getResultList();
        } catch (Exception e) {
            System.err.println("Can't retrieve data from database: " + e);
        }
        return books;
    }
}
