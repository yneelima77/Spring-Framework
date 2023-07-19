package com.capstone.QuizMaster.repository;

import com.capstone.QuizMaster.model.PracticeQuizDto;
import com.capstone.QuizMaster.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
