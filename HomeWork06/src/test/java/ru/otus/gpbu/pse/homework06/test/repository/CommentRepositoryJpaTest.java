package ru.otus.gpbu.pse.homework06.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework06.mybooks.HomeWork06Application;
import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework06.mybooks.comment.repository.CommentRepository;
import ru.otus.gpbu.pse.homework06.mybooks.common.ModelsObjectFactory;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HomeWork06Application.class)
public class CommentRepositoryJpaTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void contextLoads() {
        assertNotNull(commentRepository);
    }

    private static final String DESCRIPTION_FOR_EXISTENT_COMMENT = "Comment9";
    private static final long EXISTENT_COMMENT_ID = 9;
    private static final long NON_EXISTENT_COMMENT_ID = 120;

    @Test
    public void getById() {
        Optional<Comment> comment = commentRepository.getById(EXISTENT_COMMENT_ID);

        assertNotNull(comment);
        assertTrue(comment.isPresent());
        assertEquals(DESCRIPTION_FOR_EXISTENT_COMMENT, comment.get().getDescription());

        comment = commentRepository.getById(NON_EXISTENT_COMMENT_ID);
        assertNotNull(comment);
        assertTrue(comment.isEmpty());
    }

    private static final String DESCRIPTION_FOR_NEW_COMMENT = "NewDescription";

    @Test
    @Transactional
    public void insert() {
        Comment newComment = ModelsObjectFactory.getComment(DESCRIPTION_FOR_NEW_COMMENT);

        assertNotNull(newComment);

        long commentId = commentRepository.insert(newComment);

        Optional<Comment> insertedComment = commentRepository.getById(commentId);

        assertNotNull(insertedComment);
        assertTrue(insertedComment.isPresent());
        assertEquals(DESCRIPTION_FOR_NEW_COMMENT, insertedComment.get().getDescription());

    }

    private static final long UPDATED_COMMENT_ID = 10;
    private static final String DESCRIPTION_BEFORE_UPDATE = "Comment10";
    private static final String DESCRIPTION_AFTER_UPDATE = "UpdateTestComment";

    @Test
    @Transactional
    public void update() {
        Optional<Comment> commentOpt = commentRepository.getById(UPDATED_COMMENT_ID);
        assertNotNull(commentOpt);
        assertTrue(commentOpt.isPresent());
        assertEquals(DESCRIPTION_BEFORE_UPDATE, commentOpt.get().getDescription());

        Comment comment = commentOpt.get();
        comment.setDescription("UpdateTestComment");

        commentRepository.update(comment);

        Optional<Comment> updatedCommentOpt = commentRepository.getById(UPDATED_COMMENT_ID);

        assertNotNull(updatedCommentOpt);
        assertTrue(updatedCommentOpt.isPresent());
        assertEquals(DESCRIPTION_AFTER_UPDATE, updatedCommentOpt.get().getDescription());
    }


    @Test
    @Transactional
    public void deleteById() {

    }

    @Test
    public void getAll() {

    }

    @Test
    public void count() {

    }
}
