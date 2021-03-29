package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Authority")
@SequenceGenerator(name = "SEQ2" , 
sequenceName = "SEQ_GroupCode_NO",
initialValue = 1,
allocationSize = 1)
public class Authority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ2")
	@Column(name = "GroupCode")
	private long groupCode;
	
	@Column(name = "userAuthority")
	private String userAuthority;
	
	@Column(name = "adminAuthority")
	private String adminAuthority;
	
	@OneToMany(mappedBy = "auth")
	private List<Member> members = new ArrayList<>();

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public long getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(long groupCode) {
		this.groupCode = groupCode;
	}

	public String getUser() {
		return userAuthority;
	}

	public void setUser(String userAuthority) {
		this.userAuthority = userAuthority;
	}

	public String getAdmin() {
		return adminAuthority;
	}

	public void setAdmin(String adminAuthority) {
		this.adminAuthority = adminAuthority;
	}

	@Override
	public String toString() {
		return "Authority [groupCode=" + groupCode + ", userAuthority=" + userAuthority + ", adminAuthority=" + adminAuthority + "]";
	}

	public Authority(long groupCode, String userAuthority, String adminAuthority) {
		super();
		this.groupCode = groupCode;
		this.userAuthority = userAuthority;
		this.adminAuthority = adminAuthority;
	}
	
	public Authority() {
		super();
	}

}
