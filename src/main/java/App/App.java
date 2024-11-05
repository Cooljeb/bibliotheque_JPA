package App;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
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

        Client c = em.find(Client.class,2);

        if(c != null){
            System.out.println(c.toString());
        }

        Emprunt e = em.find(Emprunt.class,2);

        if(e != null) {
            System.out.println(e.getLivres());
        }
        //em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
