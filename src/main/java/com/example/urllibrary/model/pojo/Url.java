package com.example.urllibrary.model.pojo;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Url {

    private Long id;
    @NotBlank
    @Length(max = 32)
    private String name;
    @URL
    @NotBlank
    private String link;
    @Length(max = 300)
    private String additionalInfo;
    @Length(max = 200)
    private String description;
    @FutureOrPresent
    private LocalDateTime expiryDate;

}
