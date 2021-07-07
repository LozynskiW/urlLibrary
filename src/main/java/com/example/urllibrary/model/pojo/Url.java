package com.example.urllibrary.model.pojo;

import com.example.urllibrary.validation.RequiredNumberOfPools;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredNumberOfPools
@ToString
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
    private Category category;

}
