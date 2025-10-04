package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AddressBookTest {
    AddressBook addressBook;
    BuddyInfo buddyInfo1;
    BuddyInfo buddyInfo2;
    BuddyInfo buddyInfo3;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        buddyInfo1 =  new BuddyInfo("John", 1234567893l);
        buddyInfo2 =  new BuddyInfo("Jane", 1234567891l);
        buddyInfo3 =  new BuddyInfo("Henry", 1234567892l);
    }

    @Test
    public void testAddBuddy() {
        ArrayList<BuddyInfo> buddies;
        addressBook.addBuddy(buddyInfo1);
        buddies = addressBook.getBuddies();
        Assert.assertEquals(1, buddies.size());
        Assert.assertEquals(buddyInfo1, buddies.get(0));

        addressBook.addBuddy(buddyInfo2);
        buddies = addressBook.getBuddies();
        Assert.assertEquals(2, buddies.size());
        Assert.assertEquals(buddyInfo2, buddies.get(1));

        addressBook.addBuddy("Henry", 1234567892l);
        buddies = addressBook.getBuddies();
        Assert.assertEquals(3, buddies.size());
        Assert.assertEquals("Henry", buddies.get(2).getName());
        Assert.assertEquals(1234567892l, buddies.get(2).getPhonenumber());
    }

    @Test
    public void testSetBuddy() {
        ArrayList<BuddyInfo> buddies = new ArrayList<>();
        buddies.add(buddyInfo1);
        buddies.add(buddyInfo2);
        buddies.add(buddyInfo3);
        addressBook.setBuddies(buddies);
        buddies = addressBook.getBuddies();
        Assert.assertEquals(3, buddies.size());
        Assert.assertEquals(buddyInfo1, buddies.get(0));
        Assert.assertEquals(buddyInfo2, buddies.get(1));
        Assert.assertEquals(buddyInfo3, buddies.get(2));
    }

    @Test
    public void testRemoveBuddy() {
        ArrayList<BuddyInfo> buddies = new ArrayList<>();
        buddies.add(buddyInfo1);
        buddies.add(buddyInfo2);
        buddies.add(buddyInfo3);
        addressBook.setBuddies(buddies);

        Assert.assertTrue(addressBook.removeBuddy(buddyInfo1));
        buddies = addressBook.getBuddies();
        Assert.assertEquals(2, buddies.size());
        Assert.assertFalse(buddies.contains(buddyInfo1));

        Assert.assertTrue(addressBook.removeBuddy(buddyInfo2));
        buddies = addressBook.getBuddies();
        Assert.assertEquals(1, buddies.size());
        Assert.assertFalse(buddies.contains(buddyInfo2));

        assertEquals(addressBook.removeBuddy("Henry"), buddyInfo3);
        buddies = addressBook.getBuddies();
        Assert.assertEquals(0, buddies.size());
        Assert.assertFalse(buddies.contains(buddyInfo3));

        Assert.assertFalse(addressBook.removeBuddy(buddyInfo3));
        Assert.assertNull(addressBook.removeBuddy("Henry"));
    }

    @Test
    public void testGetBuddy() {
        ArrayList<BuddyInfo> buddies = new ArrayList<>();
        buddies.add(buddyInfo1);
        buddies.add(buddyInfo2);
        buddies.add(buddyInfo3);
        addressBook.setBuddies(buddies);

        Assert.assertEquals(buddyInfo1, addressBook.getBuddy("John"));
        Assert.assertEquals(buddyInfo2, addressBook.getBuddy("Jane"));
        Assert.assertEquals(buddyInfo3, addressBook.getBuddy("Henry"));
        Assert.assertNull(addressBook.getBuddy("Bill"));
    }

}