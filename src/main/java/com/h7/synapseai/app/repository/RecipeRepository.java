package com.h7.synapseai.app.repository;

import com.h7.synapseai.app.model.Recipe;
import com.h7.synapseai.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByUserOrderBySavedAtDesc(User user);

}
