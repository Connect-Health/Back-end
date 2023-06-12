package br.com.doctordevs.connecthealth.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctordevs.connecthealth.model.Calendario;
import br.com.doctordevs.connecthealth.repository.CalendarioRepository;

@Service
public class CalendarioService {

    @Autowired
    private CalendarioRepository calendarioRepository;

    public List<Calendario> getAllCalendario() {
        return calendarioRepository.findAll();
    }

    public List<Calendario> getCalendarioByProfissional(int profissionalId) {
        return calendarioRepository.findByProfissionalProfissionalId(profissionalId);
    }

    public List<Calendario> getCalendarioByPaciente(int pacienteId) {
        return calendarioRepository.findByPacientePacienteId(pacienteId);
    }

    public Calendario getCalendarioId(int calendarioId) {
        return calendarioRepository.findById(calendarioId).get();
    }

    public List<Calendario> getCalendarioByProfissionalAndData(int profissionalId, Date data) {
        return calendarioRepository.findByProfissionalProfissionalIdAndData(profissionalId, data);
    }

    public void delete(int calendarioId) {
        calendarioRepository.deleteById(calendarioId);
    }

    public void save(Calendario calendario) {
        calendarioRepository.save(calendario);
    }

    public void update(Calendario calendario) {
        calendarioRepository.save(calendario);
    }
}
