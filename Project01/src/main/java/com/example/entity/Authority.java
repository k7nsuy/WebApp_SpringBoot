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
public class Authority {
	
	@Id
	@Column(name = "GroupCode")
	private long groupCode = 1L;
	
	@Column(name = "memberAuthority")
	private String memberAuthority;
	
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

	public String getMember() {
		return memberAuthority;
	}

	public void setUser(String memberAuthority) {
		this.memberAuthority = memberAuthority;
	}

	@Override
	public String toString() {
		return "Authority [groupCode=" + groupCode + ", memberAuthority=" + memberAuthority + "]";
	}

	public Authority(long groupCode, String memberAuthority) {
		super();
		this.groupCode = groupCode;
		this.memberAuthority = memberAuthority;
	}
	
	public Authority() {
		super();
	}

}
