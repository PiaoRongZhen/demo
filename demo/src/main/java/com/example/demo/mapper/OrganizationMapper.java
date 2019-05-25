package com.example.demo.mapper;


import com.example.demo.pojo.Organization;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrganizationMapper {

    @Select("SELECT id, name, number_of_people AS numberOfPeople FROM organization WHERE id = #{organizationId}")
    Organization findById(Integer organizationId);

    @Insert("INSERT INTO organization(name, number_of_people) VALUES(#{name}, #{numberOfPeople})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Organization organization);

    @Update("UPDATE organization SET name = #{name}, number_of_people = #{numberOfPeople} WHERE id = #{id}")
    int update(Organization organization);

}
