package com.hemmy.SubjectDesign.BLL;

import java.util.ArrayList;

public interface DayTable {
	com.hemmy.SubjectDesign.Model.DayTable makeTable(String name);//根据选择模式生成该比赛日程表；
	ArrayList<com.hemmy.SubjectDesign.Model.ComMessage> showDayTable(String name);//根据比赛名字，查询比赛日程
	

}
