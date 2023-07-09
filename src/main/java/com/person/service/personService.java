package com.person.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.person.mapper.personMapper;
import com.person.vo.person;
import com.person.vo.personVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class personService {
    @Autowired
   private personMapper personMapper;


    public void add(person person) {
        personMapper.add(person);
    }

    public List<person> selectByName(personVo personVo) {
        return personMapper.selectByName(personVo);
    }

    public void deleteById(String id) {
        personMapper.deleteById(id);
    }

    public person getById(String id) {
       return personMapper.getById(id);
    }

    public void update(person person) {
        personMapper.update(person);
    }

    public PageInfo<person> getAll(Integer pagenum) {
        PageHelper.startPage(pagenum,2);
        List<person> list =personMapper.getAll();
        PageInfo<person> page= new PageInfo<person>(list,5);
        return page;
    }
}
