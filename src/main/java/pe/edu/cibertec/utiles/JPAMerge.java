package pe.edu.cibertec.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Libro;

public class JPAMerge {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        Libro libro = em.find(Libro.class, "A1");
        libro.setAutor("Gabriel García Marquez");

        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }
}
