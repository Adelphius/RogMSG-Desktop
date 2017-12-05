package rogMsg;

import java.util.ArrayList;
import java.util.List;


public class Lists {

	private static List<Lst> _listSquared;

	
	public static List<Lst> getListSquared()
	{
		List<Lst> list = new ArrayList<>();
		list = _listSquared;
		return list;
	}

  /**
	 * gets a List of Lst objects from the server and saves them to _listSquared
	 * @return a list.
	 */
	public static Lst getList(String name)
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
	public static Lst createLst(String name, List<User> audience, List<String> listItems)
	{
<<<<<<< HEAD
		if (name != null && listItems != null)
		{
			Lst list = new Lst(name, audience, listItems);
			list.setName(name);
			for(String s : listItems)
			{
				list.addItem(s);
			}
			return list;
		}
		return null;
	}
	
	public static void addLstToLists(Lst list)
	{
		_listSquared.add(list);
=======

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
>>>>>>> c80a37a6b7aab3569f3702983cdb32c0a50352b4
	}
}
