package cell;

import java.awt.Graphics;
 
public interface Cell {
	void draw(Graphics g, int x, int y, int size);
}






























//�κζ�����뼯������Զ�ת��ΪObject���ͣ�������ȡ����ʱ����Ҫ����ǿ������ת����
//�ļ���: Sports.java
//public interface Sports
//{
//public void setHomeTeam(String name);
//public void setVisitingTeam(String name);
//}
//
////�ļ���: Football.java
//public interface Football extends Sports
//{
//public void homeTeamScored(int points);
//public void visitingTeamScored(int points);
//public void endOfQuarter(int quarter);
//}
//
////�ļ���: Hockey.java
//public interface Hockey extends Sports
//{
//public void homeGoalScored();
//public void visitingGoalScored();
//public void endOfPeriod(int period);
//public void overtimePeriod(int ot);
//}
//Hockey�ӿ��Լ��������ĸ���������Sports�ӿڼ̳�������������������ʵ��Hockey�ӿڵ�����Ҫʵ������������
//
//���Ƶģ�ʵ��Football�ӿڵ�����Ҫʵ�������������������������Sports�ӿڡ�
//
//�ӿڵĶ�̳�
//��Java�У���Ķ�̳��ǲ��Ϸ������ӿ������̳С�