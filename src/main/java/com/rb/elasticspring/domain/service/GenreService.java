package com.rb.elasticspring.domain.service;

import com.rb.elasticspring.domain.model.Genre;
import com.rb.elasticspring.domain.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public List<Genre> findAllGenres(){
        return genreRepository.findAll();
    }
}
