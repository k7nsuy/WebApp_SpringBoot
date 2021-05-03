package org.fkpk.service;


import java.util.List;

import org.fkpk.domain.Event;
import org.fkpk.mapper.EventMapper;
import org.fkpk.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	EventMapper eventMapper;
	@Autowired
	MemberMapper memberMapper;

	@Override
	public void eventRegister(Event event) {
		eventMapper.eventRegister(event);
		memberMapper.updateEvent(event.getMemberId(), event.getGrade());
	}

	

	

}
