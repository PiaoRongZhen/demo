package com.example.demo.service;

import com.example.demo.entity.Hero;
import com.example.demo.entity.Organization;
import com.example.demo.repository.HeroRepository;
import com.example.demo.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Transactional
    public Hero save(Hero hero) {

        Organization organization = organizationRepository.findById(hero.getOrganizationId()).get();
        organization.setNumberOfPeople(organization.getNumberOfPeople() + 1);
        organizationRepository.save(organization);

        return heroRepository.save(hero);
    }

    public List<Hero> findAllByRanking(String ranking) {
        return heroRepository.findAllByRanking(ranking);
    }

}