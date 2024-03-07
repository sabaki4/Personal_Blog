package com.example.blog_api.services;

import com.example.blog_api.models.Comment;
import com.example.blog_api.models.CommentDTO;
import com.example.blog_api.models.Post;
import com.example.blog_api.repositories.CommentRepository;
import com.example.blog_api.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;

    //Gets a list of all comments
    public List<Comment> getAllComments()
    {
        return commentRepository.findAll();
    }

    //Creates a new comment in Post
    public Comment addComment(CommentDTO commentDTO) {
        //Finds username using userId
        String username = userService.findUser(commentDTO.getUserId()).getName();
        //Finding post by its post id
        Post post = postRepository.findById(commentDTO.getPostId()).get();
        //Created a comment that shows username
        //If post and user exists, save the comment
        if (post == null && username == null)
        {
            return null;
        }
            //Created Comment object
            Comment comment = new Comment(
                    post,
                    commentDTO.getText(),
                   false,
                    username);

            commentRepository.save(comment);
            return comment;
    }

    //Gets a comment by id
    public Optional <Comment> getCommentById(Long id)
    {
        return commentRepository.findById(id);
    }

    //Updates a specific comment
    public Comment updateComment(CommentDTO commentDTO, long id) // updated comment
    {
        //Finding post by its post id
        Post post = postRepository.findById(commentDTO.getPostId()).get();

        Comment updatedComment = commentRepository.findById(id).get();
        updatedComment.setText(commentDTO.getText());
        updatedComment.setIsEdited(true);
        updatedComment.getUserName();
        commentRepository.save(updatedComment);
        return updatedComment;
    }

    //Deletes a specific comment
    public void deleteCommentById(Long id)
    {
        commentRepository.delete(getCommentById(id).get());
    }

}
