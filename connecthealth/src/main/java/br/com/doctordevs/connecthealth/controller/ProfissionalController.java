package br.com.doctordevs.connecthealth.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctordevs.connecthealth.model.Profissional;
import br.com.doctordevs.connecthealth.service.ProfissionalService;



@RestController
@RequestMapping("/profissional")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public List<Profissional> getAllPaciente(){
        return profissionalService.getAllProfissional();

    }

    @GetMapping("/psicologos")
    public List<Profissional> getAllPsicologos(){
        return profissionalService.getAllPsicologos();

    }

    @GetMapping("/nutricionistas")
    public List<Profissional> getAllNutricionistas(){
        return profissionalService.getAllNutricionistas();

    }

    @GetMapping("/{profissionalId}")
    public Profissional getProfissional(@PathVariable("profissionalId") int profissionalId){
        return profissionalService.getProfissionalId(profissionalId);

    }

    @DeleteMapping("/{profissionalId}")  
    private void deleteProfissional(@PathVariable("profissionalId") int profissionalId)   
    {  
        profissionalService.delete(profissionalId);  
    }

    @PostMapping  
    private int saveProfissional(@RequestBody Profissional profissional)   
    {  
        profissionalService.save(profissional);
        return profissional.getprofissionalId();
    }  

    @PutMapping  
    private Profissional update(@RequestBody  Profissional profissional)   
    {  
        profissionalService.save(profissional);
        return profissional;
    }

}
