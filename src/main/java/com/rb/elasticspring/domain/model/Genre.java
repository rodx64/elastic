package com.rb.elasticspring.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_GENRE")
public class Genre {
    @Id
    private Long id;
    private String name;

    @ManyToMany(mappedBy="genres")
    @JsonBackReference
    private List<Movie> movies;
}
