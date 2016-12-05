package com.hemmy.SubjectDesign.Model;

public class FullMark {
	private String name;
	
	public FullMark(Competitor competitor){
		this.name = competitor.getMessage().getName();
	}
	

}
