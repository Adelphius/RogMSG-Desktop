package rogMsg;

import java.util.ArrayList;


public class Lists {
	
	private ArrayList<Lst> _listSquared;

	public Lst getList(String name)
	{
		for(Lst l : _listSquared)
		{
			if(l.getName().equals(name))
			{
				return l;
			}
		}
		return null;
	}
	
	/**
	 * TODO redefine this so its more proper.
	 * What does it return? On the UML it says it returns a poll?
	 * Also it says the method takes an array?
	 */
	public void selectLst()
	{
		
	}
	
	public static Lst createLst(String name, ArrayList<String> listItems)
	{
		Lst list = new Lst();
		list.setName(name);
		for(String s : listItems)
		{
			list.addItem(s);
		}
		return list;
	}
	
}
