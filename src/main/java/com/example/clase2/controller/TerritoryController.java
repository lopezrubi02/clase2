package com.example.clase2.controller;

import com.example.clase2.entity.Shipper;
import com.example.clase2.entity.Territory;
import com.example.clase2.repository.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TerritoryController {

    @Autowired
    TerritoryRepository territoryRepository;

    @GetMapping("/territory")
    public String territoryList(Model model){

        model.addAttribute("territoryList",territoryRepository.findAll());

        return "territory/listTerritories";
    }

    @GetMapping("/territory/new")
    public String territoryNew(Model model){
        model.addAttribute("territoryList",territoryRepository.findAll());
        return "territory/newForm";
    }


    @PostMapping("/territory/save")
    public String TerritorySave(Territory territory){
        territoryRepository.save(territory);
        return "redirect:/territory";
    }



    @GetMapping("/territory/edit")
    public String territoryEdit(@RequestParam("territoryid") String id, Model model){
        Optional<Territory> territoryOptional = territoryRepository.findById(id);
        if(territoryOptional.isPresent()){
            Territory territory = territoryOptional.get();
            model.addAttribute("territory", territory);
            return "territory/editForm";
        }else{
            return "redirect:/territory";
        }

    }

    @GetMapping("/territory/delete")
    public String deleteTerritory(@RequestParam("idterritory") String id, Model model) {
        Optional<Territory> territoryOpt = territoryRepository.findById(id);


        if (territoryOpt.isPresent()) {
            Territory territory = territoryOpt.get();
            territoryRepository.deleteById(id);
        }
        return "redirect:/territory";
    }


}
