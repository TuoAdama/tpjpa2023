package entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.util.Calendar;
import java.util.List;

@Entity
@Data
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Author author;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    @ManyToMany
    private List<Tag> tags;

    @Column
    private boolean solve;
    @Column
    private String title;
    @Column
    private String content;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar updatedAt;

}
