package com.brainmentors.testengine.user.dto;

import java.util.ArrayList;

public class UserDTO {
private String userid;
private String password;
private String roleName;
private ArrayList<RightDTO> rights = new ArrayList<>();



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
