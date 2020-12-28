package DSC4.cafein.controller;

import DSC4.cafein.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @Autowired
    FirebaseService firebaseService;

    @GetMapping("/search")
    public String search() {

        return "search";
    }
}
