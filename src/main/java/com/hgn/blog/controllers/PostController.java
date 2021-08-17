package com.hgn.blog.controllers;

import com.hgn.blog.DTO.PostDTO;
import com.hgn.blog.exceptions.PostNaoEncontradoException;
import com.hgn.blog.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/posts")
@Api(value = "Posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    @ApiOperation(value = "Lista todos os posts.")
    public List<PostDTO> listarTodosPosts() {
        return postService.listarTodos();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Exibe um post por ID.")
    public ResponseEntity<PostDTO> buscarPostPorId(@PathVariable Long id) {
        try {
            PostDTO postDTO = postService.buscarPorId(id);
            return ResponseEntity.ok().body(postDTO);
        } catch (NoSuchElementException e) {
            throw new PostNaoEncontradoException("O post procurado não existe.");
        }
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo post.")
    public ResponseEntity<String> salvarPost(@Valid @RequestBody PostDTO postDTO) {
        postService.salvarPost(postDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("O post foi publicado.");
    }

    // patch upvote

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Apaga um post.")
    public void deletarPostPorID(@PathVariable Long id) throws PostNaoEncontradoException {
        postService.apagaPorID(id);
    }

}
