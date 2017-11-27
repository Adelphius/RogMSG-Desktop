package rogMsg;

import java.util.Date;
import java.util.Map;

public class Poll 
{

	private Date _endDate;
	private Map< String,Integer> _options;
	private String _name;
	private User _creator;

	/**
	 * gets the expiration date of the poll
	 * @return a date that the poll expires
	 */
	public Date getEndDate()
	{
		Date copy = _endDate;
		return copy;
	}

	/**
	 * sets the end date the poll expires
	 * @param endDate is the date that the poll expires
	 */
	public void setEndDate(Date endDate)
	{
		this._endDate = endDate;
	}

	/**
	 * gets a  map of options, key is the option, value is the total votes for it
	 * @return a map
	 */
	public Map<String, Integer> getOptions()
	{
		Map<String, Integer> copy = _options;
		return copy;
	}

/**
 * sets options for the poll
 * @param options
 */
	public void setOptions(Map<String, Integer> options)
	{
		this._options = options;
	}

/**
 * gets the name of the poll
 * @return a string of the name, length >= 1
 */
	public String getName()
	{
		String copy = _name;
		return copy;
	}

/**
 * sets the name of the poll
 * @param name is the string you want the poll to be, length >= 1, non null, 
 */
	public void setName(String name)
	{
		this._name = name;
	}

	/**
	 * gets the creator of the poll
	 * @return a user object of who created the poll
	 */
	public User getCreator()
	{
		User copy = _creator;
		return copy;
	}

	/**
	 * sets a user to be the creator of the poll
	 * @param creator is the creator of the poll
	 */
	public void setCreator(User creator)
	{
		this._creator = creator;
	}

	/**
	 * add one vote to poll option that is passed in.
	 * @param vote is the thing we want to add one vote to, length >= 1
	 */
	public void addVote(String vote)
	{

	}

}
