package entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "author")
    private List<Ticket> tickets;
}
