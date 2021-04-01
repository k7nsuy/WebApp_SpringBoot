package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name = "studentId")
	private String studentId;
	
	@Column(name = "studentName")
	private String studentName;
	
	@ManyToOne
	@JoinColumn(name = "teacherId")
	private Teacher teacher;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", teacher=" + teacher + "]";
	}

	public Student(String studentId, String studentName, Teacher teacher) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.teacher = teacher;
	}
	
	public Student() {
		super();
	}
	
}
