package org.fkpk.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Event {
	private Integer eventId;
	private Integer memberId;
	private Integer grade;
	private Date eventRegdate;
}
