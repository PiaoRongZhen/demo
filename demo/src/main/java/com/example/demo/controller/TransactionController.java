package com.example.demo.controller;

import com.example.demo.pojo.Hero;
import com.example.demo.pojo.Organization;
import com.example.demo.service.HeroService;
import com.example.demo.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/hero/save")
    public Hero heroSave(Hero hero) {
        heroService.save(hero);
        return hero;
    }

    @GetMapping("/organization/save")
    public Organization organizationSave(Organization organization) {
        organizationService.save(organization);
        return organization;
    }

}
