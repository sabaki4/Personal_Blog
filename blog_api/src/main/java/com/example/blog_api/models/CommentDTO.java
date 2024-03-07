package com.example.blog_api.models;



public class CommentDTO {

    private String text;
    private Long postId;
    private Long userId;

    public CommentDTO(String text, Long postId, Long userId)
    {
        this.text = text;
        this.postId = postId;
        this.userId = userId;
    }

    //POJO empty constructor
    public CommentDTO() {

    }

    //GETTERS and SETTERS
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

