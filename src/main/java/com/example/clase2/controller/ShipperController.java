package com.example.clase2.controller;

import com.example.clase2.entity.Shipper;
import com.example.clase2.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ShipperController {

    @Autowired
    ShipperRepository shipperRepository; //si no existe lo crea bajo el patron singleton (patron de diseño)

    @GetMapping("/shipper")
    public String shipperList(Model model){

        model.addAttribute("shipperList",shipperRepository.findAll());

        return "shipper/list";
    }


    @GetMapping("/shipper/new")
    public String shipperNew(){ return "shipper/newForm"; }

    @PostMapping("/shipper/save")
    public String shipperSave(Shipper shipper, RedirectAttributes attr){ //save para guardar y actualizar, no hay update
        shipperRepository.save(shipper);
        if(shipper.getShipperid() == 0){
            attr.addFlashAttribute("msg","Usuario creado exitosamente");

        }else{
            attr.addFlashAttribute("msg","Usuario actualizado exitosamente");

        }
        return "redirect:/shipper";
    }

    @GetMapping("/shipper/edit")
    public String editShipper(@RequestParam("id") int id, Model model) {
        Optional<Shipper> shipperOpt = shipperRepository.findById(id);

        if (shipperOpt.isPresent()) {
            Shipper shipper = shipperOpt.get();
            model.addAttribute("shipper",shipper);
            return "shipper/editForm";
        }else{
            return "redirect:/shipper";
        }
    }

    @GetMapping("/shipper/delete")
    public String deleteShipper(@RequestParam("id") int id, Model model, RedirectAttributes attr) {
        Optional<Shipper> shipperOpt = shipperRepository.findById(id);
        if (shipperOpt.isPresent()) {
            Shipper shipper = shipperOpt.get();
            shipperRepository.deleteById(id);
            attr.addFlashAttribute("msg","Transportista borrado exitosamente");
            //            shipperRepository.delete(id);
        }
        return "redirect:/shipper";
    }

    @PostMapping("/shipper/search")
    public String searchShipper(@RequestParam("searchName") String searchName,
                                Model model, RedirectAttributes attr){
//        model.addAttribute("shipperList",shipperRepository.findByCompanyname(searchName));
        model.addAttribute("shipperList",shipperRepository.listarTransportistasPorNombre(searchName));
        attr.addFlashAttribute("busqueda",searchName);
       return "/shipper/list";
       // return "redirect:/shipper";
    }
}
