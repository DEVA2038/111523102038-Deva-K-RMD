package com.example.demo.repository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Recipes;

@Repository
public interface RecipesRepo extends MongoRepository<Recipes, String> {

    List<Recipes> findAllByOrderByRatingDesc();
    
}