package com.example.primeraweb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.primeraweb.entity.Coder;
import com.example.primeraweb.services.CoderService;



@Controller
@RequestMapping("/")

public class CoderController {

    @Autowired
    private CoderService objCoderService;

    /*Metodo para mostrar la lista y enviarle la lista de coders */

    @GetMapping
    public String showViewGetAll(Model objModel){

        List<Coder> list = this.objCoderService.findAll();
        objModel.addAttribute("coderList",list);


        return "viewCoder";
    }

    @GetMapping("/form")
    public String showViewFormCoder(){
        return "viewForm";
    }

}
