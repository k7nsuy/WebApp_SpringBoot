package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CUSTOMER2") //생성될 테이블명
public class Customer {

	@Id
	@Column(name = "CSTID")
	private String cstid;
	
	@Column(name = "CSTPW")
	private String cstpw;
	
	@Column(name = "CSTNAME")
	private String cstname;
	
	@Column(name = "CSTPHONE")
	private String cstphone;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "CSTDATE")
	private Date cstdate;
	
	@Lob
	@Column(name = "CSTIMG")
	private byte[] cstimg;
	
	@Column(name = "CSTROLE")
	private String cstrole;

    // getter /setter만들기
	public String getCstid() {
		return cstid;
	}

	public void setCstid(String cstid) {
		this.cstid = cstid;
	}

	public String getCstpw() {
		return cstpw;
	}

	public void setCstpw(String cstpw) {
		this.cstpw = cstpw;
	}

	public String getCstname() {
		return cstname;
	}

	public void setCstname(String cstname) {
		this.cstname = cstname;
	}

	public String getCstphone() {
		return cstphone;
	}

	public void setCstphone(String cstphone) {
		this.cstphone = cstphone;
	}

	public Date getCstdate() {
		return cstdate;
	}

	public void setCstdate(Date cstdate) {
		this.cstdate = cstdate;
	}

	public byte[] getCstimg() {
		return cstimg;
	}

	public void setCstimg(byte[] cstimg) {
		this.cstimg = cstimg;
	}

	public String getCstrole() {
		return cstrole;
	}

	public void setCstrole(String cstrole) {
		this.cstrole = cstrole;
	}
}
