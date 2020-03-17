package BuildingNumber7;

public class ManageGo extends Manage {

	public ManageGo(Storey storey) {
		super(storey);
		
	}

	@Override
	public void doCmds(String word) {
		storey.goDormitory(word);
	}

}
