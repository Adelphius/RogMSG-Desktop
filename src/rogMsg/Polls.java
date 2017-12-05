package rogMsg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Polls
{
	private static List<Poll> _pollList;

	/**
	 * gets a list of polls from the server and saves them to your device.
	 */
	public void getPolls()
	{

	}
	
	public static List<Poll> getPollList()
	{
		List<Poll> list = new ArrayList<Poll>();
		list = _pollList;
		return list;
	}

  /**
	 * creates a new Poll object
	 * @param name the desired name of the object, non-null, length >= 1
	 * @param expDate the expiration date of the object, non-null
	 * @param optionMap the options mapped with votes, non-null
	 */
	public static Poll createPoll(String name, Date expDate, Map<String,Integer> optionMap)
	{
  
    if (name != null && name.trim().length() >= 1  && expDate != null && optionMap != null)
		  {

		  }
		
		return null;
	}

	/**
	 * selects a poll from the client's list of polls to be viewed.
	 * @param pWAS the poll we are selecting, non-null
	 * @return returns the poll
	 */
	public Poll selectPoll(Poll pWAS)
	{
		if (pWAS != null)
		{
			int locationInPL = _pollList.indexOf(pWAS);
			return _pollList.get(locationInPL);
		}
		return null;
	}

	/**
	 * deletes a Poll object from the saved polls
	 * @param pWAS is the poll we are selecting to delete, non-null
	 */
	public void deletePoll(Poll pWAS)
	{
		if (pWAS != null)
		{
			_pollList.remove(pWAS);
		}
	}
	
	public static void addPolltoPollList(Poll poll)
	{
		_pollList.add(poll);
	}
}
