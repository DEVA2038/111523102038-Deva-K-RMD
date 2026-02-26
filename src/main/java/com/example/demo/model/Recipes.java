package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.demo.model.Nutrients;

@Document(collection = "recipes")
public class Recipes {

    @Id
    private String id;
    private String title;
    private String cuisine;
    private Double rating;
    private Integer prep_time;
    private Integer cook_time;
    private Integer total_time;
    private String description;
    private Nutrients nutrients;
    private String serves;
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCuisine() {
        return cuisine;
    }
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    public Integer getPrep_time() {
        return prep_time;
    }
    public void setPrep_time(Integer prep_time) {
        this.prep_time = prep_time;
    }
    public Integer getCook_time() {
        return cook_time;
    }
    public void setCook_time(Integer cook_time) {
        this.cook_time = cook_time;
    }
    public Integer getTotal_time() {
        return total_time;
    }
    public void setTotal_time(Integer total_time) {
        this.total_time = total_time;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Nutrients getNutrients() {
        return nutrients;
    }
    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }
    public String getServes() {
        return serves;
    }
    public void setServes(String serves) {
        this.serves = serves;
    }
}