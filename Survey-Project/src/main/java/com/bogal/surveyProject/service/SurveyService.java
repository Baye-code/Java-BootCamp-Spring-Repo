package com.bogal.surveyProject.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bogal.surveyProject.model.Question;
import com.bogal.surveyProject.model.Survey;


@Service
public class SurveyService {
	
	
	private static List<Survey> surveys = new ArrayList<>();
	
	static {
		
		Question question1 = new Question("Question1", 
				"Largest country in the world", "USA" , 
				Arrays.asList("USA", "India", "Russia", "China"));
			
		Question question2 = new Question("Question2",
				"Most populus Country", "China",
				Arrays.asList("India","USA","Russia","China"));
		
		Question question3 = new Question("Question3",
				"Highest GOP in the world", "USA",
				Arrays.asList("India","USA","Russia","China"));
		
		Question question4 = new Question("Question4",
				"Second largest english speaking", "India",
				Arrays.asList("India","USA","Russia","China"));
		
		
		List<Question> questions = new ArrayList<>(Arrays
				.asList(question1, question2, question3, question4));
		
		Survey survey = new Survey("survey1", "The World survey",
				"Survey about the world", questions);
		
		surveys.add(survey);
	}
	
	//**********************************************************************//
	
	static {
		
		Question question5 = new Question("Question1",
				"Fisrt Man in the Earth", "Adam",
				Arrays.asList("Neandertal","Lucie","Adam","Me"));
		
		Question question6 = new Question("Question2",
				"First programming language in 2020","Python",
				Arrays.asList("Python","C++","Java","Ruby"));
		
		Question question7 = new Question("Question3",
				"Best education system in the world", "Finlande",
				Arrays.asList("Finlande","USA","Singapour","China"));
		
		Question question8 = new Question("Question4",
				"Second largest english speaking", "India",
				Arrays.asList("India","USA","Russia","China"));
		
		
		List<Question> questions2 = new ArrayList<>(Arrays
				.asList(question5, question6, question7, question8));
		
		Survey survey2 = new Survey("survey2", "The World survey",
				"Survey about the world", questions2);
		
		surveys.add(survey2);
	}
	
	// *****************************************************************************//
	
	public List<Survey> retrieveAllSurvey(){
		return surveys;
	}
	
	
	public Survey retrieveSurveyById(String surveyId) {
		for(Survey survey : surveys) {
			if(survey.getId().equals(surveyId)) {
				return survey;
			}
		}
		return null;
	}
	
	
	public List<Question> retrieveQuestions(String surveyId){
		return retrieveSurveyById(surveyId).getQuestions();
	}
	
	
	public Question retrieveASingleQuestion(String surveyId, String questionId) {
		for(Question question : retrieveQuestions(surveyId)) {
			if(question.getId().equals(questionId)) {
				return question;
			}
		}
		return null;
	}
	
	
	private SecureRandom random = new SecureRandom();

	public Question addQuestion(String surveyId, Question question) {
		Survey survey = retrieveSurveyById(surveyId);

		if (survey == null) {
			return null;
		}

		String randomId = new BigInteger(130, random).toString(32);
		question.setId(randomId);

		survey.getQuestions().add(question);

		return question;
	}


	public void deleteQuestionWithStream(String surveyId, String questionId) {
		Survey survey = retrieveSurveyById(surveyId);

		if (survey != null) {
			List<Question> questionList = retrieveQuestions(surveyId);
			questionList.stream().filter(q -> q.getId() != questionId)
						.collect(Collectors.toList());
			survey.setQuestion(questionList);
		}	
	}
	
	public boolean deleteQuestion(String surveyId, String questionId) {
		Survey survey = retrieveSurveyById(surveyId);
		//Iterator<Survey> surveyIt = surveys.iterator();
		if(survey != null) {
			List<Question> questionList = retrieveQuestions(surveyId);
			Iterator<Question> questionIt = questionList.iterator();
			while(questionIt.hasNext()) {
				Question question = questionIt.next();				
						if(question.getId().equals(questionId)) {
							retrieveQuestions(surveyId).remove(question);
							return true;
					}
				}
		}	
		return false;
	}
	
	
//	public boolean deleteQuestion(String surveyId, String questionId) {
//		boolean result = false;
//		Iterator<Survey> surveyIt = surveys.iterator();
//		
//		while(surveyIt.hasNext()) {
//			Survey survey = surveyIt.next();
//			if(survey.getId().equals(surveyId)) {
//				for(Question question: retrieveQuestions(surveyId)) {
//					if(question.getId().equals(questionId)) {
//						retrieveQuestions(surveyId).remove(question);
//						result = true;
//					}
//				}
//			}
//		}
//		return result;
//	}

	// ************ ************** Update Funtionnality **************** ************

	public void updateQuestion(String surveyId, String questionId, Question question) {
		Survey survey = retrieveSurveyById(surveyId);
		
		if (survey != null) {
			if(retrieveASingleQuestion(surveyId, questionId) != null) {
				retrieveASingleQuestion(surveyId, questionId).setDescription(question.getDescription());
				retrieveASingleQuestion(surveyId, questionId).setCorrectAnswer(question.getCorrectAnswer());
				retrieveASingleQuestion(surveyId, questionId).setOption(question.getOption());
			}		
		}	
	}
	
	public void updateQuestionWithStream(String surveyId, String questionId, Question question) {
		Survey survey = retrieveSurveyById(surveyId);
		
		if (survey != null) {
			List<Question> questionList = retrieveQuestions(surveyId);
			questionList.stream().map(q -> {
				if(q.getId().equals(questionId)){
					q.setDescription(q.getDescription());
					q.setCorrectAnswer(question.getCorrectAnswer());
					q.setOption(question.getOption());
				}
				return q;
			}).collect(Collectors.toList());		
			survey.setQuestion(questionList);	
		}	
	}
	
	
	
}

