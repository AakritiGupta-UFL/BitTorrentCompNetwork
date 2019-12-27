import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread
{
	public ServerSocket serverSocket;
	
	public void initialise(int portNumber)
	{
		try {
			serverSocket = new ServerSocket(portNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(int portNumber,int peerID)
	{
		initialise(portNumber);
		startAccept(peerID);
	}
	
	public void startAccept(int peerID)
	{
		Socket socket = null;
		try
		{
			socket = serverSocket.accept();
			System.out.println("A new client is connected "+ socket);
			ObjectInputStream obInStream = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream obOutStream = new ObjectOutputStream(socket.getOutputStream());
            
            System.out.println("Assigning the client handler for the connection");
            
            Thread threadClient = new PeerHandler(socket,obInStream,obOutStream);
            
            threadClient.start();	
			
		}
		catch(Exception ex)
		{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}
}
