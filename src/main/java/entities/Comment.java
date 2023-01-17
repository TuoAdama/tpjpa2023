package entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @Column
    private String content;
}
