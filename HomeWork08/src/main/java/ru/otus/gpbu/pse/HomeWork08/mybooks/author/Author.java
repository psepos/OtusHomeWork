package ru.otus.gpbu.pse.homework08.mybooks.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data
class Author {

    private String name;

    public static Author get() {
        return new Author();
    }

    public static Author get(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }
}
