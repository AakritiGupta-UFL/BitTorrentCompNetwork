
public class ConfigPara 
{
	int NumberOfPreferredNeighbors;
	int UnchokingInterval;
	int OptimisticUnchokingInterval;
	String FileName;
	long FileSize;
	int PieceSize;
	
	ConfigPara()
	{
		NumberOfPreferredNeighbors = 0;
		UnchokingInterval = 0;
		OptimisticUnchokingInterval = 0;
		FileSize = 0;
		PieceSize = 0;
	}
	
	public long getFileSize() {
		return FileSize;
	}

	public void setFileSize(long fileSize) {
		FileSize = fileSize;
	}

	public void setNumberOfPreferredNeighbors(int numberOfPreferredNeighbors) {
		NumberOfPreferredNeighbors = numberOfPreferredNeighbors;
	}

	public void setUnchokingInterval(int unchokingInterval) {
		UnchokingInterval = unchokingInterval;
	}

	public void setOptimisticUnchokingInterval(int optimisticUnchokingInterval) {
		OptimisticUnchokingInterval = optimisticUnchokingInterval;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public void setPieceSize(int pieceSize) {
		PieceSize = pieceSize;
	}

	/**
	 * @return the numberOfPreferredNeighbors
	 */
	public int getNumberOfPreferredNeighbors() {
		return NumberOfPreferredNeighbors;
	}

	/**
	 * @return the unchokingInterval
	 */
	public int getUnchokingInterval() {
		return UnchokingInterval;
	}

	/**
	 * @return the optimisticUnchokingInterval
	 */
	public int getOptimisticUnchokingInterval() {
		return OptimisticUnchokingInterval;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return FileName;
	}

	/**
	 * @return the pieceSize
	 */
	public int getPieceSize() {
		return PieceSize;
	}
	
	public void displayParameters()
	{
		System.out.println("The Number Of Preferred Neighbors is : " + NumberOfPreferredNeighbors);
		System.out.println("The Unchoking Interval is : " + UnchokingInterval);
		System.out.println("The Optimistic Unchoking Interval is : " + OptimisticUnchokingInterval);
		System.out.println("The file name is : " + FileName);
		System.out.println("The file size is : " + FileSize);
		System.out.println("The piece size is : " + PieceSize);
	}
}
