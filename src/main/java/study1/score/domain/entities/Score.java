package study1.score.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Score {

    @Id
    private int num;

    @Column(length = 30)
    private String name;

    @Column(precision = 3)
    private int kor;

    @Column(precision = 3)
    private int eng;

    @Column(precision = 3)
    private int mat;

    @Column(precision = 3)
    private int tot;

    @Column(precision = 3, scale = 1)
    private double avg;

    @Column
    private char hak;

    @Column
    private int rank;
}
