package DSC4.cafein.controller;


import DSC4.cafein.domain.Cafe;
import DSC4.cafein.domain.Member;
import DSC4.cafein.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/insertMember")
    public String joinMember(@RequestParam Member member) throws Exception{
        return firebaseService.joinMember(member);
    }

    @GetMapping("/getMemberDetail")
    public Member getMemberDetail(@RequestParam String id) throws Exception{
        return firebaseService.getMemberDetail(id);
    }

    @GetMapping("/updateMember")
    public String updateMember(@RequestParam Member member) throws Exception{
        return firebaseService.updateMember(member);
    }

    @GetMapping("/deleteMember")
    public String deleteMember(@RequestParam String id) throws Exception{
        return firebaseService.deleteMember(id);
    }

    //Cafe
    @GetMapping("/getCafeDetail")
    public Cafe getCafeDetail(@RequestParam String id) throws Exception{
        return firebaseService.getCafeDetail(id);
    }
}
