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
	 * @param name the desired name of the object, non-null, length >= 1
	 * @param expDate the expiration date of the object, non-null
	 * @param optionMap the options maped with votes, non-null
	 */
	public void createPoll(String name, Date expDate, Map<String,Integer> optionMap)
	{
		if (name != null && name.trim().length() >= 1  && expDate != null && optionMap != null)
		{

		}
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
			return pWAS;
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

		}
	}
}
