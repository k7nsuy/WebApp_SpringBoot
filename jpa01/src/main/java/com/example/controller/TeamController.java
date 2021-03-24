package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Team1;
import com.example.manager.TeamService;
import com.example.repository.TeamRepository;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value = "/insert")
	public String insertGET() {
		
		return "team_insert";
	}
	
	@RequestMapping(value = "/insertbatch")
	public String insertbatchGET() {
		
		return "team_insertbatch";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insertPOST(@ModelAttribute Team1 vo) {
		
		System.out.println(vo.toString());
		teamRepository.save(vo);
		
		return "redirect:/team/insert";
	}
	
	@RequestMapping(value = "/insertbatch",method = RequestMethod.POST)
	public String insertbatchPOST(@RequestParam(value = "id[]") long[] id,
			@RequestParam(value = "name[]") String[] name) {
		teamService.insertBatch1(id, name);
		return "redirect:/team/insertbatch";
	}
	
	@RequestMapping(value = "/list")
	public String listGET(Model model) {
		
		List<Team1> list = teamRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "team_list";
	}
	
	@RequestMapping(value = "/userlist")
	public String userlistGET(Model model,
			@RequestParam(value = "teamid") Long teamid) {
		//팀번호를 이용하여 팀 정보 가져오기
		Optional<Team1> team1 = teamRepository.findById(teamid);
		System.out.println(team1.get());
//		//팀정보 중에서 회원목록 가져오기
//		List<User1> list = team1.get().getUsers();

		//회원정보만 jsp로 전달하기
		model.addAttribute("team", team1.get());
		
		//view화면에 표시 할 jsp파일
		return "team_userlist";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(
			@RequestParam(value = "id") Long id) {
		
		teamRepository.deleteById(id);
		
		return "redirect:/team/list";
	}
	
}
