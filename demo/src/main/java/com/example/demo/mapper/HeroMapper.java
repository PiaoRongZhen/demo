package com.example.demo.mapper;


import com.example.demo.pojo.Hero;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface HeroMapper {

    @Insert("INSERT INTO hero(name, organization_id) VALUES(#{name}, #{organizationId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Hero hero);
}
