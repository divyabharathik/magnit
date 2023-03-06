package com.divyabharathi.empsat.Controller;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;

@RestController
public class QuestionsController {

    static JSONArray array;
    static {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(new File("").getAbsolutePath()+"\\src\\main\\resources\\static\\question.json"));
            array = (JSONArray) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/question")
    public JSONArray getQuestions() {
        return array ;
    }

    @PostMapping("/question")
    public JSONArray postQuestions() {
        return array ;
    }
}
