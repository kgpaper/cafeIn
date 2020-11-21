package DSC4.cafein.controller;

import DSC4.cafein.domain.Member;
import DSC4.cafein.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class MemberController {
   @Autowired
    private MemberService memberService;

   @GetMapping("/login") //Get value
    public ModelAndView login(){
       ModelAndView mav = new ModelAndView("login");
       mav.addObject("member",new Member());
       return mav;
   }

   @PostMapping("/login") //Post value
    public String login(@ModelAttribute("member") Member member){
       Member oauthMember = memberService.login(member.getName(),member.getPw());
       System.out.print(oauthMember);
       if(Objects.nonNull(oauthMember)){
           return "redirect:/";
       }
       else{
           return "redirect:/login";
       }
   }
  /*  @Autowired
    FirebaseService firebaseService;

    @GetMapping("/getAllMembers")
    public Member getAllMember(@RequestHeader() String name){
        return new Member(name,"e@mail.com","123");
    }

    @PostMapping("/createMember")
    public Member createMember(@RequestBody Member member){
        return firebaseService.;
    }*/
}
