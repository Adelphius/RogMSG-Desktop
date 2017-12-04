package rogMsg;

import java.util.Date;
import java.util.Map;

public class Poll 
{

	private Date _endDate;
	private Map<String,Integer> _options;
	private String _name;
	private User _creator;

	public Date getEndDate()
	{
		Date copy = _endDate;
		return copy;
	}

	public void setEndDate(Date endDate)
	{
		this._endDate = endDate;
	}

	public Map<String, Integer> getOptions()
	{
		Map<String, Integer> copy = _options;
		return copy;
	}

	public void setOptions(Map<String, Integer> options)
	{
		this._options = options;
	}

	public String getName()
	{
		String copy = _name;
		return copy;
	}

	public void setName(String name)
	{
		this._name = name;
	}

	public User getCreator()
	{
		User copy = _creator;
		return copy;
	}

	public void setCreator(User creator)
	{
		this._creator = creator;
	}

	public void addVote(String vote)
	{

	}

}
