package com.example.Lab5;
import javax.persistence.*;

@Entity
public class BuddyInfo {

    private Integer id;
    private String name;
    private String address;
    private String number;

    @Id
    @GeneratedValue
    public Integer getId(){
        return this.id;
    }


    public BuddyInfo(){

        this.name = null;
        this.address = null;
        this.number = null;
    }
    public BuddyInfo(String name,String address, String phoneNumber) {


        this.name = name;
        this.address = address;
        this.number = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNumber(String phoneNumber) {
        this.number = phoneNumber;
    }


    public void setId(Integer id){
        this.id = id;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        BuddyInfo test = new BuddyInfo ("Homer", "Ottawa", "613");
        System.out.println("Hello " + test.getName());
    }

    @Override
    public String toString() {
        return "addressBookPackage.BuddyInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + number + '\'' +
                '}';
    }
}