package br.com.doctordevs.connecthealth.repository;
import br.com.doctordevs.connecthealth.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
    
}
