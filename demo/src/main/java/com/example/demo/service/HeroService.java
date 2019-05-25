package com.example.demo.service;


import com.example.demo.mapper.HeroMapper;
import com.example.demo.mapper.OrganizationMapper;
import com.example.demo.pojo.Hero;
import com.example.demo.pojo.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HeroService {

    @Autowired
    private HeroMapper heroMapper;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Transactional
    public void save(Hero hero) {

        Organization organization = organizationMapper.findById(hero.getOrganizationId());
        organization.setNumberOfPeople(organization.getNumberOfPeople() + 1);
        organizationMapper.update(organization);

        heroMapper.save(hero);
    }

}