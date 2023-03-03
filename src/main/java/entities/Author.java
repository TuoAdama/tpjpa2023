package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Ticket> tickets;
}
