package com.bogal.surveyProject.model;

import java.util.List;
import java.util.Objects;

public class Survey {

	private String id;
	private String title;
	private String desc;
	private List<Question> questions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestion(List<Question> questions) {
		this.questions = questions;
	}
	
	public Survey() {
		
	}
	
	public Survey(String id, String title, String desc, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.questions = questions;
	}
	
	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", desc=" + desc + ", question=" + questions + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
