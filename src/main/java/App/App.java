package App;

import fr.diginamic.entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe de test
 */
public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");

        EntityManager em = emf.createEntityManager();

        //em.getTransaction().begin();

        Livre l = em.find(Livre.class,1);

        if(l != null){
            System.out.println(l.toString());
        }
        //em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
