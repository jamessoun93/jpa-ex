package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("James S");

            Movie movie = new Movie();
            movie.setName("Top Gun");
            movie.setActor("Tom C");

            Book book2 = new Book();
            book2.setName("JPA2");
            book2.setAuthor("Tom S");

            em.persist(book);
            em.persist(movie);
            em.persist(book2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
