package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class AddressBook implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private ArrayList<BuddyInfo> buddies;

    /**
     * The constructor for this class
     */
    public AddressBook() {
        buddies = new ArrayList<>();
    }

    /**
     * A constructor for this class that uses an existing list of BuddyInfos
     *
     * @param buddies The list of buddies to initialize this class with
     */
    public AddressBook(ArrayList<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    /**
     * Returns the contents of the Address book for testing purposes
     *
     * @return The contents of the Addressbook
     */
    public ArrayList<BuddyInfo> getBuddies() {
        return buddies;
    }

    /**
     * Sets the buddies in an address book, replacing any current contents with the specified Arraylist.
     *
     * @param buddies An arraylist of BuddyInfos to replace the contents of this Addressbook
     */
    public void setBuddies(ArrayList<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    /**
     * Gets the Id for this address book
     * @return The id of this address book
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Id for this address book
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Adds a BuddyInfo to the address book.
     *
     * @param buddy The BuddyInfo to be added to this address book
     */
    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    /**
     * Adds a BuddyInfo to the address book with the given name and phone number.
     *
     * @param name The name of the buddy to be added
     * @param phonenumber The phone number of the buddy to be added
     */
    public void addBuddy(String name, long phonenumber) {
        buddies.add(new BuddyInfo(name, phonenumber));
    }

    /**
     * Removes a buddy from the address book.
     *
     * @param buddy The BuddyInfo to be removes
     * @return True if the buddy was removed.
     */
    public Boolean removeBuddy(BuddyInfo buddy) {
        return buddies.remove(buddy);
    }

    /**
     * Removes the first instance of a BuddyInfo with a given name.
     *
     * @param name The name of the BuddyInfo to be removed.
     * @return The BuddyInfo to be removed if the buddy info exists. null if no BuddyInfo with the given name exists in this AddressBook.
     */
    public BuddyInfo removeBuddy(String name) {
        BuddyInfo buddy = null;
        for (BuddyInfo curbuddy : buddies) {
            if (curbuddy.getName().equals(name)) {
                buddy = curbuddy;
                break;
            }
        }
        if (buddy != null) {
            buddies.remove(buddy);
        }
        return buddy;
    }

    /**
     * Returns the first instance of a BuddyInfo with the given name or null if none exist.
     *
     * @param name The name of the BuddyInfo
     * @return null if no BuddyInfo of the given name exists or the first instance of BuddyInfo with the given name.
     */
    public BuddyInfo getBuddy(String name) {
        for (BuddyInfo curbuddy : buddies) {
            if (curbuddy.getName().equals(name)) {
                return curbuddy;
            }
        }
        return null;
    }

    /**
     * Prints the content of the AddressBook.
     */
    public void printBook(){
        System.out.println("Address Book Contents:");
        System.out.println("---------------------------");
        for (BuddyInfo curbuddy : buddies) {
            System.out.println(curbuddy.getName() + " " + curbuddy.getPhonenumber());
        }
    }

//    public static void main(String[] args) {
//        AddressBook addressBook = new AddressBook();
//        addressBook.addBuddy(new BuddyInfo("John", 1234567890));
//        addressBook.addBuddy(new BuddyInfo("Jane", 1234567891));
//        addressBook.addBuddy(new BuddyInfo("Henry", 1234567892));
//
//        addressBook.printBook();
//    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("AddressBook " + id + ": <br>");
        for (BuddyInfo curbuddy : buddies) {
            str.append(curbuddy.getName() + " " + curbuddy.getPhonenumber() + " <br> ");
        }
        return str.toString();
    }
}
