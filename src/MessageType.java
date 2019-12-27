import java.io.Serializable;
import java.util.BitSet;

public class MessageType implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String messageHeader;
	public String getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(String messageHeader) {
		this.messageHeader = messageHeader;
	}

	BitSet bitSet = new BitSet(80);
	public BitSet getBitSet() {
		return bitSet;
	}

	public void setBitSet(BitSet bitSet) {
		this.bitSet = bitSet;
	}

	public int getPeerID() {
		return PeerID;
	}

	public void setPeerID(int peerID) {
		PeerID = peerID;
	}

	int PeerID;
	
		MessageType(int peerID)
	{
		PeerID = peerID;
	}
}
