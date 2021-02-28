package com.example.Lab5;
import javax.persistence.*;
import javax.swing.*;
import java.util.*;



@Entity
public class AddressBook  {


    @Id
    @GeneratedValue
    private Integer id;


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> buddies;

//    public AddressBook() {
//        buddies = new ArrayList<BuddyInfo>();
//    }


    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void addBuddies(BuddyInfo aBuddy) {
        if (aBuddy != null)
            buddies.add(aBuddy);
    }

    public void removeBuddy(BuddyInfo buddy){
        buddies.remove(buddy);
    }
}

