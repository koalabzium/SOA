package notDefault;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        BooksEntity book = new BooksEntity("Ogniem i mieczem", "Sienkiewicz", "Romans", 20.5, 20.5, "PLN", "PLN", 30, false);
        System.out.println(book.getAuthor());
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();

        List<BooksEntity> books;
        try {
            TypedQuery<BooksEntity> q = em.createQuery("SELECT b FROM BooksEntity b", BooksEntity.class);
            books = q.getResultList();
            for (BooksEntity b : books){
                System.out.println("getBooks: " + b.getTitle());
            }

        } catch (Exception e) {
            System.err.println("Error when trying to retrieve data from database: " + e);
        }

        emf.close();
    }
}

