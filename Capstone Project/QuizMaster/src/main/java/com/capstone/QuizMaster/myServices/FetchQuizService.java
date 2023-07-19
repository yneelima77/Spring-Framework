package com.capstone.QuizMaster.myServices;

import com.capstone.QuizMaster.model.PracticeQuizDto;
import com.capstone.QuizMaster.model.Questions;
import com.capstone.QuizMaster.model.Quiz;
import com.capstone.QuizMaster.model.QuizResponse;
import com.capstone.QuizMaster.repository.QuestionsRepo;
import com.capstone.QuizMaster.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FetchQuizService {
    @Autowired
    private QuestionsRepo questionsRepo;
    @Autowired
    private QuizRepository quizRepo;

    /**/
    public ResponseEntity<String> fetchQuiz(String langCategory, int numOfQues, String title) {

        try {
            List<Questions> questions = questionsRepo.findRandomQuestionsByCategory(langCategory, 10);

            Quiz quizModel = new Quiz();
            quizModel.setQuestions(questions);
            quizModel.setTitle(title);
            quizRepo.save(quizModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Quiz created successfully", HttpStatus.CREATED);
    }

    /*get the quiz by ID and */
    public ResponseEntity<List<PracticeQuizDto>> getPracticeQuizQuestions(long id) {
        /*for wrapping questions from table to actually display ony question with options */
        List<PracticeQuizDto> practiceQuizList = new ArrayList<>();

        try {
            /*gets the questions by ID from quizRepo and store it in quiz */
            Optional<Quiz> quizModel = quizRepo.findById(id);

            /*gets all questions from questions table through mapping of questions object in quizmodel class */
            List<Questions> questionsListFromTable = quizModel.get().getQuestions();

            /*Here have to convert the questions from questions table to wrapper class to display only question with options only */
            for (Questions questions : questionsListFromTable) {
                PracticeQuizDto pq = new PracticeQuizDto(questions.getId(), questions.getqTitle(), questions.getOptionA(), questions.getOptionB(),
                        questions.getOptionC(), questions.getOptionD());
                practiceQuizList.add(pq);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(practiceQuizList, HttpStatus.OK);
    }


    /* get the quiz by id and then get the list of questions from quiz
     * then iterate over the quizResponse to get the response and compare it with actual answers in the Questions list
     * if answer is correct it will increment the score and return the score*/
    public ResponseEntity<Integer> validateQuizResponse(Long id, List<QuizResponse> responses) {
        Quiz quizModel = quizRepo.findById(id).get();
        List<Questions> questionsList = quizModel.getQuestions();
        int answers = 0;
        int i = 0;
        for (QuizResponse quizResponse : responses) {
            if (quizResponse.getResponse().equals(questionsList.get(i).getAnswer()))
                answers++;

            i++;
        }
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

}
