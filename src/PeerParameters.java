
public class PeerParameters 
{
	int peerID;
	String peerName;
	int portNumber;
	boolean completeFile;
	
	
	PeerParameters()
	{
		peerID = 0;
		portNumber = 0;
		completeFile = false;
	}
	
	/**
	 * @return the peerID
	 */
	public int getPeerID() {
		return peerID;
	}
	/**
	 * @param peerID the peerID to set
	 */
	public void setPeerID(int peerID) {
		this.peerID = peerID;
	}
	/**
	 * @return the peerName
	 */
	public String getPeerName() {
		return peerName;
	}
	/**
	 * @param peerName the peerName to set
	 */
	public void setPeerName(String peerName) {
		this.peerName = peerName;
	}
	/**
	 * @return the portNumber
	 */
	public int getPortNumber() {
		return portNumber;
	}
	/**
	 * @param portNumber the portNumber to set
	 */
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	/**
	 * @return the completeFile
	 */
	public boolean isCompleteFile() {
		return completeFile;
	}
	/**
	 * @param completeFile the completeFile to set
	 */
	public void setCompleteFile(boolean completeFile) {
		this.completeFile = completeFile;
	}
	
	public void displayParameters()
	{
		System.out.println("The peer ID is : " + peerID);
		System.out.println("The peer Name : " + peerName);
		System.out.println("The port Number is : " + portNumber);
		System.out.println("Is the complete file present " + completeFile);
	}
}
