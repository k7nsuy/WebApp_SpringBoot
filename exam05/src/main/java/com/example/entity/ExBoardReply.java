package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "EXAM_BOARD_REPLY")
@SequenceGenerator(name = "SEQ",
		sequenceName = "SEQ_EXAM_BOARD_REPLY_NO",
		initialValue = 1,
		allocationSize = 1)
@Entity
public class ExBoardReply {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	@Id
	@Column(name = "REPNO")
	private Long repno = 0L;
	
	@Lob
	@Column(name = "REPCONTENT")
	private String repcontent = null;
	
	@ManyToOne
	@JoinColumn(name = "BRDNO")
	private ExBoard board;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp
	@Column(name = "REPREGDATE")
	private Date repregdate;

	public Long getRepno() {
		return repno;
	}

	public void setRepno(Long repno) {
		this.repno = repno;
	}

	public String getRepcontent() {
		return repcontent;
	}

	public void setRepcontent(String repcontent) {
		this.repcontent = repcontent;
	}

	public ExBoard getBoard() {
		return board;
	}

	public void setBoard(ExBoard board) {
		this.board = board;
	}

	public Date getRepregdate() {
		return repregdate;
	}

	public void setRepregdate(Date repregdate) {
		this.repregdate = repregdate;
	}

	@Override
	public String toString() {
		return "ExBoardReply [repno=" + repno + ", repcontent=" + repcontent + ", board=" + board + ", repregdate="
				+ repregdate + "]";
	}

	public ExBoardReply(Long repno, String repcontent, ExBoard board, Date repregdate) {
		super();
		this.repno = repno;
		this.repcontent = repcontent;
		this.board = board;
		this.repregdate = repregdate;
	}
	
	public ExBoardReply() {
		
	}
}
