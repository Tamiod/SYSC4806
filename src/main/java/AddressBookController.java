import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookController implements ActionListener {

    private AddressBookView abv;
    private AddressBook ab;

    public AddressBookController(AddressBookView addressBookView, AddressBook addressBook) {
        this.abv = addressBookView;
        this.ab = addressBook;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action1 = e.getActionCommand();
        if (action1.equals("item1")) {
            e.getSource();
            System.out.println("Creating AddressBook");

            abv.frame.add(abv.buddies);
            abv.buddies.setModel(ab);
            JOptionPane.showMessageDialog(abv.frame,"Address Book created");

            abv.buddies.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting() && abv.buddies.isSelectionEmpty()) {
                        BuddyInfo buddyInfo = abv.buddies.getSelectedValue();
                        int del = JOptionPane.showConfirmDialog(abv.frame, buddyInfo + "\nDelete this buddy?");
                        if (del == JOptionPane.OK_OPTION) {
                            try {
                                ab.removeElement(buddyInfo);
                                abv.buddies.clearSelection();
                                JOptionPane.showMessageDialog(abv.frame, "Buddy removed successfully!");
                            } catch (ArrayIndexOutOfBoundsException exc) {
                                JOptionPane.showMessageDialog(abv.frame, "Cannot find buddy you want removed");
                                abv.buddies.clearSelection();
                            }
                        }
                    }
                }
            });
        }

        if(action1.equals("item2")){
            e.getSource();
            String name = JOptionPane.showInputDialog(abv.frame, "Enter Name");
            String address = JOptionPane.showInputDialog(abv.frame, "Enter Address");
            String phoneNumber = JOptionPane.showInputDialog(abv.frame, "Enter Phone Number");
            BuddyInfo newBuddy = new BuddyInfo(name, address, phoneNumber);
            ab.addElement(newBuddy.toString());
            JOptionPane.showMessageDialog(abv.frame,"Buddy Info added!");
        }

        if(action1.equals("item3")){
            if (ab == null) {
                JOptionPane.showMessageDialog(abv.frame, "Address Book has not been created");
            }
            String index = JOptionPane.showInputDialog(abv.frame, "Enter index you want removed (starts from 0)");
            if (abv.buddies.getModel().getSize() == 0 || abv.buddies.getModel() == null) {
                JOptionPane.showMessageDialog(abv.frame, "There is no buddy to delete!!");
                return;
            }
            ab.remove(Integer.parseInt(index));
            JOptionPane.showMessageDialog(abv.frame, "Buddy deleted");
        }

    }
}