package com.maruf.banglaquran;

public class TestModel {
    int uid;
    String uname, ucollege, uphone;

    public void TestModel(){
    }
    //
    public void setId(int id){
        this.uid = id;
    }
    public int getId(){
        return uid;
    }
    //
    public void setName(String tname){
        this.uname = tname;
    }
    public String getName(){
        return uname;
    }
    //
    public void setCollege(String tclg){
        this.ucollege = tclg;
    }
    public String getCollege(){
        return ucollege;
    }
    //
    public void setPhone(String tphn){
        this.uphone = tphn;
    }
    public String getPhone(){
        return uphone;
    }

}
