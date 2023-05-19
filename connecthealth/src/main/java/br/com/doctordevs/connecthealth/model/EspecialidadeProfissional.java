package br.com.doctordevs.connecthealth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_especialidade_profissional")
public class EspecialidadeProfissional {
    
    @Id
    @ManyToOne
    @JoinColumn(nullable = false, name = "profissional_id")
    private Profissional profissionalId;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false, name = "especialidade_id")
    private Especialidade especialidadeId;

    public Profissional getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Profissional profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Especialidade getEspecialidadeId() {
        return especialidadeId;
    }

    public void setEspecialidadeId(Especialidade especialidadeId) {
        this.especialidadeId = especialidadeId;
    }
}
