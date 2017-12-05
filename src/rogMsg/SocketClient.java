package rogMsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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

	/**
	 * Attempts to authenticate the user with the server. 
	 * if the authentication is good, it will return the user object from the server.
	 * @param email login email
	 * @param pass login password
	 * @return the user if valid. null if invalid.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public User auth(String email, String pass) throws UnknownHostException, IOException 
	{
		Socket s = new Socket (serverAddress, serverPort);
		PrintWriter dataOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		
		dataOut.println("login");
		
		dataOut.println(email);
		dataOut.println(pass);
		dataOut.flush();
		
		BufferedReader input =
	            new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		if(input.readLine().equals("authenticated"))
		{
			int port = input.read(); //read port int
			ObjectInputStream inFromServer = new ObjectInputStream(s.getInputStream());
			User userFromServer = new User();
			try {
				userFromServer = (User) inFromServer.readObject();
				return userFromServer;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	public User reg(String email, String name, String pass) throws UnknownHostException, IOException
    {
		Socket s = new Socket (serverAddress, serverPort);
		PrintWriter dataOut = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		
		dataOut.println("register");
		
		dataOut.println(email);
		dataOut.println(name);
		dataOut.println(pass);
		dataOut.flush();
		
		BufferedReader input =
	            new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		if(input.readLine().equals("authenticated"))
		{
			int port = input.read(); //read port int
			ObjectInputStream inFromServer = new ObjectInputStream(s.getInputStream());
			User userFromServer = new User();
			
			try {
				userFromServer = (User) inFromServer.readObject();
				return userFromServer;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
    	return null;
    }

}
