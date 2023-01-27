package fr.istic.taa.jaxrs.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
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
