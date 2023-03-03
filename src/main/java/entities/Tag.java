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
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    @JsonIgnore
    @Setter(AccessLevel.NONE)
    private List<Ticket> tickets;

    @Column
    private String label;
}
