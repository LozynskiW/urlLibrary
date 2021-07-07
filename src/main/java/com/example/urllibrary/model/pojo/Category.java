package com.example.urllibrary.model.pojo;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Category {

    private Long id;
    @NotBlank
    @NotNull
    @Length(max = 32)
    private String name;
    @Length(max = 200)
    private String description;
    @URL
    private String photoUrl;
    private Set<Url> urlSet;
}
