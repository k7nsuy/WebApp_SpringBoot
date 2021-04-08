package com.example.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "reviewReply")
@SequenceGenerator(name = "SEQ",
sequenceName = "SeqReviewReplyNum",
allocationSize = 1,
initialValue = 1)
public class ReviewReply {

	@Id
	@Column(name = "replyNumber")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ")
	private long replyNumber;
	
	@Column(name = "replyTitle")
	private String replyTitle;
	
	@Column(name = "replyContent")
	private String replyContent;
	
	@Column(name = "replyImage")
	private byte[] replyImage;
	
	@ManyToOne
	@JoinColumn(name = "reviewNumber")
	private Review review;
	
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	@Transient
	private String base64;

	public long getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(long replyNumber) {
		this.replyNumber = replyNumber;
	}

	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public byte[] getReplyImage() {
		return replyImage;
	}

	public void setReplyImage(byte[] replyImage) {
		this.replyImage = replyImage;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	@Override
	public String toString() {
		return "ReviewReply [replyNumber=" + replyNumber + ", replyTitle=" + replyTitle + ", replyContent="
				+ replyContent + ", replyImage=" + Arrays.toString(replyImage) + ", base64=" + base64 + "]";
	}

	public ReviewReply(long replyNumber, String replyTitle, String replyContent, byte[] replyImage, String base64) {
		super();
		this.replyNumber = replyNumber;
		this.replyTitle = replyTitle;
		this.replyContent = replyContent;
		this.replyImage = replyImage;
		this.base64 = base64;
	}
	
	public ReviewReply() {
		super();
	}
}
