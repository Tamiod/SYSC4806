

import org.junit.Test;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;


public class AddressBookTest {
    BuddyInfo bud1, bud2;
    AddressBook addressBook;
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;

    @Test
    public void PersistenceTest() {

        addressBook = new AddressBook();
        addressBook.setBuddies(new DefaultListModel<BuddyInfo>());
        //create first buddy
        bud1 = new BuddyInfo();
        bud1.setId(1);
        bud1.setName("Jess");
        bud1.setNumber("647");
        bud1.setAddress("hilton");
        //create second buddy
        bud2 = new BuddyInfo();
        bud2.setId(2);
        bud2.setName("Tammy");
        bud2.setNumber("613");
        bud2.setNumber("somerset");


        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        emf = Persistence.createEntityManagerFactory("jpa-test");

        em = emf.createEntityManager();

        // Creating a new transaction
        tx = em.getTransaction();



        tx.begin();
        em.persist(bud1);
        em.persist(bud2);
        addressBook.addBuddies(bud1);
        addressBook.addBuddies(bud2);
        em.persist(addressBook);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM AddressBook b");

        @SuppressWarnings("unchecked")
        List<AddressBook> results = q.getResultList();

        System.out.println("\nAddress Books\n----------------");

        for (AddressBook a : results) {
            System.out.println("  Address Book (id=" + a.getId() + ")");
            for(int i = 0; i < a.getBuddies().getSize(); i++)
//            for (BuddyInfo b : a.getBuddies()) {
//                System.out.println("   == " + " (id=" + b.getId() + ") " + b.getName() + " " + b.getPhoneNumber());
//            }
                System.out.println("   == " + " (id=" + a.getBuddies().get(i).getId() + ") " + a.getBuddies().get(i).getName() + " " + a.getBuddies().get(i).getNumber() + " " + a.getBuddies().get(i).getAddress() );
        }

        System.out.println("");


        // Closing connection
        em.close();

        emf.close();
    }
}