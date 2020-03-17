package cell;

import java.awt.Graphics;
 
public interface Cell {
	void draw(Graphics g, int x, int y, int size);
}






























//任何对象加入集合类后，自动转变为Object类型，所以在取出的时候，需要进行强制类型转换。
//文件名: Sports.java
//public interface Sports
//{
//public void setHomeTeam(String name);
//public void setVisitingTeam(String name);
//}
//
////文件名: Football.java
//public interface Football extends Sports
//{
//public void homeTeamScored(int points);
//public void visitingTeamScored(int points);
//public void endOfQuarter(int quarter);
//}
//
////文件名: Hockey.java
//public interface Hockey extends Sports
//{
//public void homeGoalScored();
//public void visitingGoalScored();
//public void endOfPeriod(int period);
//public void overtimePeriod(int ot);
//}
//Hockey接口自己声明了四个方法，从Sports接口继承了两个方法，这样，实现Hockey接口的类需要实现六个方法。
//
//相似的，实现Football接口的类需要实现五个方法，其中两个来自于Sports接口。
//
//接口的多继承
//在Java中，类的多继承是不合法，但接口允许多继承。