package br.com.doctordevs.connecthealth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.doctordevs.connecthealth.model.Post;

public interface PostRepository extends JpaRepository <Post, Integer> {
     
}
