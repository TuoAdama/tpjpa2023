package entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class Ticket {
    @Id
       @GeneratedValue
    private long id;

    @Column
    private boolean isSolve;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Timestamp publishedDate;
}
