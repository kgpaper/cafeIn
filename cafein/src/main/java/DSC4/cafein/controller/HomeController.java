package DSC4.cafein.controller;

import DSC4.cafein.domain.LoginForm;
import DSC4.cafein.domain.Member;
import DSC4.cafein.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @PostMapping("/")
    public String login(LoginForm form, HttpSession session, HttpServletResponse response) throws Exception{

        Member member = new Member();
        member = firebaseService.getMemberDetail(form.getLemail());

        if (member == null || form.getLpw().equals(member.getPassword())){
            return "redirect:/";
        }

        session.setAttribute("memberId", member.getEmail());
        System.out.println((String)session.getAttribute("memberId"));
        System.out.println(member.getUsername());

        return "redirect:/";

    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest request){
        session = request.getSession();
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

    @GetMapping("/mypage")
    public String mypage(HttpSession session, HttpServletRequest request, Model model) throws Exception {
        session = request.getSession();
        String memberId = (String)session.getAttribute("memberId");
        System.out.println(memberId);

        Member member = new Member();
        member = firebaseService.getMemberDetail(memberId);
        String memberName = member.getUsername();

        model.addAttribute("memberName", memberName);
        model.addAttribute("memberId", memberId);
        return "mypage";
    }
}
