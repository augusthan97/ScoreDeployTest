package study1.score.domain.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ScoreDTO {

    private int num;
    private String name;
    private int kor;
    private int eng;
    private int mat;
    private int tot;
    private double avg;
    private char hak;
    private int rank;

}
