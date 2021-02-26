
import org.junit.Test;

import javax.persistence.*;
import java.util.List;



public class BuddyInfoTest {
    BuddyInfo bud1, bud2;
    EntityManagerFactory emf;

    EntityManager em;
    EntityTransaction tx;

    @Test
    public void PersistenceTest() {

        bud1 = new BuddyInfo();
        bud1.setId(1);
        bud1.setName("Tammy");
        bud1.setNumber("613");

        bud2= new BuddyInfo();
        bud2.setId(2);
        bud2.setName("Jess");
        bud2.setNumber("647");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        emf = Persistence.createEntityManagerFactory("jpa-test");

        em = emf.createEntityManager();

        // Creating a new transaction
        tx = em.getTransaction();


        tx.begin();
        em.persist(bud1);
        em.persist(bud2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("\nList of Buddies\n----------------");

        for (BuddyInfo p : results) {

            System.out.println(" (id=" + p.getId() + ") " + p.getName() + " " + p.getNumber());
        }

        System.out.println();


        // Closing connection
        em.close();

        emf.close();
    }
}