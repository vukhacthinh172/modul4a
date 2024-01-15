package ra.example.demospringmvc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ra.example.demospringmvc2.Service.ISongService;

@Controller
public class SongController {
    @Autowired
    private ISongService songService ;
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public  String home(Model model){
        model.addAttribute("list",songService.fingAllSong());
        return "Home";
    }
}
