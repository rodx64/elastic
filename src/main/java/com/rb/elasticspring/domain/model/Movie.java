package com.rb.elasticspring.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_MOVIE")
public class Movie {

    @Id
    private Long id;
    private String title;
    private String year;

    @ManyToMany
    @JoinTable(name="TB_GENRE_MOVIE",
        joinColumns= {@JoinColumn(name="movie_id")},
        inverseJoinColumns= {@JoinColumn(name="genre_id")}
    )
    @JsonManagedReference
    private List<Genre> genres;
}
