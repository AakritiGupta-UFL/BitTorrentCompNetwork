import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CommonConfigurations 
{
	public static P2PConfigParameters p2pConfigPara;
	public static HashMap<Integer,PeerParameters> peerConfigMap = new HashMap<Integer,PeerParameters>();
	public static HashMap<Integer,MessageType> peerHandlerMap = new HashMap<Integer,MessageType>();
	
	public void load() 
	{
		ConfigReader configReader = new ConfigReader();
		String commonPath = "Common.cfg";
		String peerPath = "PeerInfo.cfg";
		
		
		P2PConfigParameters p2pConfigPara = configReader.readCommonConfigFromFile(commonPath);
		p2pConfigPara.configParameters.displayParameters();
	
		ArrayList<P2PPeer> p2pPeers = configReader.readPeerConfiguration(peerPath);
		for(P2PPeer p1 : p2pPeers)
		{
			peerConfigMap.put(p1.getPeerParameters().peerID,p1.getPeerParameters());
		}	
	}

	public P2PPeer loadPeer(int peerID) 
	{
		P2PPeer p2pPeer = new P2PPeer();
		
		for(int peerId : peerConfigMap.keySet())
		{
			if(peerId != peerID)
			{
				PeerParameters peerConfig = peerConfigMap.get(peerId);
				p2pPeer.PeerMap.put(peerId, peerConfig);
			}
			else
			{
				p2pPeer.peerParameters = peerConfigMap.get(peerID);
				break;
			}
		}
		return p2pPeer;
	}
}
