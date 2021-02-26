import javax.persistence.*;
import javax.swing.*;
import java.util.*;



@Entity
public class AddressBook extends DefaultListModel{



    @Id
    @GeneratedValue
    private Integer id;


    @OneToMany(mappedBy = "addressBook",cascade = CascadeType.REMOVE)
    private DefaultListModel<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new DefaultListModel<>();
    }


    public DefaultListModel<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(DefaultListModel<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }


    public void addBuddies(BuddyInfo aBuddy){
        if(aBuddy != null)
            buddies.addElement(aBuddy);
    }

    public BuddyInfo removeBuddy(int index){
        if(index >= 0 && index < buddies.size()) {
            return buddies.remove(index);
        }
        return null;
    }


    public static void main (String[] args) {
        System.out.println("Address Book");
        BuddyInfo buddy = new BuddyInfo("who", "where", "613");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddies(buddy);
        addressBook.removeBuddy(0);
        System.out.print("Test");

        Launcher launcher = new Launcher();
        launcher.launch();
    }


    @Override
    public String toString() {
        return "AddressBookModel{" +
                "buddyInfo=" + buddies +
                '}';
    }
}