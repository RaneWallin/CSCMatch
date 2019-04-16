import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileHandler {
	
	private String fileName;
	
	public void filename (String fileName)
	{
		this.fileName =fileName;
	}
	
	public void save(String fileName, Object MemberSet) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(fileName); 
		ObjectOutputStream os = new ObjectOutputStream(fos); 
		os.writeObject(MemberSet); 
		os.flush(); 
		os.close(); 
	}

	public static FileHandler load(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		FileHandler fh = (FileHandler) ois.readObject();
		ois.close();
		
		return fh;
	}
}


