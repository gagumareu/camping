package coke.controller.camp.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/project")
public class ProjectController {

    @GetMapping("/intro")
    public void intro(){

    }

    @GetMapping("/about")
    public void about(){

    }

    @GetMapping("/map")
    public void map(){

    }

    @GetMapping("/map2")
    public void map2(){

    }

}
