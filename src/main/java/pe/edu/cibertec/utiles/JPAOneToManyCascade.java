package pe.edu.cibertec.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Categoria;
import pe.edu.cibertec.domain.Libro;

import java.util.Arrays;
import java.util.Date;

public class JPAOneToManyCascade {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        Categoria categoria = new Categoria("C6", "Terror", null);

        Libro libro1 = new Libro("A11", "Titulo11", "Autor11f", new Date(), 50.20, categoria);
        Libro libro2 = new Libro("A12", "Titulo12", "Autor12f", new Date(), 50.21, categoria);
        Libro libro3 = new Libro("A13", "Titulo13", "Autor13f", new Date(), 50.22, categoria);

        categoria.setLibros(Arrays.asList(libro1, libro2, libro3));

        em.getTransaction().begin();
        em.persist(categoria);// CascadeType.Persist
        em.getTransaction().commit();
    }
}
