package DSC4.cafein.controller;

import DSC4.cafein.domain.Member;
import DSC4.cafein.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/join")
    public String join() {

        return "join";
    }

    @PostMapping("/join")
    public String create(Member member) throws Exception{

        System.out.println(member);
        firebaseService.joinMember(member);

        return "redirect:/";
    }
}
