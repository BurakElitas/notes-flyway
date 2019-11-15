package com.burak.courseapp.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class Topic extends AbstractEntity implements Serializable {

    public static final long serialVersionUID=-1;

    private String name;
    private String description;
}
