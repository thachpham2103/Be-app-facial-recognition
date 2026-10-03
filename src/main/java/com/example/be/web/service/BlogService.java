package com.example.be.web.service;

import com.example.be.web.doman.dto.request.blog.BlogCommentRequestDto;
import com.example.be.web.doman.dto.request.blog.BlogPostRequestDto;
import com.example.be.web.doman.dto.response.blog.BlogCommentResponseDto;
import com.example.be.web.doman.dto.response.blog.BlogPostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    BlogPostResponseDto createPost(BlogPostRequestDto dto, String username);
    Page<BlogPostResponseDto> getPosts(Pageable pageable);
    BlogPostResponseDto getPost(Long id);
    String deletePost(Long id);

    BlogCommentResponseDto addComment(Long postId, BlogCommentRequestDto dto, String username);
    Page<BlogCommentResponseDto> getComments(Long postId, Pageable pageable);

    String toggleLike(Long postId, String username);
    String toggleSave(Long postId, String username);
    String deleteComment(Long postId, Long commentId);
    Page<BlogPostResponseDto> getSavedPosts(String username, Pageable pageable);
}
