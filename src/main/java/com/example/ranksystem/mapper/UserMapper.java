package com.example.ranksystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user3 VALUES(#{name}, #{score})")
    void insert(@Param("name") String name, @Param("score") int score);
}
