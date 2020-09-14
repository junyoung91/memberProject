package com.hk.member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hk.member.dto.Member;
import com.hk.member.service.MemberService;

@RestController
@RequestMapping(value="/member/rest",produces="text/plain;charset=UTF-8")
public class RestMemberController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	MemberService memberService;
	
	@GetMapping(path="/listJson", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Member> memberRestListJson() {
		logger.info("/member/rest/listJson----------");
		return memberService.memberList();
	}
	
	@GetMapping(path="/listXML", produces=MediaType.APPLICATION_XML_VALUE)
	public List<Member> memberRestListXML() {
		logger.info("/member/rest/listXML----------");
		return memberService.memberList();
	}
	
	@GetMapping(path="/checkIdDup", produces=MediaType.APPLICATION_JSON_VALUE)
	public String checkIdDup(@RequestParam("email") String email) {
		logger.info("---------------------------");
		logger.info("클라이언트에서 보내온 값은======"+email);
		Member member = memberService.checkIdDup(email);
		if(member == null) {
			//못찾았음
			return "0";
		}else {
			//찾았음
			return "1"; //중복임 아이디변경
		}
		
	}
}
