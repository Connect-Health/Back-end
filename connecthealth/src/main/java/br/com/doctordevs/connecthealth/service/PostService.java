package br.com.doctordevs.connecthealth.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PostService {

    private PostRepository postRepository;

    public PostService(Connection connection) {
        this.postRepository = new PostRepository(connection);
    }

    public void createPost(Post post) {
        try {
            postRepository.createPost(post);
            System.out.println("Post criado com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o post: " + e.getMessage());
        }
    }

    public List<Post> getAllPosts() {
        try {
            return postRepository.getAllPosts();
        } catch (SQLException e) {
            System.out.println("Erro ao obter os posts: " + e.getMessage());
            return null;
        }
    }
}
