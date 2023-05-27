package br.com.doctordevs.connecthealth.controller;

import br.com.doctordevs.connecthealth.model.Post;
import br.com.doctordevs.connecthealth.service.PostService;
import java.sql.Connection;
import java.util.List;
public class PostController {
    private PostService postService;

    public PostController(Connection connection) {
        this.postService = new PostService(connection);
    }

    public void criarPost(Post post) {
        postService.createPost(post);
    }

    public List<Post> obterTodosPosts() {
        return postService.getAllPosts();
    }
}
