package rogMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	private String serverAddress = "192.168.1.10"; 	//the ip of the testing server
	private int serverPort = 1245;				//may want to change the way we pass the server info in the future
	
	/*
	 * initial server connection
	 * tries to connect to the ip and the port above
	 * 
	 * Right now this is only testing to see if it can make a connection and pass data
	 * in the future we will want to make it receive a new port in order...
	 *  to set up a dedicated socket connection with the server.
	 */
	public void requestConnection() throws UnknownHostException, IOException
	{
		
		
		Socket s = new Socket(serverAddress, serverPort);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		String severResponce = br.readLine();
		
		System.out.println(severResponce);
	}

}
