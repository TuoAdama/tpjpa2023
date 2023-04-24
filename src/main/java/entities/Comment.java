package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Data
public class Comment implements Serializable {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Ticket ticket;
    @OneToOne(cascade = CascadeType.MERGE)
    private Author author;
    @Column
    private String content;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Calendar createdAt;

    @Column(name = "updated_at")
    private Calendar updatedAt;
}
