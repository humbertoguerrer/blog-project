package com.hgn.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgn.blog.entities.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Long>{

}
