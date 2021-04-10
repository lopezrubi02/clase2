package com.example.clase2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carro")
public class CarroController {

    @GetMapping("/form")
    public String formCarro(){
        return "formCarro";
    }

    @PostMapping("/guardar")
    public String guardarCarro(@RequestParam("placa") String placa,
                               @RequestParam("color") String color,
                               @RequestParam("marca") String marca,
                               @RequestParam("anioFabricacion") Integer anioFabricacion){

        System.out.println("placa: " + placa);
        System.out.println("color: " + color);
        System.out.println("marca: " + marca);
        System.out.println("anioFabricacion: " + anioFabricacion);

        return "redirect:/";

    }

}
