import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ConfigReader 
{
	
	public P2PPara readCommonConfigFromFile(String path)
	{
		System.out.println("readCommonConfigFromFile entered " +path);
		P2PPara p2pPara = new P2PPara();
		String rawData,secondWord;
		try
		{
			BufferedReader bufferReader = new BufferedReader(new FileReader(path));
			
			while((rawData = bufferReader.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(rawData);
				if(rawData.contains("NumberOfPreferredNeighbors"))
				{
					String[] result = rawData.split("\\s");
					int PreferredNeighbors = Integer.parseInt(result[1]);
					p2pPara.configParameters.NumberOfPreferredNeighbors = PreferredNeighbors;	
				}
				else if(rawData.contains("OptimisticUnchokingInterval"))
				{
					String[] result = rawData.split("\\s");
					int ounChokingInterval = Integer.parseInt(result[1]);
					p2pPara.configParameters.OptimisticUnchokingInterval = ounChokingInterval;	
				}
				else if(rawData.contains("UnchokingInterval"))
				{
					String[] result = rawData.split("\\s");
					int unChokingInterval = Integer.parseInt(result[1]);
					p2pPara.configParameters.UnchokingInterval = unChokingInterval;
				}
				else if(rawData.contains("FileName"))
				{
					String[] result = rawData.split("\\s");
					p2pPara.configParameters.FileName = result[1];	
				}
				else if(rawData.contains("FileSize"))
				{
					String[] result = rawData.split("\\s");
					long number = Long.parseLong(result[1]);
					p2pPara.configParameters.FileSize = number;
				}
				else
				{	
					String[] result = rawData.split("\\s");
					int pieceSize = Integer.parseInt(result[1]);
					p2pPara.configParameters.PieceSize = pieceSize;	
				}
				rawData = null;
			}
			
			bufferReader.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return p2pPara;
	}
	
	public ArrayList<P2PPeerPara> readPeerConfiguration(String path)
	{
		System.out.println("readPeerConfiguration entered");
		String rawData;
		ArrayList<P2PPeerPara> p2pParaArray = new ArrayList<P2PPeerPara>();
		try
		{
			BufferedReader bufferReader = new BufferedReader(new FileReader(path));
			
			while((rawData = bufferReader.readLine()) != null)
			{
				P2PPeerPara p2pParameters = new P2PPeerPara();
				String[] result = rawData.split("\\s");
				p2pParameters.peerParameters.peerID = Integer.parseInt(result[0]);
				
				p2pParameters.peerParameters.peerName = result[1];
				
			    p2pParameters.peerParameters.portNumber = Integer.parseInt(result[2]);
			    
			    p2pParameters.peerParameters.completeFile = Boolean.parseBoolean(result[3]);
			    
			    p2pParaArray.add(p2pParameters);
			}
			
			bufferReader.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex); 
		}
		
		return p2pParaArray;	
	}
}
