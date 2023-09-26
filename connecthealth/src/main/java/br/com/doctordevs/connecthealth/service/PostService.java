package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.doctordevs.connecthealth.model.Post;
import br.com.doctordevs.connecthealth.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ComentarioService comentarioService;

    public List<Post> getAllPost() {
        List<Post> post = new ArrayList<Post>();
        postRepository.findAll().forEach(post1 -> post.add(post1));
        return post;
    }

    public Post getPost(int postId) {
        return postRepository.findById(postId).get();
    }

    public void delete(int postId) {
        Post post = postRepository.findById(postId).get();
        if (post != null) {
            comentarioService.removeComentarios(postId);
            postRepository.delete(post);
        }
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void update(Post post, int postId) {
        postRepository.save(post);
    }
}
