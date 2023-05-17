package com.example.profiltrenera;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddingColToDBController {
    @Autowired
    private AddingColToDBServices addingColToDBServices;

    public AddingColToDBController(AddingColToDBServices addingColToDBServices) {
        this.addingColToDBServices = addingColToDBServices;
    }

    @GetMapping("/addCol")
    @ResponseBody
    public String addCol(){
        addingColToDBServices.executeQueryadd();
        return "Columns are added";
    }

    @GetMapping("/dropCol")
    @ResponseBody
    public String dropCol(){
        addingColToDBServices.executeQuerydrop();
        return "Collumns are droped";
    }

}
