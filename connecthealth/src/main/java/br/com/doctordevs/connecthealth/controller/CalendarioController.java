package br.com.doctordevs.connecthealth.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.doctordevs.connecthealth.model.Calendario;
import br.com.doctordevs.connecthealth.service.CalendarioService;

@RestController
@RequestMapping("/calendario")
@CrossOrigin(origins = "*")
public class CalendarioController {

    //2025

    @Autowired
    private CalendarioService calendarioService;

    @GetMapping
    public List<Calendario> getAllCalendario() {
        return calendarioService.getAllCalendario();
    }

    @GetMapping("/{calendarioId}")
    public Calendario getCalendario(@PathVariable("calendarioId") int calendarioId) {
        return calendarioService.getCalendarioId(calendarioId);
    }

    @GetMapping("/profissional/{profissionalId}")
    public List<Calendario> getCalendarioByProfissional(@PathVariable("profissionalId") int profissionalId) {
        return calendarioService.getCalendarioByProfissional(profissionalId);
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Calendario> getCalendarioByPaciente(@PathVariable("pacienteId") int pacienteId) {
        return calendarioService.getCalendarioByPaciente(pacienteId);
    }

    @GetMapping("/profissional/{profissionalId}/data/{data}")
    public List<Calendario> getCalendarioByProfissionalAndData(@PathVariable("profissionalId") int profissionalId,
            @PathVariable("data") Date data) {
        return calendarioService.getCalendarioByProfissionalAndData(profissionalId, data);
    }

    @PostMapping
    public int save(@RequestBody Calendario calendario) {
        calendarioService.save(calendario);
        return calendario.getCalendarioId();
    }

    @PutMapping
    public Calendario update(@RequestBody Calendario calendario) {
        calendarioService.save(calendario);
        return calendario;
    }

    @DeleteMapping("/{calendarioId}")
    public void delete(@PathVariable("calendarioId") int calendarioId) {
        calendarioService.delete(calendarioId);
    }

}
