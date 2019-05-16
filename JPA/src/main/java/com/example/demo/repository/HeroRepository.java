package com.example.demo.repository;

import com.example.demo.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, Integer> {

    List<Hero> findAllByRanking(String ranking);

}
