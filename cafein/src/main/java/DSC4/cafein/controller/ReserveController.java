package DSC4.cafein.controller;

import DSC4.cafein.domain.Seat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReserveController {

    @GetMapping("/reserve")
    public String reserve(){ return "reserve"; }

    @PostMapping("/reserve")
    public String reserveSeat(Seat seat){
        System.out.println(seat.isSeat1());
        return "/reserve";
    }
}
