package animal;

import java.util.ArrayList;
import field.Location;


public abstract class Animal {   //不能实例化一个 抽象类的对象 如在main()中
	private int ageLimit;
	private int breedableAge;
	private int age;
	private boolean isAlive = true;
	
	public Animal(int ageLimit, int breedableAge) {
		this.ageLimit = ageLimit;   //年龄限制
		this.breedableAge = breedableAge;   //生育年龄
	}
	
	protected int getAge() {
		return age;
	}
	
	protected double getAgePercent() {
		return (double)age/ageLimit;
	}
	
	public abstract Animal breed();  //不含方法体
	
	public void grow() {
		age++;
		if ( age >= ageLimit ) {
			die();
		}
	}
	
	public void die() {
		isAlive = false;
	}
	
	public boolean isAlive() { 
		return isAlive; 
	}
	
	public boolean isBreedable() {
		return age >= breedableAge;
	}
	
	public Location move(Location[] freeAdj) {     //按一定的概率移动
		
		Location ret = null;
		if ( freeAdj.length>0 && Math.random() < 0.02 ) {
			ret = freeAdj[(int)(Math.random()*freeAdj.length)];
		}
		return ret;
	}
	
	@Override
	public String toString() {
		return ""+age+":"+(isAlive?"live":"dead");
	}

	public Animal feed(ArrayList<Animal> neighbour) {
		return null;
	}
	
	protected void longerLife(int inc) {
		ageLimit += inc;
	}
}



