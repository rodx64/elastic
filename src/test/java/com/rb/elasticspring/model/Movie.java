package com.rb.elasticspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String[] genre;
    private String title;
    private Integer year;

}
