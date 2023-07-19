package com.springboot.dataJPA.repository;

import com.springboot.dataJPA.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    // Tutorial → Entity type and Long --> primary key
    //   findByPublished is a custom method()
    List<Tutorial> findByisPublished(boolean published);
}
