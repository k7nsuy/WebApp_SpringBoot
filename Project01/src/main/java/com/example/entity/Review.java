package com.example.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "review")
@SequenceGenerator(name = "SEQ",
sequenceName = "seqReviewNumber",
allocationSize = 1,
initialValue = 1)
public class Review {

	@Id
	@GeneratedValue(generator = "SEQ",strategy = GenerationType.SEQUENCE)
	@Column(name = "reviewNumber")
	private long reviewNumber;
	
	@Column(name = "reviewTitle")
	private String reviewTitle;
	
	@Column(name = "reviewContent")
	private String reviewContent;
	
	@Column(name = "reviewHit")
	private Long reviewHit = 1L;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@CreationTimestamp
	@Column(name = "reviewDate")
	private Date reviewDate;
	
	@Lob
	@Column(name = "reviewImage")
	private byte[] reviewImage;
	
	@Column(name = "reviewRating")
	private long reviewRating;
	
	@Transient
	private String base64;
	
	@ManyToOne
	@JoinColumn(name = "memberNum")
	private Member member2;
	
	@OneToMany(mappedBy = "review")
	private List<ReviewReply> reviewReply = new ArrayList<>();
	
	public List<ReviewReply> getReviewReply() {
		return reviewReply;
	}

	public void setReviewReply(List<ReviewReply> reviewReply) {
		this.reviewReply = reviewReply;
	}

	public long getReviewNumber() {
		return reviewNumber;
	}

	public void setReviewNumber(long reviewNumber) {
		this.reviewNumber = reviewNumber;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Long getReviewHit() {
		return reviewHit;
	}

	public void setReviewHit(Long reviewHit) {
		this.reviewHit = reviewHit;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public byte[] getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(byte[] reviewImage) {
		this.reviewImage = reviewImage;
	}

	public long getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(long reviewRating) {
		this.reviewRating = reviewRating;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Member getMember2() {
		return member2;
	}

	public void setMember2(Member member2) {
		this.member2 = member2;
	}

	@Override
	public String toString() {
		return "Review [reviewNumber=" + reviewNumber + ", reviewTitle=" + reviewTitle + ", reviewContent="
				+ reviewContent + ", reviewHit=" + reviewHit + ", reviewDate=" + reviewDate + ", reviewImage="
				+ Arrays.toString(reviewImage) + ", reviewRating=" + reviewRating + ", base64=" + base64 + ", member2="
				+ member2 + "]";
	}

	public Review(long reviewNumber, String reviewTitle, String reviewContent, Long reviewHit, Date reviewDate,
			byte[] reviewImage, long reviewRating, String base64, Member member2) {
		super();
		this.reviewNumber = reviewNumber;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewHit = reviewHit;
		this.reviewDate = reviewDate;
		this.reviewImage = reviewImage;
		this.reviewRating = reviewRating;
		this.base64 = base64;
		this.member2 = member2;
	}

	public Review() {
		super();
	}
}
