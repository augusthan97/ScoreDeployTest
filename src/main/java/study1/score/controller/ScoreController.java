package study1.score.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import study1.score.domain.dto.ScoreDTO;
import study1.score.domain.entities.Score;
import org.modelmapper.ModelMapper;
import study1.score.service.ScoreService;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ScoreController {

    private final ModelMapper modelMapper = new ModelMapper();

    private final ScoreService scoreService;

    @GetMapping("/")
    public String goMain(Model model, ScoreDTO scoreDTO) {
        return "main";
    }

    @RequestMapping("/save")
    public String prcSave(ScoreDTO scoreDTO) {
        scoreDTO.setTot(scoreService.setTotal(scoreDTO));
        scoreDTO.setAvg(scoreService.setAverage(scoreDTO));
        scoreDTO.setHak(scoreService.setHakcha(scoreDTO));
        scoreDTO.setRank(1);

        Score score = modelMapper.map(scoreDTO,Score.class);
        scoreService.save(score);
        return "redirect:/";
    }

    @RequestMapping("/listdata")
    public String goList(Model model) {
        scoreService.updateRank();
        List<Score> scoreList = scoreService.findAll();
        model.addAttribute("scorelist", scoreList);
        return "listdata";
    }
}
