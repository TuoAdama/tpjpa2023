package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Ticket implements Serializable {
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
    private boolean solve;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private LocalDateTime publishedDate;
}
