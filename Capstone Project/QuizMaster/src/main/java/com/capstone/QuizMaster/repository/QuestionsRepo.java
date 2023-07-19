package com.capstone.QuizMaster.repository;

import com.capstone.QuizMaster.model.Questions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("Questions")
@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Long> {
   public List<Questions> findBylangCategory(String langCategory);
   public List<Questions> findBylevel(String level);

   /*Here have to map many ot many relation between questions and quiz tables
   USING NATIVE QUERY OD DATA JPA(jpql query) TO FETCH THE RANDOM QUESTIONS and limiting them to numOfQues which is basically 15 per quiz */
   @Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numOfQues", nativeQuery = true)
   List<Questions> findRandomQuestionsByCategory(@Param("category") String category, @Param("numOfQues") int numOfQues);

}
