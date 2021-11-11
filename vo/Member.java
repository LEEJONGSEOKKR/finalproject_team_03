package com.projectfinal.stock.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {

	private String username;
	private String userid;
	private String userpassword;
	private String useremail;
	private int usergender;
	private int userage;
	private int usergrade;
	
	@Override
	public String toString() {
		return "Member [username=" + username + ", userid=" + userid + ", userpassword=" + userpassword + ", useremail="
				+ useremail + ", usergender=" + usergender + ", userage=" + userage + ", usergrade=" + usergrade + "]";
	}
	
	
	 
}
