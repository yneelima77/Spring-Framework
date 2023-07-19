package com.capstone.QuizMaster.myServices;

import com.capstone.QuizMaster.model.Questions;
import com.capstone.QuizMaster.repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {
    @Autowired
    private QuestionsRepo questionsRepo;

    //Get all questions from Questions Entity
    public List<Questions> getAllQuestions() {
        return new ArrayList<>(questionsRepo.findAll());
    }

    //get Question by id
    public Optional<Questions> getQuestionById(long id){
        return questionsRepo.findById(id);
    }

    /*Get Questions by category*/
    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category){
        try{
            new ResponseEntity<>(questionsRepo.findBylangCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    /*Get Questions by level*/
    public ResponseEntity<List<Questions>> getQuestionsByLevel(String qlevel){
       try{
           new ResponseEntity<>(questionsRepo.findBylevel(qlevel), HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    /*to bulk add the array of question in quiz*/
    public void addAllQuestions(List<Questions> questionsList){
        questionsRepo.saveAll(questionsList);
    }

    /*Add questions to Questions Entity*/
    public void addQuestions(Questions questions) {
        questionsRepo.save(questions);
    }

    /*Method for updating a questions object in a repository using id of question*/
    public void updateQuestions(long id, Questions questions) {
        Optional<Questions> questionData = questionsRepo.findById(id);
    /*if question with id is present in repository the if-clause proceeds to update the Questions object using
    * get method and assign it to the _question variable and saved back to the QuestionsRepo*/
        if (questionData.isPresent()) {
            Questions _question = questionData.get();
            _question.setqTitle(questions.getqTitle());

            _question.setOptionA(questions.getOptionA());
            _question.setOptionB(questions.getOptionB());
            _question.setOptionC(questions.getOptionC());
            _question.setOptionD(questions.getOptionD());

            _question.setAnswer(questions.getAnswer());
            questionsRepo.save(_question);
        }
    }

    /*Delete the questions*/
    public void deleteQuestionById(long id){
        questionsRepo.deleteById(id);
    }

    /*Delete all questions*/
    public void deleteAllQuestions(){
        questionsRepo.deleteAll();
    }

    /**/

}
