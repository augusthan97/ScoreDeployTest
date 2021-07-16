package study1.score.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study1.score.domain.entities.Score;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {



}
