package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {
	
	@Id
	@Column(name = "teacherId")
	private long teacherId;
	
	@OneToMany(mappedBy = "teacher")
	private List<Student> studentList = new ArrayList<>();

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", studentList=" + studentList + "]";
	}

	public Teacher(long teacherId, List<Student> studentList) {
		super();
		this.teacherId = teacherId;
		this.studentList = studentList;
	}
	
	public Teacher() {
		super();
	}
	

}
