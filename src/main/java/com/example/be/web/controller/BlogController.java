package com.example.be.web.controller;

import com.example.be.web.base.RestData;
import com.example.be.web.base.VsResponseUtil;
import com.example.be.web.constant.ResponseMessage;
import com.example.be.web.doman.dto.request.blog.BlogCommentRequestDto;
import com.example.be.web.doman.dto.request.blog.BlogPostRequestDto;
import com.example.be.web.service.BlogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.ErrorMessage;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
@Tag(name="Blog  Management")
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/posts")
    @PreAuthorize("hasAnyRole('ADMIN','LEADER','USER')")
    @Operation(summary = "Tạo bài viết mới")
    public ResponseEntity<RestData<?>> createPost(
            @Valid @RequestBody BlogPostRequestDto dto,
            @AuthenticationPrincipal UserDetails userDetails) {
        return VsResponseUtil.success(HttpStatus.CREATED, blogService.createPost(dto, userDetails.getUsername()));
    }

    @GetMapping("/posts")
    @Operation(summary = "Lấy danh sách bài viết đã publish")
    public ResponseEntity<RestData<?>> getPosts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createDate").descending());
        return VsResponseUtil.success(blogService.getPosts(pageable));
    }

    @GetMapping("/posts/{id}")
    @Operation(summary = "Lấy chi tiết bài viết")
    public ResponseEntity<RestData<?>> getPost(@PathVariable Long id) {
        return VsResponseUtil.success(blogService.getPost(id));
    }

    @DeleteMapping("/posts/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','LEADER')")
    @Operation(summary = "Xóa mềm bài viết")
    public ResponseEntity<RestData<?>> deletePost(@PathVariable Long id) {
        return VsResponseUtil.success(blogService.deletePost(id));
    }

    @PostMapping("/posts/{postId}/comments")
    @PreAuthorize("hasAnyRole('ADMIN','LEADER','USER')")
    @Operation(summary = "Thêm bình luận")
    public ResponseEntity<RestData<?>> addComment(
            @PathVariable Long postId,
            @Valid @RequestBody BlogCommentRequestDto dto,
            @AuthenticationPrincipal UserDetails userDetails) {
        return VsResponseUtil.success(HttpStatus.CREATED, blogService.addComment(postId, dto, userDetails.getUsername()));
    }

    @GetMapping("/posts/{postId}/comments")
    @Operation(summary = "Lấy danh sách bình luận gốc")
    public ResponseEntity<RestData<?>> getComments(
            @PathVariable Long postId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createDate").ascending());
        return VsResponseUtil.success(blogService.getComments(postId, pageable));
    }

    @PostMapping("/posts/{postId}/like")
    @PreAuthorize("hasAnyRole('ADMIN','LEADER','USER')")
    @Operation(summary = "Like/Unlike bài viết")
    public ResponseEntity<RestData<?>> toggleLike(
            @PathVariable Long postId,
            @AuthenticationPrincipal UserDetails userDetails) {
        return VsResponseUtil.success(blogService.toggleLike(postId, userDetails.getUsername()));
    }

    @PostMapping("/posts/{postId}/save")
    @PreAuthorize("hasAnyRole('ADMIN','LEADER','USER')")
    @Operation(summary = "Lưu/Bỏ lưu bài viết")
    public ResponseEntity<RestData<?>> toggleSave(
            @PathVariable Long postId,
            @AuthenticationPrincipal UserDetails userDetails) {
        return VsResponseUtil.success(blogService.toggleSave(postId, userDetails.getUsername()));
    }

    @GetMapping("/saved")
    @PreAuthorize("hasAnyRole('ADMIN','LEADER','USER')")
    @Operation(summary = "Lấy danh sách bài đã lưu")
    public ResponseEntity<RestData<?>> getSavedPosts(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("savedAt").descending());
        return VsResponseUtil.success(blogService.getSavedPosts(userDetails.getUsername(), pageable));
    }
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    @PreAuthorize("hasAnyRole('ADMIN','LEADER','USER')")
    @Operation(summary = "Xóa bình luận")
    public ResponseEntity<RestData<?>> deleteComment(
            @PathVariable Long postId,
            @PathVariable Long commentId) {
        return VsResponseUtil.success(blogService.deleteComment(postId, commentId));
    }
}
