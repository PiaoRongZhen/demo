package com.example.demo.controller;

import com.example.demo.entity.Ninja;
import com.example.demo.mapper.NinjaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NinjaController {

    @Autowired
    private NinjaMapper ninjaMapper;

    @GetMapping("/selectNinja/{id}")
    public Ninja selectNinja(@PathVariable("id") Integer id) {
        return ninjaMapper.selectNinja(id);
    }

    @GetMapping("/deleteNinja/{id}")
    public int deleteNinja(@PathVariable("id") Integer id) {
        return ninjaMapper.deleteNinja(id);
    }

    @GetMapping("/insertNinja")
    public Ninja insertNinja(Ninja ninja) {
        ninjaMapper.insertNinja(ninja);
        return ninja;
    }

    @GetMapping("/updateNinja")
    public int updateNinja(Ninja ninja) {
        return ninjaMapper.updateNinja(ninja);
    }

}
