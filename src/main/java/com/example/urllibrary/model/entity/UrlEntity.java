package com.example.urllibrary.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "urls")
@ToString
public class UrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String link;
    private String additionalInfo;
    private String description;
    private LocalDateTime expiryDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryEntity category;
}
