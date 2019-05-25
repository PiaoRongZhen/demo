package com.example.demo.mapper;

import com.example.demo.pojo.Ninja;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NinjaMapper {

    @Select("SELECT * FROM ninja WHERE id = #{id}")
    Ninja selectNinja(Integer id);

    @Delete("DELETE FROM ninja WHERE id = #{id}")
    int deleteNinja(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO ninja(name, skill1, skill2, skill3) VALUES(#{name}, #{skill1}, #{skill2}, #{skill3})")
    int insertNinja(Ninja ninja);

    @Update("UPDATE ninja SET name = #{name}, skill1 = #{skill1}, skill2 = #{skill2}, skill3 = #{skill3} WHERE id = #{id}")
    int updateNinja(Ninja ninja);

}
