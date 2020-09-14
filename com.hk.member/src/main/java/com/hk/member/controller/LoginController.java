package com.hk.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hk.member.service.MemberService;
import com.hk.member.dto.Member;

@Controller
@RequestMapping("/auth")    // http://localhost:9999/auth
public class LoginController {
   private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

   @Autowired
   MemberService memberService;
   
   
   @GetMapping("/login")  //http://localhost:9999/auth/login 
   public String loginGet() { 
      return "auth/loginGet";
   }
   
   @PostMapping("/login") //http://localhost:9999/auth/login
   public String loginPost(HttpSession session,Member member) { 
      // @RequestParam("email") String email, @RequestParam("pwd") String pwd 
      // 사용자가 입력한 email/passwd를 member에 담아온다.
      
      logger.info("사용자가 입력한 email / passwd = " + member.toString());
      
      // password 체크하는 service에 넘겨서 값을 받아옴..
      // 성공이면 session에 member정보 담아두고.. ../member/list로 보내고 
      // 실패면 그냥 다시 login 페이지로 이동 
      // 아래 if문은 MemberService에서 전부 구현해서 1 or 0 이렇게 보내도됨.
      Member loginMember = memberService.memberLogin(member);
      if( loginMember == null) { 
         // 패스워드가 틀렷음 ?
         logger.info("로그인 실패");
         return "auth/loginFail";
      } else {
         // 로그인 성공 
         // Session 등록
         // memberLogin Return이 Member Class임.
         logger.info("로그인 성공");
         session.setAttribute("loginMember", loginMember);
         // model 이라고 하는 보관소에 넣었음.. 
         // Servlet할때는 context , session , request , ...
         // -> Spring으로 넘어오면서.. model로 합쳐서 사용.. 
         // -> Spring을 쓰면서 Servlet할때 Session을 사용.. 
         return "redirect:../member/list";  // /auth/login 에서 ../member/list 
      }
      
   }
   
   @RequestMapping(value="/logout", method = { RequestMethod.GET , RequestMethod.POST})
   public String logout(HttpSession session) { 
      logger.info("Session 삭제 --- 로그아웃됨");
      session.invalidate();
      
      return "auth/logout";
   }
   
}