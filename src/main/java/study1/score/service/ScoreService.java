package study1.score.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study1.score.domain.dto.ScoreDTO;
import study1.score.domain.entities.Score;
import study1.score.repository.ScoreRepository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor

public class ScoreService {

    private final ScoreRepository scoreRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    //DB에 저장
    @Transactional
    public void save(Score score) {
        scoreRepository.save(score);
    }

    //DB의 데이터 불러오기
    @Transactional
    public List<Score> findAll() {
        return scoreRepository.findAll();
    }

    //DB 초기화
    @Transactional
    public void deleteAllData() {
        scoreRepository.deleteAll();
    }

    //석차 구하기
    @Transactional
    public void updateRank() {
        List<Score> list1 = scoreRepository.findAll();

        for (Score i : list1) {
            i.setRank(1);
            System.out.println("랭크 초기화");
            for (Score j : list1) {
                if (i.getTot() < j.getTot()) {
                    i.setRank(i.getRank() + 1);
                    System.out.println("랭크 증가");
                }
            }
        }

        Score score = modelMapper.map(list1, Score.class);
    }

    @Transactional
    public int setTotal(ScoreDTO scoreDTO) {
        int total = scoreDTO.getKor() + scoreDTO.getEng() + scoreDTO.getMat();
        return total;
    }

    @Transactional
    public Double setAverage(ScoreDTO scoreDTO) {
        double avg = (double) scoreDTO.getTot() / 3;
        return avg;
    }

    @Transactional
    public char setHakcha(ScoreDTO scoreDTO) {
        char hakcha = ' ';
        double avg = scoreDTO.getAvg();
        if (avg >= 90) {
            hakcha = 'A';
        }
        else if (avg >= 80) {
            hakcha = 'B';
        }
        else if (avg >= 70) {
            hakcha = 'C';
        }
        else if (avg >= 60) {
            hakcha = 'D';
        }
        else {
            hakcha = 'F';
        }
        return hakcha;
    }
}
