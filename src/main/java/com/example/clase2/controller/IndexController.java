package com.example.clase2.controller;

import com.example.clase2.entity.Alumno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class IndexController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String homePage(Model model){

        Alumno alumno = new Alumno("Juan Perez",1111);
        model.addAttribute("alumno",alumno);
        model.addAttribute("listaAlumnos",listaAlumnos());
        return "homePage";
    }

    public ArrayList<Alumno> listaAlumnos(){
        ArrayList<Alumno> lista = new ArrayList<>();
        lista.add(new Alumno("Juan",3333));
        lista.add(new Alumno("Pedro",6666));
        lista.add(new Alumno("David",6666));
        lista.add(new Alumno("Carlos",6666));
        return lista;
    }
}
