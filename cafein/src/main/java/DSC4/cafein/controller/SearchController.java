package DSC4.cafein.controller;

import DSC4.cafein.domain.Cafe;
import DSC4.cafein.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/search")
    public String search(Model model) throws Exception {

        Cafe cafe = new Cafe();
        cafe = firebaseService.getCafeDetail("cafe1");

        String occupied_s = Integer.toString(cafe.getOccupied_s());
        String total_s = Integer.toString(cafe.getTotal_s());

        System.out.println(occupied_s);
        System.out.println(total_s);


        model.addAttribute("occupied_s", occupied_s);
        model.addAttribute("total_s", total_s);

        return "search";
    }
}
