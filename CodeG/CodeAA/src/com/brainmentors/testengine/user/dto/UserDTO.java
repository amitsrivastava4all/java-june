package com.brainmentors.testengine.user.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDTO implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String userid;
private transient String password;
private String name;
private String city;
private transient String roleName;
private String country;
private transient ArrayList<RightDTO> rights = new ArrayList<>();




public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public ArrayList<RightDTO> getRights() {
	return rights;
}
public void setRights(ArrayList<RightDTO> rights) {
	this.rights = rights;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
