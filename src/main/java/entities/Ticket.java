package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
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
    private LocalDateTime publishedDate;
}
