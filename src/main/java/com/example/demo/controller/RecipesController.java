package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Recipes;
import com.example.demo.service.RecipesService;

@RestController
@RequestMapping("/recipes")
public class RecipesController {
    @Autowired
    private RecipesService recipesService;
    @PostMapping
    public Recipes addRecipe(@RequestBody Recipes recipe) {
        return recipesService.addRecipe(recipe);
    }
    @GetMapping("/show")
    public List<Recipes> showAllRecipes(){
        return recipesService.getAllRecipes();
    }
    @GetMapping("/top")
    public List<Recipes> getTopRecipes(@RequestParam int limit) {
        return recipesService.getTopRecipes(limit);
    }
}