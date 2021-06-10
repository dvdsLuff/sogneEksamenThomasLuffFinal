package com.example.sogneeksamen.Controllers;

import com.example.sogneeksamen.model.Kommune;
import com.example.sogneeksamen.model.Sogne;
import com.example.sogneeksamen.repository.SogneRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class WebController {
    @Autowired
    SogneRepository sogneRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Sogne> sogne;
        sogne = sogneRepository.findAll();
        model.addAttribute("sogneList", sogne);
        return "index";
    }

    @GetMapping("/create")
    public String create() {


        return "create";
    }

    @PostMapping("/create")
    public String create(@RequestParam("sognekode") int sognekode,
                         @RequestParam("navn") String navn,
                         @RequestParam("kommune") Kommune kommune,
                         @RequestParam("smittetryk") double smittetryk,
                         @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart) {


        Sogne nsogne = new Sogne(sognekode, navn, kommune, smittetryk, nedlukningStart);

        sogneRepository.save(nsogne);


        return "redirect:/";
    }

    /// skal nok ikke være sogne kode da jeg deleter på id
    @PostMapping("/delete")
    public String delete(@RequestParam("sognekode") int sognekode) {
        sogneRepository.deleteById(sognekode);

        return "redirect:/";

    }

    @GetMapping("/delete")
    public String delete() {

        return "delete";
    }

    @GetMapping("/update")
    public String update() {

        return "update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id,
                         @RequestParam("sognekode") int sognekode,
                         @RequestParam("navn") String navn,
                         @RequestParam("kommune") Kommune kommune,
                         @RequestParam("smittetryk") double smittetryk,
                         @RequestParam("nedlukningStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date nedlukningStart,
                         @RequestParam(value = "erNedlukket", defaultValue = "false") Boolean ernedlukket) {

        Sogne nsogne = new Sogne(id, sognekode, navn, kommune, smittetryk, nedlukningStart, ernedlukket);
        sogneRepository.save(nsogne);

        return "redirect:/";
    }

}
