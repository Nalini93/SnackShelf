package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
public class User{
    @Id
    public ObjectId _id;
    public String name;
    public String surname;

    // Constructors
    public User(){}
    public User(String name, String surname){
        this.name = name;
        this.surname= surname;
    }

    public String get_id(){
        return _id.toHexString();
    }
    public void set_id(ObjectId _id){
        this._id = _id;
    }
    public String getName(){
	    return name;
    }
    public void setName(String name){
	    this.name = name;
    }
    public String getSurname(){
	    return surname;
    }
    public void setSurname(String surname){
	    this.surname = surname;
    }
    @Override
    public String toString() {
	    return "User [_id=" + _id + ", name=" + name + ", surname=" + surname + "]";
    }
}