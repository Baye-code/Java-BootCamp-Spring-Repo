package com.bogal.surveyProject.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bogal.surveyProject.model.Question;
import com.bogal.surveyProject.model.Survey;
import com.bogal.surveyProject.service.SurveyService;
import java.net.URI;



@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService ss;
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> questionBySurvey(@PathVariable 
			String surveyId){
		return ss.retrieveQuestions(surveyId);
	}
	
	@GetMapping("/surveys")
	public List<Survey> ListAllSurveys(){
		return ss.retrieveAllSurvey();
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question SpecificQuestion(@PathVariable 
			String surveyId, @PathVariable String questionId){
		return ss.retrieveASingleQuestion(surveyId, questionId);
	}
	
	
	@GetMapping("/surveys/{surveyId}")
	public Survey SpecificSurvey(@PathVariable 
			String surveyId){
		return ss.retrieveSurveyById(surveyId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
    ResponseEntity<Void> add(@PathVariable String surveyId,
            @RequestBody Question question) {

        Question createdTodo = ss.addQuestion(surveyId, question);

        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
	
	@DeleteMapping("/surveys/{surveyId}/questions/{questionId}")
    public boolean deleteAQuestion(@PathVariable("surveyId") String surveyId,
            @PathVariable("questionId") String questionId) {

        boolean result = ss.deleteQuestion(surveyId, questionId);
        return result;
    }
	
//	@DeleteMapping("/surveys/{surveyId}/questions/{questionId}")
//  public void deleteAQuestion(@PathVariable("surveyId") String surveyId,
//          @PathVariable("questionId") String questionId) {
//
//      ss.deleteQuestionWithStream(surveyId, questionId);
//   
//	}
	
	@PutMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question updateQuestion(@RequestBody Question question, 
							   @PathVariable("surveyId") String surveyId,
							   @PathVariable("questionId") String questionId) {
		
		ss.updateQuestion(surveyId, questionId, question);
		return question;
	}
	

}
