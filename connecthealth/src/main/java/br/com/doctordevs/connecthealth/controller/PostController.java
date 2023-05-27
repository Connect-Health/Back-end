package br.com.doctordevs.connecthealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.doctordevs.connecthealth.model.Post;
import br.com.doctordevs.connecthealth.service.PostService;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable("postId") int postId){
        return postService.getPost(postId);

    }

    @DeleteMapping("/post/{postId}")  
    private void deletePost(@PathVariable("postId") int postId)   
    {  
        postService.delete(postId);  
    }

    
    @PostMapping("/post")  
    private int savePost(@RequestBody Post post)   
    {  
        postService.save(post);  
        return post.getPostId();  
    }  

    @PutMapping("/post")  
    private Post update(@RequestBody Post post)   
    {  
        postService.save(post);  
        return post;  
    }

}
