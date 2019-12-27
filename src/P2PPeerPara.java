import java.util.logging.Logger;

public class P2PPeerPara {
	public PeerParameters peerParameters;
	
	private static final Logger logger =
	        Logger.getLogger(P2PPeerPara.class.getName());
	
	public P2PPeerPara()
	{
		peerParameters = new PeerParameters();
	}
}
