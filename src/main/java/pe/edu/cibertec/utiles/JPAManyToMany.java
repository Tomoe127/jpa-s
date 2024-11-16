package pe.edu.cibertec.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.domain.Curso;
import pe.edu.cibertec.domain.Estudiante;

import java.util.List;

public class JPAManyToMany {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        Estudiante estudiante =em.find(Estudiante.class, "E1");

        List<Curso> cursos = estudiante.getCursos();

        cursos.forEach(System.out::println);
    }
}
