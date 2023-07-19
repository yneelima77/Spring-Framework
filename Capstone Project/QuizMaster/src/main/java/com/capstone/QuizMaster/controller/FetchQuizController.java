package com.capstone.QuizMaster.controller;

import com.capstone.QuizMaster.model.PracticeQuizDto;
import com.capstone.QuizMaster.model.QuizResponse;
import com.capstone.QuizMaster.myServices.FetchQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class FetchQuizController {
    @Autowired
    private FetchQuizService fetchQuizService;

    /*http://localhost:8080/quiz/fetchQues?langCategory=Java&numOfQues=15&title=JavaQuiz*/
    @PostMapping("/fetchQues")
    public ResponseEntity<String> fetchQuestions(@RequestParam String langCategory, @RequestParam int numOfQues, @RequestParam String title) {
        return fetchQuizService.fetchQuiz(langCategory, numOfQues, title);
    }


    /*Gets the questions with options only when user requests */
    /*http://localhost:8080/quiz/fetchQuiz/1*/
    @GetMapping("/fetchQuiz/{id}")
    public String fetchQuiz(@PathVariable("id") long id, Model model) {
        List<PracticeQuizDto> practiceQuizList = fetchQuizService.getPracticeQuizQuestions(id).getBody();
        model.addAttribute("questions",practiceQuizList);
        return "quiz";

    }

    //

    //Get quiz with quiz title

    /*Once the quiz is submitted with id and request body that contain JSON of quiz then the function needs to validate to determine score */
    /*http://localhost:8080/quiz/submitQuiz/2*/
    @PostMapping("/submitQuiz/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Long id, @RequestBody List<QuizResponse> responses) {
        return fetchQuizService.validateQuizResponse(id, responses);
    }


}
