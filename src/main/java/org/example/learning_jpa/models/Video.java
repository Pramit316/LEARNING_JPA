package org.example.learning_jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@PrimaryKeyJoinColumn(name = "video_id") //The foreign key for the video to resource table will have this as column name
//@DiscriminatorValue("F")
public class Video extends Resources{

    private int length;
}
