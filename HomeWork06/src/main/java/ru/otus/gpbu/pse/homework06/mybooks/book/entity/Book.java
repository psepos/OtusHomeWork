package ru.otus.gpbu.pse.homework06.mybooks.book.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.otus.gpbu.pse.homework06.mybooks.author.entity.Author;
import ru.otus.gpbu.pse.homework06.mybooks.comment.entity.Comment;
import ru.otus.gpbu.pse.homework06.mybooks.genre.entity.Genre;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(targetEntity = Comment.class, mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBook(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setBook(null);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}
