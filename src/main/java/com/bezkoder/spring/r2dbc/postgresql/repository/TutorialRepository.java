package com.bezkoder.spring.r2dbc.postgresql.repository;

import com.bezkoder.spring.r2dbc.postgresql.model.Tutorial;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TutorialRepository extends R2dbcRepository<Tutorial, Integer> {
    Flux<Tutorial> findByTitleContaining(String title);

    @Query("select * from tutorial where published = :isPublished")
    Flux<Tutorial> findByPublished(boolean isPublished);
}
