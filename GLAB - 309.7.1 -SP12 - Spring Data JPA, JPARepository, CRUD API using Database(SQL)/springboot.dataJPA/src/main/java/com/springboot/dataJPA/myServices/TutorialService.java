package com.springboot.dataJPA.myServices;

import com.springboot.dataJPA.model.Tutorial;
import com.springboot.dataJPA.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;
    public List<Tutorial> getAllTutorials(){
        return new ArrayList<Tutorial>(tutorialRepository.findAll());
    }

    public Optional<Tutorial> getTutorialById(Long id){
        return tutorialRepository.findById(id);
    }

    public void addTutorial(Tutorial tutorial){
        tutorialRepository.save(tutorial);
    }

    public  void updateTutorial(Long id, Tutorial tutorial){
         Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            tutorialRepository.save(_tutorial);
        }
    }
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    public ResponseEntity<List<Tutorial>> findByPublished() {
        try {
            List<Tutorial> tutorials = tutorialRepository.findByisPublished(true);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
