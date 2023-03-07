package com.divyabharathi.empsat.Controller;

import com.divyabharathi.empsat.Model.Question;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

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
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/question")
    public JSONArray getQuestions() {
        return array ;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/question")
    public int postQuestions(@RequestBody ArrayList<Question> questionList) {
        int answer = 0;
        for (Question question: questionList) {
            answer = answer + question.getAnswer();
        }
        System.out.println("answer:"+answer);
        return answer;
    }
}
