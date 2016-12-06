package com.hemmy.SubjectDesign.BLL;
/**
 * @author Hemmy
 * mean:选手逻辑操作接口，有关选手信息的逻辑操作层
 * function:用于选手信息的判断，业务流程操作
 */
public interface Competitor {
	boolean isExist();//判断选手是否已被收录，即是否在该比赛选手存储文档里面；
	boolean isPasswordRight();//判断选手输入的密码是否正确；
	void loggingMessage(com.hemmy.SubjectDesign.Model.Competitor competitor);//录入选手信息
	void reviseComMessage(com.hemmy.SubjectDesign.Model.Competitor competitor);//修改该选手信息，由于选手已登录，先前的检索该选手时便可标记该选手对象，方便此函数进行修改操作
	com.hemmy.SubjectDesign.Model.Competitor searchCompetitor(String nameOrId);//根据选手名字或id，查询选手信息，返回该选手对象
	void showPicture();//显示选手照片
	
	

}
