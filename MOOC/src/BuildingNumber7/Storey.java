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
		   
		   //��������
		   corridor = new Dormitory ("����");
		   fiveZeroSixth= new Dormitory ("506");
		   fiveZeroEight = new Dormitory ("508");
		   fiveOneZero = new Dormitory ("510");
		   fiveOneTwo = new Dormitory ("512");
		   
		   //506
		   xumintao = new Dormitory ("3�Ŵ� ������");
		   yangruiying = new Dormitory ("4�Ŵ� ����ӱ");
		   wujiaheng = new Dormitory ("2�Ŵ� ��κ�");
		   liuchenxi = new Dormitory ("1�� �� ������");
		   
		   //508
		   erziluojian = new Dormitory ("1�Ŵ� �����޽�");
		  
		   
		   //510
		   liujingneng = new Dormitory ("2�Ŵ� ������");
		   chenxuanming = new Dormitory ("3�Ŵ� ������");
		   
		   
		   //512
		   yangmingzheng = new Dormitory ("1�Ŵ� ������");
		   xiekai = new Dormitory ("4�Ŵ� л��");
		   
		
		   
		   
		   //��ʼ������ĳ���
		   
		   //����
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
	  
	    public void PrintStart()      //��ӡ
	 	{
	  		System.out.println();
	  		System.out.println("Hey guys,would want to pay a visit to my dormitory?");
	  		System.out.println("����������7��5¥�����ȣ�ѡ����Ҫ�Ĳ�����");
	  		System.out.println("�����֪��ָ��Ļ�������'help'");
	  		System.out.println("׼�����������Ͽ�ʼ��������");
	  		System.out.println("��ʾ��forwardFourMeters=��ǰ������");
	  		System.out.println("��ʾ��forwardEightMeters=��ǰ�߰���");
	  		System.out.println("��ʾ��forwardTwelveMeters=��ǰ��ʮ����");
	  		System.out.println("��ʾ��forwardSxiteenMeters=��ǰ��ʮ����");
	  	
	 	}
	   
	    public void goDormitory(String StepNumber){                 //���뷿��
		   Dormitory nextDormitory = currentdormitory.getExit(StepNumber);
	  	
	  		if(nextDormitory == null){
	   			System.out.println("����û���ţ�");
	  		}
	  		else{
	  			currentdormitory =nextDormitory ;
	   			showprompt();
	  		    }
	  		
	  		}
	   
	   
	   public void showprompt()                                      //��ʾ��ǰ�ķ���λ����Ϣ
		{
			System.out.println("��������"+  currentdormitory);
			System.out.println("�����У�");
			System.out.println( currentdormitory.getExitDesc());
			
	    }
	  
	   protected void play()                            //��ʼ��Ϸ
		{
			Scanner in = new Scanner(System.in);
			while (true){
	   			String line = in.nextLine();
	   			String[] words = line.split(" ");  //�ָ��������ַ�
	   			Manage manage =  manages.get(words[0]);
	   			
	   			String value="";
	   			if(words.length>1)
	   				value=words[1];
	   			
	   			if(manage!=null)
	   			{
	   				manage.doCmds(value);//words.length������1����ȥ��valueΪ��ֵ
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
	  		
	  
	  		System.out.println("�߿�����Ҫȥ�����ˣ�");
	  		
	 }
	}
