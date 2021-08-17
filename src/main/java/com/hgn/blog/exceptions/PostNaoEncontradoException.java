package com.hgn.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNaoEncontradoException extends NoSuchElementException {

    public PostNaoEncontradoException(String menssagem) {
        super(menssagem);
    }
}
