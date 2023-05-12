package br.com.doctordevs.connecthealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.doctordevs.connecthealth.model.Paciente;
import br.com.doctordevs.connecthealth.service.PacienteService;


@RestController
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/paciente")
    public List<Paciente> getAllPaciente(){
        return pacienteService.getAllPaciente();
    }

    @GetMapping("/paciente/{pacienteId}")
    public Paciente getPaciente(@PathVariable("pacienteId") int pacienteId){
        return pacienteService.getPaciente(pacienteId);

    }

    @DeleteMapping("/paciente/{pacienteId}")  
    private void deletePaciente(@PathVariable("pacienteiId") int pacienteId)   
    {  
        pacienteService.delete(pacienteId);  
    }

    @PostMapping("/paciente")  
    private int savePaciente(@RequestBody Paciente paciente)   
    {  
    pacienteService.saveOrUpdate(paciente);  
    return paciente.getPacienteId();  
    }  

    @PutMapping("/paciente")  
    private Paciente update(@RequestBody Paciente paciente)   
    {  
    pacienteService.saveOrUpdate(paciente);  
    return paciente;  
    }  
}

