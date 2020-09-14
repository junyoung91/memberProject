package com.hk.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.member.dto.Member;
import com.hk.member.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired //componnet - scan  serlvet-context.xml
	MemberMapper memberMapper; //setConnection
	
	public List<Member> memberList() {
		
		return memberMapper.memberList();
	}
	
	public int memberRegister(Member member) {
		
		int retVal = memberMapper.memberRegister(member);
		System.out.println("확인우어우어워+retVal = " + retVal);
		return retVal;
	
	}
	
	public Member memberGetOne(int mno) {
		
		return memberMapper.memberGetOne(mno);
	}
	
	public int memberUpdate(Member member) { 
		int retVal = memberMapper.memberUpdate(member);
		return retVal;
	}

	public int memberDelete(int mno) {
		// TODO Auto-generated method stub
		int retVal = memberMapper.memberDelete(mno);
		return retVal;
	}
	
	public Member memberLogin(Member member) {
		
		return memberMapper.memberLogin(member);
		
	}
	
	public Member checkIdDup(String email) {
		
		return memberMapper.checkIdDup(email);
		
	}
	

}
