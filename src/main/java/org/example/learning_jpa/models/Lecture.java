package org.example.learning_jpa.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity{

    private String name;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Section section;

    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resources resources;
}
