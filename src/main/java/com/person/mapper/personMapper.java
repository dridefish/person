package com.person.mapper;

import com.person.vo.person;
import com.person.vo.personVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;

import java.util.List;


public interface personMapper {
    List<person> getAll();

    void add(person person);

    List<person> selectByName(@Param("vo") personVo personVo);

    void deleteById(String id);

    person getById(String id);

    void update(person person);
}
