package com.library.services;

import com.library.models.Author;
import com.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Long id, Author authorDetails) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isEmpty()) {
            throw new IllegalArgumentException("Author not found with id " + id);
        }

        Author author = authorOptional.get();
        author.setName(authorDetails.getName());
        author.setLastName(authorDetails.getLastName());
        author.setYearOfBirth(authorDetails.getYearOfBirth());
        author.setYearOfDeath(authorDetails.getYearOfDeath());

        return authorRepository.save(author);
    }
}

