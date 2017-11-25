package rogMsg;

import java.util.ArrayList;
import java.util.List;

public class Lst
{
	private String _name;
	private List<User> _audience;
	private List<String> _items;

	public String getName()
	{
		String copy = _name;
		return copy;
	}

	public void setName(String _name)
	{
		this._name = _name;
	}

	public List<User> getAudience()
	{
		List<User> copy = _audience;
		return copy;
	}

	public void setAudience(ArrayList<User> _audience)
	{
		this._audience = _audience;
	}

	public List<String> getItems()
	{
		List<String> copy = _items;
		return copy;
	}

	public void setItems(ArrayList<String> _items)
	{
		this._items = _items;
	}


	public void addItem(String item)
	{

	}

	public void remove(String item)
	{

	}
}
