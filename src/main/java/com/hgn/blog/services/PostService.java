package com.hgn.blog.services;

import com.hgn.blog.DTO.PostDTO;
import com.hgn.blog.entities.Post;
import com.hgn.blog.repositories.PostRespository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRespository postRespository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PostDTO> listarTodos() {
        List<Post> post = postRespository.findAll();
        Type listType = new TypeToken<List<PostDTO>>() {
        }.getType();
        List<PostDTO> postDTOList = modelMapper.map(post, listType);
        return postDTOList;
    }

    public PostDTO buscarPorId(Long id) {
        Optional<Post> optionalPost = postRespository.findById(id);
        return toPostDTO(optionalPost.get());
    }

    public PostDTO salvarPost(PostDTO postDTO) {
        postRespository.save(toPost(postDTO));
        return (postDTO);
    }

    private Post toPost(PostDTO postDTO) {
        return modelMapper.map(postDTO, Post.class);
    }

    private PostDTO toPostDTO(Post post) {
        return modelMapper.map(post, PostDTO.class);
    }
}
