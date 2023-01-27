package fr.istic.taa.jaxrs.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "ticket")
    private List<Comment> comments;

    @ManyToMany
    private List<Tag> tags;

    @Column
    private boolean isSolve;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Timestamp publishedDate;
}
