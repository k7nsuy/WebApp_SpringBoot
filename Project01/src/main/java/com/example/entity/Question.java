package com.example.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Question")
@SequenceGenerator(name = "SEQ",
sequenceName = "seqQuestionNumber",
allocationSize = 1,
initialValue = 1)
public class Question {
	
	@Id
	@GeneratedValue(generator = "SEQ",strategy = GenerationType.SEQUENCE)
	@Column(name = "questionNumber")
	private long questionNumber;
	
	@Column(name = "questionTitle")
	private String questionTitle;
	
	@Column(name = "questionContent")
	private String questionContent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp
	@Column(name = "questionDate")
	private Date questionDate;
	
	@ManyToOne
	@JoinColumn(name = "memberNum")
	private Member member;
	
	public long getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(long questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Question [questionNumber=" + questionNumber + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", questionDate=" + questionDate + ", member=" + member + "]";
	}

	public Question(long questionNumber, String questionTitle, String questionContent, Date questionDate,
			Member member) {
		super();
		this.questionNumber = questionNumber;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.questionDate = questionDate;
		this.member = member;
	}
	
	public Question() {
		super();
	}

}
