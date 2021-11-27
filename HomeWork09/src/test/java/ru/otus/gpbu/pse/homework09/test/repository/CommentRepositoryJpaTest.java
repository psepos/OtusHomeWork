package ru.otus.gpbu.pse.homework09.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.gpbu.pse.homework09.mybooks.HomeWork09Application;
import ru.otus.gpbu.pse.homework09.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework09.mybooks.comment.repository.CommentRepository;
import ru.otus.gpbu.pse.homework09.mybooks.common.ModelsObjectFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HomeWork09Application.class)
public class CommentRepositoryJpaTest {

    @Autowired
    private CommentRepository commentRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void contextLoads() {
        assertNotNull(commentRepository);
    }

    private static final String DESCRIPTION_FOR_EXISTENT_COMMENT = "Comment9";
    private static final long EXISTENT_COMMENT_ID = 9;
    private static final long NON_EXISTENT_COMMENT_ID = 120;

    @Test
    @Transactional
    public void getById() {
        Comment comment = commentRepository.getById(EXISTENT_COMMENT_ID);

        assertNotNull(comment);
        assertEquals(DESCRIPTION_FOR_EXISTENT_COMMENT, comment.getDescription());

        comment = commentRepository.getById(NON_EXISTENT_COMMENT_ID);
        assertNotNull(comment);

    }

    private static final String DESCRIPTION_FOR_NEW_COMMENT = "NewDescription";

    @Test
    @Transactional
    public void insert() {
        Comment newComment = ModelsObjectFactory.getComment(DESCRIPTION_FOR_NEW_COMMENT);

        assertNotNull(newComment);

        long commentId = commentRepository.save(newComment).getId();

        Comment insertedComment = commentRepository.getById(commentId);

        assertNotNull(insertedComment);
        assertEquals(DESCRIPTION_FOR_NEW_COMMENT, insertedComment.getDescription());

    }

    private static final long UPDATED_COMMENT_ID = 10;
    private static final String DESCRIPTION_BEFORE_UPDATE = "Comment10";
    private static final String DESCRIPTION_AFTER_UPDATE = "UpdateTestComment";

    @Test
    @Transactional
    public void update() {
        Comment comment = commentRepository.getById(UPDATED_COMMENT_ID);
        assertNotNull(comment);
        assertEquals(DESCRIPTION_BEFORE_UPDATE, comment.getDescription());

        comment.setDescription("UpdateTestComment");

        commentRepository.save(comment);

        Comment updatedCommentOpt = commentRepository.getById(UPDATED_COMMENT_ID);

        assertNotNull(updatedCommentOpt);
        assertEquals(DESCRIPTION_AFTER_UPDATE, updatedCommentOpt.getDescription());
    }

    private static final long COMMENT_ID_FOR_DELETE = 9;

    @Test
    @Transactional
    public void deleteById() {
        commentRepository.deleteById(COMMENT_ID_FOR_DELETE);
        var commentAfterDelete = commentRepository.findById(COMMENT_ID_FOR_DELETE);
        assertTrue(commentAfterDelete.isEmpty());

    }

    private static final long COMMENTS_COUNT = 10;

    @Test
    @Transactional
    public void getAll() {
        var allComments = commentRepository.findAll();
        assertNotNull(allComments);
        assertEquals(COMMENTS_COUNT, allComments.size());
    }

    @Test
    @Transactional
    public void count() {
        assertEquals(COMMENTS_COUNT, commentRepository.count());
    }
}
