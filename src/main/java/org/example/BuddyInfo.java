package org.example;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column()
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
