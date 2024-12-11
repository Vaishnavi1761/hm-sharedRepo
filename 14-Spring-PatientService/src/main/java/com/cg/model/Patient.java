package com.cg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patientTable")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private int pid;

    @NotBlank(message = "Patient name cannot be blank")
    @Size(min = 3, max = 50, message = "Patient name must be between 3 and 50 characters")
    @Column(name = "pname")
    private String pname;

    @Column(name = "phoneNo")
    private long phoneNumber;

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 100, message = "Address must not exceed 100 characters")
    @Column(name = "address")
    private String address;

    public Patient() {
        super();
    }

    public Patient(int pid, String pname, long phoneNumber, String address) {
        super();
        this.pid = pid;
        this.pname = pname;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient [pid=" + pid + ", pname=" + pname + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }
}
