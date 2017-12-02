package rogMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SocketClient {
	
	private String serverAddress; 	//the ip of the testing server
	private int serverPort;			//the port of the server
	
	public SocketClient(String ip, int port)
	{
		serverAddress = ip;
		serverPort = port;
	}
	
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

	/**
	 * Attempts to authenticate the user with the server. 
	 * if the authentication is good, it will return the user object from the server.
	 * @param email login email
	 * @param pass login password
	 * @return the user if valid. null if invalid.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public User auth(String email, String pass) throws UnknownHostException, IOException {
		Socket s = new Socket (serverAddress, serverPort);
		PrintWriter dataOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		
		dataOut.println(email);
		dataOut.println(pass);
		dataOut.flush();
		
		
		return null;
		
	}

}
