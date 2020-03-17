package BuildingNumber7;

import java.util.HashMap;

public class Dormitory {
	
	private HashMap<String,Dormitory> exits = new HashMap<String,Dormitory>();
	private String description;
	
	protected Dormitory (String description)
	{
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
	
	protected void setExits(String description ,Dormitory dormitory)
	{
		exits.put(description, dormitory);
	}
	
	protected String getExitDesc()
	{
		StringBuffer sb = new StringBuffer();
		for(String dir:exits.keySet())	//对于keyset()中的每一个key
		{
			sb.append(dir);
			sb.append(" ");
		}
		return sb.toString();  
	}
	
	protected Dormitory getExit(String StepNumber)
	{
		return exits.get(StepNumber);
	}
	
	
}
