package com.snackshelf;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
public class User {
 @Id
 public ObjectId _userid;
 public String name;
 public String surname;
 
 
 // Constructors
 public User() {}
 public User(ObjectId _userid, String name, String surname) {
  this._userid =_userid;
  this.name = name;
  this.surname= surname;
  
 }
 
 // ObjectId needs to be converted to string
 public String get_userid() {
  return _userid.toHexString();
 }
 public void set_id(ObjectId _userid) {
  this._userid = _userid;
 }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
}
 
