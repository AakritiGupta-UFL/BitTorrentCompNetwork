
public class peerProcess {

	public static void main(String[] args) 
	{
		int PeerID = Integer.parseInt(args[0]);
		System.out.println("The peer ID is : " + PeerID);
		CommonConfigurations commonConfig = new CommonConfigurations();
		commonConfig.load();
		P2PPeer p2pPeer = commonConfig.loadPeer(PeerID);
		p2pPeer.peerParameters.displayParameters();
		for(int peerId : p2pPeer.PeerMap.keySet())
		{
			System.out.println("Key is : " + peerId);
		}	
	}

}
