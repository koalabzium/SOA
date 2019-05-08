package notDefault;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name= "menagedBean")
@RequestScoped
public class MenagedBean {
    EntityManagerFactory factory;
    EntityManager em;
    private Author chosenAuthor;
    private Reader chosenReader;
    private Book chosenBook;
    private Order chosenOrder;
    private int authorId;
    private int readerId;
    private int bookId;

    public MenagedBean() {
        factory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        em = factory.createEntityManager();

        chosenAuthor = new Author();
        chosenReader = new Reader();
        chosenBook = new Book();
        chosenOrder = new Order();
    }

    public List<Reader> getReaders() {
        List<Reader> readers = new LinkedList<Reader>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Reader> query = cb.createQuery(Reader.class);
        Root<Reader> root = query.from(Reader.class);
        List<Predicate> predicates = new LinkedList<Predicate>();
        if (chosenReader.getId()!=0)
            predicates.add(cb.equal(root.get("id"), chosenReader.getId()));
        if (chosenReader.getName()!=null && !chosenReader.getName().equals(""))
            predicates.add(cb.equal(root.get("name"), chosenReader.getName()));
        if (chosenReader.getSurname()!=null && !chosenReader.getSurname().equals(""))
            predicates.add(cb.equal(root.get("surname"), chosenReader.getSurname()));
        query.where(predicates.toArray(new Predicate[] {}));
        try {
            TypedQuery<Reader> q = em.createQuery(query);
            readers = q.getResultList();
        } catch (Exception e) {
            System.err.println("getReaders, Can't retrieve data from database:  " + e);
        }

        return readers;
    }

    public List<Author> getAuthors() {
        List<Author> authors = new LinkedList<Author>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> query = cb.createQuery(Author.class);
        Root<Author> root = query.from(Author.class);
        List<Predicate> predicates = new LinkedList<Predicate>();
        if (chosenAuthor.getId()!=0)
            predicates.add(cb.equal(root.get("id"), chosenAuthor.getId()));
        if (chosenAuthor.getName()!=null && !chosenAuthor.getName().equals(""))
            predicates.add(cb.equal(root.get("name"), chosenAuthor.getName()));
        if (chosenAuthor.getSurname()!=null && !chosenAuthor.getSurname().equals(""))
            predicates.add(cb.equal(root.get("surname"), chosenAuthor.getSurname()));
        query.where(predicates.toArray(new Predicate[] {}));
        try {
            TypedQuery<Author> q = em.createQuery(query);
            authors = q.getResultList();
        } catch (Exception e) {
            System.err.println("getAuthors, Can't retrieve data from database:  " + e);
        }
        List<String> authors_names = new LinkedList<String>();
        for(Author a: authors){
            authors_names.add(a.toString());
        }

        System.out.println(authors_names);

        return authors;
    }

    public List<Book> getBooks() {
        List<Book> books = new LinkedList<Book>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> query = cb.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        List<Predicate> predicates = new LinkedList<Predicate>();
        if (chosenBook.getId()!=0)
            predicates.add(cb.equal(root.get("id"), chosenBook.getId()));
        if (chosenBook.getTitle()!=null && !chosenBook.getTitle().equals(""))
            predicates.add(cb.equal(root.get("title"), chosenBook.getTitle()));
        if (authorId!=0) {
            Author author = findAuthorById(authorId);
            predicates.add(cb.equal(root.get("author"), author));
        }
        query.where(predicates.toArray(new Predicate[] {}));
        try {
            TypedQuery<Book> q = em.createQuery(query);
            books = q.getResultList();
        } catch (Exception e) {
            System.err.println("getBooks, Can't retrieve data from database:  " + e);
        }
        return books;
    }

    public List<Order> getOrders() {
        List<Order> orders = new LinkedList<Order>();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> query = cb.createQuery(Order.class);
        Root<Order> root = query.from(Order.class);
        List<Predicate> predicates = new LinkedList<Predicate>();
        if (chosenOrder.getId()!=0)
            predicates.add(cb.equal(root.get("id"), chosenOrder.getId()));
        if (readerId!=0) {
            Reader reader = findReaderById(readerId);
            predicates.add(cb.equal(root.get("reader"), reader));
        }
        if (bookId!=0) {
            Book book = findBookById(bookId);
            predicates.add(cb.equal(root.get("book"), book));
        }
        if (chosenOrder.getBorrowDate() != null) {
            predicates.add(cb.equal(root.get("order_date").as(Date.class), chosenOrder.getBorrowDate()));
        }
        if (chosenOrder.getReturnDate() != null) {
            predicates.add(cb.equal(root.get("return_date"), chosenOrder.getReturnDate()));
        }

        query.where(predicates.toArray(new Predicate[] {}));
        try {
            TypedQuery<Order> q = em.createQuery(query);
            orders = q.getResultList();
//            TypedQuery<Order> q = em.createQuery("SELECT b FROM Order b", Order.class);
//            orders = q.getResultList();
        } catch (Exception e) {
            System.err.println("getOrders, Can't retrieve data from database:  " + e);
        }
        return orders;
    }

    public void deleteReader(Integer reader) {
        try {
            Reader foundReader = em.find(Reader.class, reader);

            em.getTransaction().begin();
            em.remove(foundReader);
            em.getTransaction().commit();
        }

        catch (Exception e) {
            System.err.println("deleteReader, Can't retrieve data from database:  " + e);
            em.getTransaction().rollback();
        }
    }

    public void deleteAuthor(Author author) {
        try {
            Author foundAuthor = em.find(Author.class, author.getId());

            em.getTransaction().begin();
            em.remove(foundAuthor);
            em.getTransaction().commit();
        }

        catch (Exception e) {
            System.err.println("deleteAuthor, Can't retrieve data from database:  " + e);
            em.getTransaction().rollback();
        }
    }

    public void deleteBook(Book book) {
        try {
            Book foundBook = em.find(Book.class, book.getId());

            em.getTransaction().begin();
            em.remove(foundBook);
            em.getTransaction().commit();
        }

        catch (Exception e) {
            System.err.println("deleteBook, Can't retrieve data from database:  " + e);
            em.getTransaction().rollback();
        }
    }

    public void deleteOrder(Order order) {
        try {
            Order foundOrder = em.find(Order.class, order.getId());

            em.getTransaction().begin();
            em.remove(foundOrder);
            em.getTransaction().commit();
        }

        catch (Exception e) {
            System.err.println("deleteOrder, Can't retrieve data from database:  " + e);
            em.getTransaction().rollback();
        }
    }

    public String addReader(String name, String surname) {
        Reader newReader = new Reader();
        newReader.setName(name);
        newReader.setSurname(surname);
        add(newReader);
        return "index";
    }

    public String addAuthor(String name, String surname) {
        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setSurname(surname);
        add(newAuthor);
        return "index";
    }

    public String addBook(String title, String authorName) {
        Author author = findAuthor(authorName);
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        add(newBook);
        return "index";
    }

    public String addOrder(Integer bookName, Integer readerName, Date orderDate, Date returnDate) {
        Book book = findBookById(bookName);
        Reader reader = findReaderById(readerName);

        Order order = new Order();
        order.setBook(book);
        order.setReader(reader);
        order.setBorrowDate(new Timestamp(orderDate.getTime()));
        order.setReturnDate(new Timestamp(returnDate.getTime()));
        add(order);
        return "index";
    }

    private void add(Object newObject) {
        try {
            em.getTransaction().begin();
            em.persist(newObject);
            em.getTransaction().commit();
            System.out.println("Added to database" + newObject);
        }
        catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("Can't retrieve data from database:  " + e);
        }
    }

    private Author findAuthor(String authorName) {
        List<Author> authors = getAuthors();
        for (Author a:authors) {
            if (a.toString().equals(authorName))
                return a;
        }
        return null;
    }

    private Author findAuthorById(int id) {
        List<Author> authors = getAuthors();
        for (Author a:authors) {
            if (a.getId()==id)
                return a;
        }
        return null;
    }

    private Book findBook(String bookName) {
        List<Book> books = getBooks();
        for (Book b:books) {
            if (b.toString().equals(bookName))
                return b;
        }
        return null;
    }

    private Book findBookById(int id) {
        List<Book> books = getBooks();
        for (Book b:books) {
            if (b.getId()==id)
                return b;
        }
        return null;
    }

    private Reader findReader(String readerName) {
        List<Reader> reader = getReaders();
        for (Reader r:reader) {
            if (r.toString().equals(readerName))
                return r;
        }
        return null;
    }

    private Reader findReaderById(int id) {
        List<Reader> reader = getReaders();
        for (Reader r:reader) {
            if (r.getId()==id)
                return r;
        }
        return null;
    }

    public String updateBook(int id, String title, String authorName) {
        try {
            Book foundBook = em.find(Book.class, id);

            em.getTransaction().begin();
            foundBook.setTitle(title);
            Author author = findAuthor(authorName);
            foundBook.setAuthor(author);
            em.getTransaction().commit();

            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("updateBook, Can't retrieve data from database:  " + e);
            return "";
        }
    }

    public String updateAuthor(int id, String name, String surname) {
        try {
            Author foundAuthor = em.find(Author.class, id);

            em.getTransaction().begin();
            foundAuthor.setName(name);
            foundAuthor.setSurname(surname);
            em.getTransaction().commit();

            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("updateAuthor, Error when trying to update data in database: " + e);
            return "";
        }
    }

    public String updateReader(int id, String name, String surname) {
        try {
            Reader foundReader = em.find(Reader.class, id);

            em.getTransaction().begin();
            foundReader.setName(name);
            foundReader.setSurname(surname);
            em.getTransaction().commit();

            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("updateReader, Can't retrieve data from database:  " + e);
            return "";
        }
    }

    public String updateOrder(int id, String bookName, String readerName, Date orderDate, Date returnDate) {
        try {
            Order foundOrder = em.find(Order.class, id);
            Book book = findBook(bookName);
            Reader reader = findReader(readerName);

            Timestamp order_date = new Timestamp(orderDate.getTime());
            Timestamp return_date = new Timestamp(returnDate.getTime());

            em.getTransaction().begin();
            foundOrder.setBook(book);
            foundOrder.setReader(reader);
            foundOrder.setBorrowDate(order_date);
            foundOrder.setReturnDate(return_date);
            em.getTransaction().commit();

            return "index";
        }  catch(Exception e) {
            em.getTransaction().rollback();
            System.err.println("updateOrder, Can't retrieve data from database:  " + e);
            return "";
        }
    }

    public Author getChosenAuthor() {
        return chosenAuthor;
    }

    public void setChosenAuthor(Author chosenAuthor) {
        this.chosenAuthor = chosenAuthor;
    }

    public Reader getChosenReader() {
        return chosenReader;
    }

    public void setChosenReader(Reader chosenReader) {
        this.chosenReader = chosenReader;
    }

    public Book getChosenBook() {
        return chosenBook;
    }

    public void setChosenBook(Book chosenBook) {
        this.chosenBook = chosenBook;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Order getChosenOrder() {
        return chosenOrder;
    }

    public void setChosenOrder(Order chosenOrder) {
        this.chosenOrder = chosenOrder;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
