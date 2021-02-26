import javax.swing.*;

public class AddressBookView extends JFrame {
    private AddressBook addressBook;
    public JList<BuddyInfo> buddies;
    private AddressBookController abc;
    public JFrame frame;

    public AddressBookView(AddressBook model){

    }

    public void init() {
        addressBook = new AddressBook();
        frame = new JFrame("AddressBook");
        frame.setSize(1000, 750);

        JMenuBar addressBookBar = new JMenuBar();
        JMenu addressBookMenu= new JMenu("AddressBook Menu");
        JMenu buddyInfoMenu = new JMenu("BuddyInfo Menu");

        abc = new AddressBookController(this, addressBook);

        JMenuItem item1, item2, item3;

        item1 = new JMenuItem("Create new AddressBook");
        item2 = new JMenuItem("Add new BuddyInfo");
        item3 = new JMenuItem("Remove a BuddyInfo");
        AddressBook addressBook = new AddressBook();
        buddies= new JList<>();

        item1.addActionListener(abc);
        item1.setActionCommand("item1");

        item2.addActionListener(abc);
        item2.setActionCommand("item2");

        item3.addActionListener(abc);
        item3.setActionCommand("item3");

        // add JMenuItems to JMenu
        addressBookMenu.add(item1);
        buddyInfoMenu.add(item2);
        buddyInfoMenu.add(item3);

        //add JMenu to JMenuBar
        addressBookBar.add(addressBookMenu);
        addressBookBar.add(buddyInfoMenu);


        //set JMenuBar in frame
        frame.setJMenuBar( addressBookBar );
        frame.setVisible(true);
    }
}