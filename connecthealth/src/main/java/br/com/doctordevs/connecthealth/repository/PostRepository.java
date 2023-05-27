package br.com.doctordevs.connecthealth.repository;

import br.com.doctordevs.connecthealth.model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private Connection connection;

    public PostRepository(Connection connection) {
        this.connection = connection;
    }

    public void createPost(Post post) throws SQLException {
        String query = "INSERT INTO tb_post (titulo, conteudo, imagem, data_publicacao, profissional_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, post.getTitulo());
            statement.setString(2, post.getConteudo());
            statement.setBlob(3, post.getImagem());
            statement.setDate(4, post.getDataPublicacao());
            statement.setInt(5, post.getProfissionalId());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int postId = generatedKeys.getInt(1);
                post.setPostId(postId);
            }
        }
    }

    public List<Post> getAllPosts() throws SQLException {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM tb_post";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Post post = new Post();
                post.setPostId(resultSet.getInt("post_id"));
                post.setTitulo(resultSet.getString("titulo"));
                post.setConteudo(resultSet.getString("conteudo"));
                post.setImagem(resultSet.getBlob("imagem"));
                post.setDataPublicacao(resultSet.getDate("data_publicacao"));
                post.setProfissionalId(resultSet.getInt("profissional_id"));

                posts.add(post);
            }
        }
        return posts;
    }
}
