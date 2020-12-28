package DSC4.cafein.controller;


import DSC4.cafein.domain.Cafe;
import DSC4.cafein.domain.Member;
import DSC4.cafein.domain.Seat;
import DSC4.cafein.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    //seat
    @GetMapping("/freeSeat")
    public String freeSeat(@RequestParam String id) throws Exception{
        return firebaseService.freeSeat(id);
    }

    @GetMapping("/occupySeat")
    public String occupySeat(@RequestParam String id) throws Exception{
        return firebaseService.occupySeat(id);
    }




//
//    //  "/reserve" 이면서 POST 했을 경우 맵핑
//    @RequestMapping(value = "/reserve", method= RequestMethod.POST)
//    public String insertSubmit(HttpServletRequest request, HttpServletResponse response){
//      //  String[] checkbox = request.getParameterValues("checkbox");
//        String checkbox = request.getParameter("checkbox");
////        if(checkbox!=null){
////            for(int i=0; i<checkbox.length; i++){
////                System.out.println("선택한체크박스 : "+checkbox[i]);
////            }
////        }
//       // return "/getMemberDetail";
//        return firebaseService.updateSeat(checkbox);
//    }
}
