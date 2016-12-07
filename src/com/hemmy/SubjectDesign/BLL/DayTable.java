package com.hemmy.SubjectDesign.BLL;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface DayTable {
	com.hemmy.SubjectDesign.Model.DayTable makeTable(String name) throws ClassNotFoundException, IOException, ParseException;//鏍规嵁閫夋嫨妯″紡鐢熸垚璇ユ瘮璧涙棩绋嬭〃锛�
	ArrayList<com.hemmy.SubjectDesign.Model.ComMessage> showDayTable(String name);//鏍规嵁姣旇禌鍚嶅瓧锛屾煡璇㈡瘮璧涙棩绋�
	

}
