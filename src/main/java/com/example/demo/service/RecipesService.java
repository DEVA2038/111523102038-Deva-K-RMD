package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Recipes;
import com.example.demo.repository.RecipesRepo;

@Service
public class RecipesService {

    @Autowired
    private RecipesRepo recipesRepo;
    public Recipes addRecipe(Recipes recipe) {
        recipe.setTotal_time(recipe.getPrep_time() + recipe.getCook_time());
        return recipesRepo.save(recipe);
    }
    public List<Recipes> getAllRecipes(){
        return recipesRepo.findAll();
    }
    public List<Recipes> getTopRecipes(int limit) {

    List<Recipes> all = recipesRepo.findAllByOrderByRatingDesc();

    if (limit > all.size()) {
        return all;
    }

    return all.subList(0, limit);
}
}