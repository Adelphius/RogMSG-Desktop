package rogMsg;

import java.util.ArrayList;
import java.util.List;

public class Lst
{
	private String _name;
	private List<User> _audience;
	private List<String> _items;

	
	
	/**
	 * Simple constructor for the object Lst
	 * @param name is the desired name, length > 0 (after removing white space from beginning and end)
	 * @param audience is the audience that can see it/
	 * @param items is the list of items in the list
	 */
	public Lst(String name, List<User> audience, List<String> items)
	{
		if (name.trim().length() <= 0)
			return;
		_name = name;
		_audience = audience;
		_items = items;
	}
	
	
	
	/**
	 * gets the Lst object's name
	 * @return a string copy of the name, non null length >= 1
	 */
	public String getName()
	{
		String copy = _name;
		return copy;
	}

	/**
	 * sets the name of the Lst object
	 * @param name is the desired new name, length >= 1
	 */
	public void setName(String name)
	{
		if (name != null && name.length() >= 1)
		{
			this._name = name;
		}
	}

	/**
	 * gets a list of users that can view the Lst object from the server
	 */
	public List<User> getAudience()
	{
		List<User> copy = _audience;
		return copy;
	}

	/**
	 * sends a list of users, that can view the lst object, to the server
	 * @param _audience the desired list of users that can view the Lst object, non-null
	 */
	public void setAudience(ArrayList<User> _audience)
	{
		if (_audience != null)
		{
			this._audience = _audience;
		}
	}

	/**
	 * gets a list of strings from the server. THat is then stored in the object of Lst
	 * @return copy of strings
	 */
	public List<String> getItems()
	{
		List<String> copy = _items;
		return copy;
	}

	/**
	 * is in charge of sending a list of strings to the server
	 * @param items the list you want to send, non-null
	 */
	public void setItems(ArrayList<String> items)
	{
		if (items != null)
		{
			this._items = items;
		}
	}

	/**
	 * adds a string called item to the list 
	 * @param item the desired item you want to add, non-null, length > 0 (after removing white space from start and end of string)
	 */
	public void addItem(String item)
	{
		if (item != null && item.trim().length() >= 1)
		{
			_items.add(item);
		}
	}

	/**
	 * removes the item from the list
	 * @param item the desired item, must be non-null, length > 0 (after removing white space from start and end of string)
	 */
	public void remove(String item)
	{
		if (item != null && item.trim().length() >= 1)
		{
			_items.remove(item);
		}
	}
}
