package com.mahmudulmaruf.cgpaassistant;

public class InsertInfo {
    int _id;
    String _name, _varsity, _dept, _session, _pass;

    public InsertInfo(int id, String name, String varsity, String dept, String session, String pass){
        this._id=id;
        this._name=name;
        this._varsity=varsity;
        this._dept=dept;
        this._pass=pass;
    }

    public InsertInfo(String name, String varsity, String dept, String session, String pass){
        this._name=name;
        this._varsity=varsity;
        this._dept=dept;
        this._pass=pass;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }
    public void setName(String name){
        this._name = name;
    }

    public String getVarsity(){
        return this._varsity;
    }
    public void setVarsity(String varsity){
        this._varsity=varsity;
    }

    public String getDept(){
        return this._dept;
    }
    public void setDept(String dept){
        this._dept=dept;
    }

    public String getSession(){
        return this._session;
    }
    public void setSession(String session){
        this._session = session;
    }


    public String getPass(){
        return this._pass;
    }
    public void setPass(String pass){
        this._pass=pass;
    }


}
