package com.example.demo.service;


import com.example.demo.mapper.OrganizationMapper;
import com.example.demo.pojo.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    public void save(Organization organization) {
        organizationMapper.save(organization);

    }


}
