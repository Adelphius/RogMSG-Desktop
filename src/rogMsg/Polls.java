package rogMsg;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Polls
{
	private List<Poll> _pollList;

	/**
	 * gets a list of polls from the server and saves them to your device.
	 * @return
	 */
	public void getPolls()
	{

	}

	/**
	 * creates a new Poll object
	 * @param name the desired name of the object
	 * @param expDate the experation date of the object
	 * @param optionMap the options maped with votes
	 */
	public void createPoll(String name, Date expDate, Map<String,Integer> optionMap)
	{

	}

	/**
	 * selects a poll from the client's list of polls to be viewed.
	 * @param pWAS the poll we are selecting
	 * @return returns the poll
	 */
	public Poll selectPoll(Poll pWAS)
	{
		return null;
	}

	/**
	 * delets a Poll object from the saved polls
	 * @param pWAS is the poll we are selecting to delete
	 */
	public void deletePoll(Poll pWAS)
	{
		
	}
}
