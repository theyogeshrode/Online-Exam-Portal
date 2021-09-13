package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.QuestionForm;
import com.example.demo.Model.Result;
import com.example.demo.Service.QuestionService;

@Controller
public class MyController {
	
	@Autowired
	Result result;
	@Autowired
	QuestionService qService;
	
	Boolean submitted = false;
	
	@ModelAttribute("result")
	public Result getResult() {
		return result;
	}
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/submit")
	public String timer() {
	
		return "result.html";
	}
	  
	
	@PostMapping("/exam")
	public String exam(@RequestParam String username, Model m, RedirectAttributes ra) {
	
		
		submitted = false;
		result.setUsername(username);
		
		QuestionForm qForm = qService.getQuestions();
		m.addAttribute("qForm", qForm);
		
		return "exam.html";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm, Model m) {
		if(!submitted) {
			result.setTotalCorrect(qService.getResult(qForm));
			qService.saveMarks(result);
			submitted = true;
		}
		
		return "result.html";
	}
	
	@GetMapping("/marks")
	public String score(Model m) {
		List<Result> sList = qService.getTopMarks();
		m.addAttribute("sList", sList);
		
		return "marks.html";
	}

}
