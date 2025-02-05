package com.vaibhav25_mnnit.springcrud.controller;


import com.vaibhav25_mnnit.springcrud.entity.Avenger;
import com.vaibhav25_mnnit.springcrud.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AvengerController {

    private AvengerService theAvengerService;

    @Autowired
    public AvengerController(AvengerService theAvengerService)
    {
        this.theAvengerService = theAvengerService;
    }

    @GetMapping("/avenger/list")
    public String getAllEmployee(Model theModel){
        List<Avenger> theAvengers = theAvengerService.getAll();
        System.out.println(theAvengers);
        theModel.addAttribute("avengers",theAvengers);
        return "avenger/avenger-list";
    }
}
