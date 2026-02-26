package com.example.demo.config;

import com.example.demo.model.Recipes;
import com.example.demo.repository.RecipesRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {
    private static final int BATCH_SIZE = 100;
    @Bean
    CommandLineRunner loadData(RecipesRepo recipesRepo) {
        return args -> {

            if (recipesRepo.count() > 0) {
                System.out.println("Data already exists");
                return;
            }
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                InputStream inputStream =
                        new ClassPathResource("recipes.json").getInputStream();
                Recipes[] recipesArray =
                        objectMapper.readValue(inputStream, Recipes[].class);
                List<Recipes> recipesList = Arrays.asList(recipesArray);
                List<Recipes> batch = new ArrayList<>();
                for (Recipes recipe : recipesList) {
                    if (recipe.getPrep_time() != null &&
                        recipe.getCook_time() != null) {
                        recipe.setTotal_time(
                            recipe.getPrep_time() + recipe.getCook_time()
                        );
                    }
                    batch.add(recipe);
                    if (batch.size() == BATCH_SIZE) {
                        recipesRepo.saveAll(batch);
                        batch.clear();
                    }
                }
                if (!batch.isEmpty()) {
                    recipesRepo.saveAll(batch);
                }
                System.out.println("Data loaded successfully with batch!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}