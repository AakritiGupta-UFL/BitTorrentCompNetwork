import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Peer 
{
	public void run(int portNumber,int peerID)
	{
		InetAddress IPAddress = null;
		try {
			IPAddress = InetAddress.getByName("localhost");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Socket socket = new Socket(IPAddress,portNumber);
			ObjectInputStream ObjectInStream = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream ObjectOutStream = new ObjectOutputStream(socket.getOutputStream());
			
			
			MessageType message = new MessageType(peerID);
			message.setMessageHeader("P2PFILESHARINGPROJ’");
			ObjectOutStream.writeObject(message);
			
			insertNextMessageType(message,peerID);
			PeerHandler peerHandler = new PeerHandler(socket,ObjectInStream,ObjectOutStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void insertNextMessageType(MessageType message,int peerID)
	{
		CommonConfigurations.peerHandlerMap.put(peerID, message);
	}
}
