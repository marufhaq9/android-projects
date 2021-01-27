package com.example.maruf.mydatabase;

import java.io.Serializable;

public class UserModel implements Serializable{

    private String fname, lname, varsity, dept, sessn;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getVarsity() {
        return varsity;
    }

    public void setVarsity(String uvarsity) {
        this.varsity = uvarsity;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String udept) {
        this.dept = udept;
    }
    public String getSessions() {
        return sessn;
    }

    public void setSessions(String usession) {
        this.sessn = usession;
    }
}
