package com.capstone.QuizMaster.controller;

import com.capstone.QuizMaster.model.Questions;
import com.capstone.QuizMaster.myServices.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
/*This class only work with questions entity and methods can be added or edited depends on use case*/
public class QuestionController {

    @Autowired
    private QuestionsService questionsService;
    /*To get all questions from questions table*/
    @GetMapping("/allQuestions")
    public List<Questions> getAllQuestions(@RequestParam(required = false) String title){
        return questionsService.getAllQuestions();
    }

    /*Get question by ID*/
    @GetMapping("/questions/id/{id}")
    public Optional<Questions> getQuestionById(@PathVariable("id") long id){
        return questionsService.getQuestionById(id);
    }

    /*Get Question by Category*/
    @GetMapping("/questions/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable("category") String langCategory){
        return questionsService.getQuestionsByCategory(langCategory);

    }

    /*Get questions by level*/
    /*http://localhost:8080/api/questions?level=Hard*/
    @GetMapping("/questions")
    public ResponseEntity<List<Questions>> getQuestionsByLevel(@RequestParam(value = "level") String level){
        return questionsService.getQuestionsByLevel(level);
    }



    /*To add new quiz with questions in it, by using the QuestionsRepo save() method.*/
    @PostMapping("/questions/add")
    public ResponseEntity<String> createQuiz(@RequestBody List<Questions> listQuestions){
        questionsService.addAllQuestions(listQuestions);
        return ResponseEntity.ok("Bulk questions added successfully");

    }


    /* To update a Questions in quiz, used the same save() and findById()*/
    @PutMapping("/questions/{id}")
    public void updateQuestion(@PathVariable("id") long id, @RequestBody Questions questions){
        Optional<Questions> questionData = questionsService.getQuestionById(id);
        /*if question with id is present in repository the if-clause proceeds to update the Questions object using
         * get method and assign it to the _question variable and saved back to the QuestionsRepo*/
        if (questionData.isPresent()) {
            Questions _question = questionData.get();
            _question.setqTitle(questions.getqTitle());

            _question.setLevel(questions.getLevel());

            _question.setOptionA(questions.getOptionA());
            _question.setOptionB(questions.getOptionB());
            _question.setOptionC(questions.getOptionC());
            _question.setOptionD(questions.getOptionD());

            _question.setAnswer(questions.getAnswer());
            questionsService.addQuestions(_question);
        }

    }

    /*Delete the question by id*/
    /*To delete a Question record, you simply use the deleteById() method provided by the QuestionRepo.
    Then you pass in the id of the record you want to delete*/
    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable("id") long id){
        questionsService.deleteQuestionById(id);
    }

    /*Delete all question from repo*/
    @DeleteMapping("/questions")
    public void deleteAllQuestions(){
        questionsService.deleteAllQuestions();
    }

}
