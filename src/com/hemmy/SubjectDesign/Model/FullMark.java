package com.hemmy.SubjectDesign.Model;
/**
 * @author Hemmy
 * mean:满分奖选手类，包含选手名字
 * function:用于满分奖的查询
 */
public class FullMark {
	private String name;
	
	public FullMark(Competitor competitor){
		this.name = competitor.getMessage().getName();
	}
	

}
