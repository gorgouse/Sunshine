package BuildingNumber7;

public class ManageHelp extends Manage {

	public ManageHelp(Storey storey) {
		super(storey);
	}

	@Override
	public void doCmds(String word) {
		System.out.println("不知道宿舍怎么走吗吗？你可以做的命令有：go bye help");
  		System.out.println("如：go+宿舍");
		
	}
  
	
	
}
