package com.vaibhav25_mnnit.springcrud.controller;


import com.vaibhav25_mnnit.springcrud.entity.Avenger;
import com.vaibhav25_mnnit.springcrud.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/avengers")
public class AvengerController {

    private AvengerService theAvengerService;

    @Autowired
    public AvengerController(AvengerService theAvengerService)
    {
        this.theAvengerService = theAvengerService;
    }

    @GetMapping("/list")
    public String getAllEmployee(Model theModel){
        List<Avenger> theAvengers = theAvengerService.getAll();
        theModel.addAttribute("avengers",theAvengers);
        return "avenger/avenger-list";
    }

    @GetMapping("/add")
    public String saveAvenger(Model theModel){
        theModel.addAttribute("avenger",new Avenger());
        return "avenger/avenger-form";
    }

    @PostMapping("/save")
    public String saveAvengerToDb(@ModelAttribute("avenger") Avenger theAvenger)
    {
        theAvengerService.save(theAvenger);
        return "redirect:/avengers/list";
    }
}
