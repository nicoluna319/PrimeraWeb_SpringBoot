package com.example.primeraweb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.primeraweb.entity.Coder;
import com.example.primeraweb.services.CoderService;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/")

public class CoderController {

    @Autowired
    private CoderService objCoderService;

    /*Metodo para mostrar la lista y enviarle la lista de coders */

    @GetMapping
    public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3")int size){

        Page<Coder> list = this.objCoderService.fingPaginated(page -1, size);
        objModel.addAttribute("coderList",list);
        objModel.addAttribute("coderList",list);


        return "viewCoder";
    }

    @GetMapping("/form")
    public String showViewFormCoder(Model objModel){
        objModel.addAttribute("coderList", list);
        objModel.addAttribute("currentPage", "page");
        objModel.addAttribute("totalPages", "page");
        return "viewForm";
    }

    /*Metodo para mostrar el formulario de actualizar un coder */

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Long id ,Model objModel){
        
        Coder objCoderFind = this.objCoderService.findById(id);
        objModel.addAttribute("coder", objCoderFind);
        objModel.addAttribute("action", "/edit/" + id);
        return "viewForm";
    }

    @PostMapping("/edit/{id}")
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder objCoder){
        this.objCoderService.update(id,objCoder);
        return "redirect:/";

    }

    
    //Metodo para insertar un coder mediante el verbo post
    //@ModelAttribute se encarga de obtener la informacion enviada desde la vista
    @PostMapping("/coder/create")
    public String createCoder(@ModelAttribute Coder objCoder) {

        this.objCoderService.insert(objCoder);
        return "redirect:/";
    }

    /*Metodo para borrar */
    @GetMapping("/delete/{id}")
    public String deleteCoder(@PathVariable Long id, @ModelAttribute Coder objCoder){
        this.objCoderService.delete(id,objCoder);
        return "redirect:/";

    }
    


    

}
