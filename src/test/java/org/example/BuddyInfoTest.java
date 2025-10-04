package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    @Test
    public void testBuddyInfoConstructor() {
        BuddyInfo buddyInfo1 = new BuddyInfo("John", 1234567890l);
        Assert.assertEquals("John", buddyInfo1.getName());
        Assert.assertEquals(1234567890, buddyInfo1.getPhonenumber());
    }

    @Test
    public void testBuddyInfoGetName() {
        BuddyInfo buddyInfo1 = new BuddyInfo("John", 1234567890l);
        Assert.assertEquals("John", buddyInfo1.getName());
    }

    @Test
    public void testBuddyInfoGetPhonenumber() {
        BuddyInfo buddyInfo1 = new BuddyInfo("John", 1234567890l);
        Assert.assertEquals(1234567890, buddyInfo1.getPhonenumber());
    }

    @Test
    public void testBuddyInfoSetName() {
        BuddyInfo buddyInfo1 = new BuddyInfo("John", 1234567890l);
        buddyInfo1.setName("Jane");
        Assert.assertEquals("Jane", buddyInfo1.getName());
    }

    @Test
    public void testBuddyInfoSetPhonenumber() {
        BuddyInfo buddyInfo1 = new BuddyInfo("John", 1234567890l);
        buddyInfo1.setPhonenumber(9876543210l);
        Assert.assertEquals(9876543210l, buddyInfo1.getPhonenumber());
    }
}