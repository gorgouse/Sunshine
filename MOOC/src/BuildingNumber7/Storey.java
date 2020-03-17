package BuildingNumber7;

import java.util.HashMap;
import java.util.Scanner;

import BuildingNumber7.Manage;
import BuildingNumber7.Dormitory;

public class Storey {
	  
      public Dormitory currentdormitory;
      
	  HashMap<String,Manage> manages = new HashMap<String,Manage>();
	 
	  public Storey()
	  {
		  manages.put("help",new ManageHelp(this) );
		  manages.put("go",new ManageGo(this) );
		  manages.put("exit",new ManageExit(this) );
          createdormitory();
	  }
	  
	   public void createdormitory()
	   {
		   Dormitory corridor,fiveZeroSixth,fiveOneZero,fiveOneTwo,fiveZeroEight,
		   xumintao,liuchenxi,wujiaheng,yangruiying,erziluojian,yangmingzheng,xiekai,liujingneng,
		   chenxuanming;
		   
		   //创造宿舍
		   corridor = new Dormitory ("走廊");
		   fiveZeroSixth= new Dormitory ("506");
		   fiveZeroEight = new Dormitory ("508");
		   fiveOneZero = new Dormitory ("510");
		   fiveOneTwo = new Dormitory ("512");
		   
		   //506
		   xumintao = new Dormitory ("3号床 许民涛");
		   yangruiying = new Dormitory ("4号床 杨瑞颖");
		   wujiaheng = new Dormitory ("2号床 伍嘉恒");
		   liuchenxi = new Dormitory ("1号 床 刘晨曦");
		   
		   //508
		   erziluojian = new Dormitory ("1号床 儿子罗健");
		  
		   
		   //510
		   liujingneng = new Dormitory ("2号床 刘静能");
		   chenxuanming = new Dormitory ("3号床 陈炫名");
		   
		   
		   //512
		   yangmingzheng = new Dormitory ("1号床 杨明镇");
		   xiekai = new Dormitory ("4号床 谢恺");
		   
		
		   
		   
		   //初始化房间的出口
		   
		   //走廊
		   corridor.setExits("forwardFourMeters",fiveZeroSixth);//506
		   corridor.setExits("forwardEightMeters",fiveZeroEight);//508
		   corridor.setExits("forwardTwelveMeters",fiveOneZero);//510
		   corridor.setExits("forwardSxiteenMeters",fiveOneTwo);//512
		   
		   //506
		   fiveZeroSixth.setExits("BedOrder1", liuchenxi);
		   fiveZeroSixth.setExits("BedOrder2", wujiaheng);
		   fiveZeroSixth.setExits("BedOrder3", xumintao);
		   fiveZeroSixth.setExits("BedOrder4", yangruiying);
		   xumintao.setExits("corridor", corridor);
		   xumintao.setExits("BedOrder1", liuchenxi);
		   xumintao.setExits("BedOrder2", wujiaheng);
		   xumintao.setExits("BedOrder4", yangruiying);
		   
		   wujiaheng.setExits("corridor", corridor);
		   wujiaheng.setExits("BedOrder1", liuchenxi);
		   wujiaheng.setExits("BedOrder", xumintao);
		   wujiaheng.setExits("BedOrder4", yangruiying);
		   
		   yangruiying.setExits("corridor", corridor);
		   yangruiying.setExits("BedOrder1", liuchenxi);
		   yangruiying.setExits("BedOrder2", wujiaheng);
		   yangruiying.setExits("BedOrder3", xumintao);
		   
		   
		   liuchenxi.setExits("corridor", corridor);
		   liuchenxi.setExits("BedOrder3", xumintao);
		   liuchenxi.setExits("BedOrder2", wujiaheng);
		   liuchenxi.setExits("BedOrder4", yangruiying);
		   
		   
		   
		   //508
		   fiveZeroEight.setExits("corridor", corridor);
		   fiveZeroEight.setExits("BedOrder1", erziluojian);
		   erziluojian.setExits("corridor", corridor);
		   
		   
		   //510
		   fiveOneZero.setExits("corridor", corridor);
		   fiveOneZero.setExits("BedOrder3", chenxuanming);
		   fiveOneZero.setExits("BedOrder2", liujingneng);
		   liujingneng.setExits("corridor", corridor);
		   chenxuanming.setExits("corridor", corridor);
		   
		   //512
		   fiveOneTwo.setExits("corridor", corridor);
		   fiveOneTwo.setExits("BedOrder1", yangmingzheng);
		   fiveOneTwo.setExits("BedOrder4", xiekai);
		   xiekai.setExits("corridor", corridor);
		   xiekai.setExits("BedOrder1", yangmingzheng);
		   yangmingzheng.setExits("corridor", corridor);
		   yangmingzheng.setExits("BedOrder4", xiekai);
		  
		   currentdormitory= corridor;
	   }
	  
	    public void PrintStart()      //打印
	 	{
	  		System.out.println();
	  		System.out.println("Hey guys,would want to pay a visit to my dormitory?");
	  		System.out.println("现在这里是7栋5楼的走廊，选择你要的操作：");
	  		System.out.println("如果不知道指令的话请输入'help'");
	  		System.out.println("准备好现在马上开始串宿舍了");
	  		System.out.println("提示：forwardFourMeters=向前走四米");
	  		System.out.println("提示：forwardEightMeters=向前走八米");
	  		System.out.println("提示：forwardTwelveMeters=向前走十二米");
	  		System.out.println("提示：forwardSxiteenMeters=向前走十六米");
	  	
	 	}
	   
	    public void goDormitory(String StepNumber){                 //进入房间
		   Dormitory nextDormitory = currentdormitory.getExit(StepNumber);
	  	
	  		if(nextDormitory == null){
	   			System.out.println("那里没有门！");
	  		}
	  		else{
	  			currentdormitory =nextDormitory ;
	   			showprompt();
	  		    }
	  		
	  		}
	   
	   
	   public void showprompt()                                      //显示当前的房间位置信息
		{
			System.out.println("现在你在"+  currentdormitory);
			System.out.println("出口有：");
			System.out.println( currentdormitory.getExitDesc());
			
	    }
	  
	   protected void play()                            //开始游戏
		{
			Scanner in = new Scanner(System.in);
			while (true){
	   			String line = in.nextLine();
	   			String[] words = line.split(" ");  //分隔开两个字符
	   			Manage manage =  manages.get(words[0]);
	   			
	   			String value="";
	   			if(words.length>1)
	   				value=words[1];
	   			
	   			if(manage!=null)
	   			{
	   				manage.doCmds(value);//words.length不大于1传进去的value为空值
	   				if(manage.isExit() )
	   					break;
	   			}
	 
			}
			in.close();
	 	}
	  
	  
	   public static void main(String[] args) {
		   
	  		Storey storey = new Storey();
	  		storey.PrintStart();
	        storey.play();
	  		
	  
	  		System.out.println("走咯现在要去饭堂了！");
	  		
	 }
	}
