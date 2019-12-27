import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PeerHandler extends Thread {
	
	final ObjectInputStream peerObjectInStream;
	final ObjectOutputStream peerObjectOutStream;
	final Socket peerSocket;
	
	
    PeerHandler(Socket socket, ObjectInputStream obInStream, ObjectOutputStream obOutStream)
	{
		this.peerObjectInStream = obInStream;
		this.peerObjectOutStream = obOutStream;
		this.peerSocket = socket;	
	}
    
    public void run()
    {
    	try 
    	{
			MessageType message = (MessageType)peerObjectInStream.readObject();
			for(int peerId : CommonConfigurations.peerHandlerMap.keySet())
			{
				if(message.PeerID == peerId)
				{
					MessageType msg = CommonConfigurations.peerHandlerMap.get(peerId);
					
					if(msg.equals(message))
					{
						MessageType toSendMsg = HandleMessage(message,peerId);
						peerObjectOutStream.writeObject(toSendMsg);
					}
					else
					{
						System.out.println("Invalid message received");
					}
				}
			}
			
		} 
    	
    	catch (ClassNotFoundException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	private MessageType HandleMessage(MessageType message,int peerId) 
	{
		MessageType msg = new MessageType(peerId);
		switch(message.messageHeader)
		{
		case "P2PFILESHARINGPROJ":
			msg.setMessageHeader("P2PFILESHARINGPROJ");
			break;
		}
		return msg;
	}

}
