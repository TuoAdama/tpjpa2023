package fr.istic.taa.jaxrs.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Ticket ticket;
    @Column
    private String title;
    @Column
    private String content;
}
