package com.burak.courseapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Course extends AbstractEntity implements Serializable {
    public static final long serialVersionUID=-1;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="TOPIC_ID")
    private Topic topic;
}
