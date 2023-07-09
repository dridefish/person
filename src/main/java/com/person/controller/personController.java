package com.person.controller;

import com.alibaba.druid.filter.AutoLoad;
import com.github.pagehelper.PageInfo;
import com.person.service.personService;
import com.person.vo.person;
import com.person.vo.personVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.ui.Model;
import org.springframework.ui.ModelExtensionsKt;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@Controller
public class personController {
    @Autowired
    private personService personService;
    @RequestMapping(value = "/person/page/{pagenum}",method = RequestMethod.GET)
    public String index(@PathVariable Integer pagenum, Model model){
        PageInfo<person> page = personService.getAll(pagenum);
        model.addAttribute("page",page);

        return "person_list";
    }
    @RequestMapping(value = "/toadd",method = RequestMethod.POST)
    public String add(person person){
        if (person.getSex().equals("男")){
            person.setSex("0");
        }else {
            person.setSex("1");
        }
        personService.add(person);
        System.out.println(person);
        return "redirect:/person/page/1";
    }
    @RequestMapping(value = "/selectByName",method = RequestMethod.GET)
    public String selectByName(Model model, personVo personVo , HttpSession session) {
        List<person> listperson = personService.selectByName(personVo);
        model.addAttribute("list",listperson);
        session.setAttribute("a",personVo.getName());
        session.setAttribute("b",personVo.getIDCard());


        System.out.println(listperson);
        return "person_list";
    }
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
        public String delete(@PathVariable String id){
        personService.deleteById(id);
        return "redirect:/person/page/1";
    }
    @RequestMapping(value = "/update/{id}" ,method = RequestMethod.GET)
    public String getBYId(@PathVariable String id,Model model){
        person person= personService.getById(id);
        model.addAttribute("person",person);
        return "update";
    }
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public String update(person person){
        if (person.getSex().equals("男")){
            person.setSex("0");
        }else {
            person.setSex("1");
        }
        System.out.println(person);
        personService.update(person);
        return "redirect:/person/page/1";
    }

}
