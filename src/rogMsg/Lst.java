package rogMsg;

import java.util.ArrayList;
import java.util.List;

public class Lst
{
	private String _name;
	private List<User> _audience;
	private List<String> _items;

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
	 * @param _name is the desired new name, length >= 1
	 */
	public void setName(String _name)
	{
		this._name = _name;
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
		this._audience = _audience;
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
	 * @param _items the list you want to send
	 */
	public void setItems(ArrayList<String> _items)
	{
		this._items = _items;
	}

	/**
	 * adds a string called item to the list 
	 * @param item the desired item you want to add, non-null, length > 0
	 */
	public void addItem(String item)
	{

	}

	/**
	 * removes the item from the list
	 * @param item the desired item, must be non-null, length > 0
	 */
	public void remove(String item)
	{

	}
}
