package com.example.demo.controller;


import com.example.demo.entity.Hero;
import com.example.demo.entity.Organization;
import com.example.demo.service.HeroService;
import com.example.demo.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JPAController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/hero/save")
    public Hero heroSave(Hero hero) {
        return heroService.save(hero);
    }

    @GetMapping("/organization/save")
    public Organization organizationSave(Organization organization) {
        return organizationService.save(organization);
    }

    @GetMapping("/findAllByRanking")
    public List<Hero> findAllByRanking(@RequestParam("ranking") String ranking) {
        return heroService.findAllByRanking(ranking);
    }

}
