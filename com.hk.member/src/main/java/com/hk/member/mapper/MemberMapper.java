package com.hk.member.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hk.member.dto.Member;

@Repository
public interface MemberMapper {
	
	
	
	public List<Member> memberList();

	public int memberRegister(Member member);
	
	public Member memberGetOne(int mno);
	
	public int memberUpdate(Member member);

	public int memberDelete(int mno);

	public Member memberLogin(Member member);
	
	public Member checkIdDup(String email);
	
}


