package org.example;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class BuddyInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int buddyId;
    private String name;
    private long phonenumber;

    public BuddyInfo(String name, long phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public BuddyInfo() {
        name = null;
        phonenumber = -1;
    }

    public int getBuddyId() {
        return buddyId;
    }

    public void setBuddyId(int id) {
        this.buddyId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phonenumber;
    }
}
