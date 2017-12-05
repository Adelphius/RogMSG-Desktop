package rogMsg;

import java.util.ArrayList;


public class Lists {

	private ArrayList<Lst> _listSquared;


  /**
	 * gets a List of Lst objects from the server and saves them to _listSquared
	 * @return a list.
	 */
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
	 * chooses a list to be modified or edited
	 */
	public void selectLst()
	{

	}
	
  /**
	 * creates a new Lst object and adds it to the listItems
	 * @param name is the name of the object
	 * @param listItems is an arraylist of the objects
	 */
	public static Lst createLst(String name, ArrayList<String> listItems)
	{

	    if (name != null && listItems != null)
			{
			  Lst list = new Lst(name, null, listItems);// null because we are not passing the list of users for the audience.
			  list.setName(name);
			  for(String s : listItems)
			  {
			  	list.addItem(s);
			  }
			  return list;
	    }
	    return null;
	}

}
