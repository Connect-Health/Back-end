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
import br.com.doctordevs.connecthealth.model.Paciente;
import br.com.doctordevs.connecthealth.service.PacienteService;


@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> getAllPaciente(){
        return pacienteService.getAllPaciente();
    }

    @GetMapping("/{pacienteId}")
    public Paciente getPaciente(@PathVariable("pacienteId") int pacienteId){
        return pacienteService.getPacienteId(pacienteId);

    }

    @DeleteMapping("/{pacienteId}")  
    private void deletePaciente(@PathVariable("pacienteiId") int pacienteId)   
    {  
        pacienteService.delete(pacienteId);  
    }

    @PostMapping
    private int savePaciente(@RequestBody Paciente paciente)   
    {  
        pacienteService.save(paciente);  
        return paciente.getPacienteId();  
    }  

    @PutMapping
    private Paciente update(@RequestBody Paciente paciente)   
    {  
        pacienteService.save(paciente);  
        return paciente;  
    }

}

