package com.hk.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hk.member.dto.Member;
import com.hk.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	ServletContext sc;
	
	private static final Logger logger =LoggerFactory.getLogger(MemberController.class);
	
	//1)@Controller Annotation 추가 (import org.springframework.stereotype.Controller;)
	//2)URL 설정 (Get or Post 둘다)
	//		-Get만 지정하는방법 @GetMapping
	//		-Post만 지정하는방법 @PostMapping
	//		-둘다 하는방법 @RequestMapping
	//		/member/list	->Full URL 는http://localhost:9999/member/list
	//		URL 체계가 : /member  
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String memberList(Model model) {
		logger.info("처음들어옴 전체 찍기 ", toString());
		
		//3)DB접속 필요
		//Service 모듈 : Repository에 있는 이름과 동일하게 작성.. 별도의 트랜젝션.. 테이블 2개이상 사용하여 연결하는 작업이 없음..
		//Repository 모듈 : mydatis를 사용할까?
		//				-pom.xml에 관련 package를 설정 (spring-jdbc , spring-mybatis,mybatis,hikari,Datasource등등..)
		//				-root-context.xml에서 db관련 설정
		//				-상세 sql logging을 보려면 별도의 package를 설정
		//				-Mapper interface도 만들어야하고
		//				-Mapper.xml에 sql도 만들어야 하고..
		
		//DB JDBC Driver : Ojdbc6 orOjdbc8 (Oracle 11G XE)
		
		
		//서비스호출 : List<Member> 를 일반 변수에는 담을 필요가 없다..  DB에서 읽어온 내용은 jsp에서 출력하기 위해..
		//jsp에서 값을 꺼내려면 ... sc, session , request라는 곳에 저장을 해서 꺼낼수 있었는데 지금 만든건 serlvet아니여서 사용불가
		//model이라는 이름으로 저장하고 꺼낼수 있는걸 지원함
		model.addAttribute("members",memberService.memberList());
		
		return "memberList"; //servlet0context.xml에 있는 설정을 이용하여 파일을 찾아감..
		//"WEB-INF/views/memberList.jsp"
		//"redirect:/member/list
	}
	
	
	@GetMapping("/member/register")
	public String memberRegisterGet(Model model) {
		// 사용자가 입력을 할수 있도록 html만 보내준다.
		logger.info("/member/register 호출");
		return "memberRegister";
	}
	
	@PostMapping("/member/register")
	public String memberRegisterPost(Member member,Model model) {
		
		logger.info("/member/registerPost 호출");
		
		logger.info("사용자에게 입력받은 값 = " + member.toString());
		
		memberService.memberRegister(member);
		
		return "memberRegisterDone";
	}
	
	@GetMapping("/member/update")
	public String memberUpdateGet(@RequestParam("mno") int mno,Model model) {
		
		logger.info("/member/memberUpdateGet 호출");
		
		logger.info("사용자에게 입력받은 값 = " + mno);
		
		model.addAttribute("member",memberService.memberGetOne(mno));
		
		return "memberUpdateGet";
	}
	@PostMapping("/member/update")
	public String memberUpdatePost(Member member,Model model) {
		// DB에 입력되어 있는 값을 1개 조회하여 
		// model에 넣는다.
		// @RequestParam 형태로 가져옴.. 
		
		logger.info("사용자에게 입력받은 값 = " + member.toString()); //확인
		memberService.memberUpdate(member); //메소드 불러오기 
		model.addAttribute("member",member);
		return "memberUpdatePost";
	}
	@GetMapping("/member/delete")
	public String memberDeleteGet(@RequestParam("mno") int mno,Model model) {
		logger.info("/member/memberDeleteGet 호출");
		
		logger.info("사용자에게 입력받은 값 = " + mno);
		
		
		model.addAttribute("mno", mno);
		
		return "memberDeleteGet";
	}
	
	@PostMapping("/member/delete")
	public String memberDeletePost(@RequestParam("mno") int mno,Model model) {
		
		memberService.memberDelete(mno);
		
		return "memberDeletePost";
	}
	
	
	
	   @RequestMapping(value = "/upload", method = RequestMethod.POST , headers = "content-type=multipart/*")
	   //@PostMapping("/upload")
	   public String upload(@RequestParam("file") MultipartFile multipartFile,Model model) {
	      logger.info("### upload");
	      logger.info("실제 파일이름은 ? " + multipartFile.getOriginalFilename());
	      
	      File targetFile = new File(sc.getRealPath("/resources/fileupload/") + multipartFile.getOriginalFilename());

	      logger.info("파일 저장위치는 :  " + targetFile);
	      try {
	         InputStream fileStream = multipartFile.getInputStream();
	         FileUtils.copyInputStreamToFile(fileStream, targetFile);
	      } catch (IOException e) {
	         FileUtils.deleteQuietly(targetFile);
	         e.printStackTrace();
	      }
	     
	      // 실제 디렉토리와 URL은 다르다.. 
	      // URL은 http://localhost:9999/resources/fileupload/실제파일명
	      // model에 담아서 jsp에서 img로 출력 
	      
	      model.addAttribute("imgSrc", "/resources/fileupload/" + multipartFile.getOriginalFilename());
	      return "upload";
	   }
	
		
	
	
	
//	@GetMapping("/auth/login")
//	public String memberLogin(Model model) {
//		logger.info("/auth/logout 호출");
//		
//		
//		
//		
//		
//		
//		return "memberLogin";
//	}
//	
//	@PostMapping("/auth/logout")
//	public String memberLogout(Model model) {
//		logger.info("/auth/logout 호출");
//		
//		
//		
//		
//		
//		
//		return "memberLogout";
//	}
	
	
}
