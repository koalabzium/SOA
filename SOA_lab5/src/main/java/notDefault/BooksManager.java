package notDefault;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.*;


@RequestScoped
@Named(value="BooksManager")
public class BooksManager {
    private EntityManager em;
    private EntityManagerFactory emf;

    public BooksManager() {
        System.out.println("połączenie");
        emf = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        em = emf.createEntityManager();
        System.out.println("połączenie");
    }

    public List<BooksEntity> getBooks(){
        System.out.println("getbooks");
        emf = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        em = emf.createEntityManager();
        List<BooksEntity> books = new LinkedList<BooksEntity>();
        try {
            TypedQuery<BooksEntity> q = em.createQuery("SELECT b FROM BooksEntity b", BooksEntity.class);
            books = q.getResultList();
            System.out.println("getBooks: " + books.get(0).getAuthor());
        } catch (Exception e) {
            System.err.println("Error when trying to retrieve data from database: " + e);
        }
        return books;
    }

    public void deleteBook(BooksEntity book) {
        try {
            BooksEntity foundBook = em.find(BooksEntity.class, book.getId());

            em.getTransaction().begin();
            em.remove(foundBook);
            em.getTransaction().commit();
        }

        catch (Exception e) {
            System.err.println("DELETE ERROR: " + e);
            em.getTransaction().rollback();
        }
    }


    public String addBook( String title, String author, double price) {
        BooksEntity newBook = new BooksEntity(title, author, price);

        try {
            em.getTransaction().begin();
            em.persist(newBook);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("ADD ERROR: " + e);
            return "";
        }
        return "index";
    }

    public String updateBook(String id, String title, String author, double price) {
        try {
            BooksEntity foundBook = em.find(BooksEntity.class, id);

            em.getTransaction().begin();
            foundBook.setTitle(title);
            foundBook.setAuthor(author);
            foundBook.setPrice(price);
            em.getTransaction().commit();

            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("UPDATE ERROR: " + e);
            return "";
        }
    }


}
