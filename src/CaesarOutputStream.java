import java.io.*;

public class CaesarOutputStream {

	//A private FileOutputStream object for reading from an encrypted file
	private FileOutputStream fStream = null;
	private DataOutputStream outFile = null;
	
	//CeasarOutputStream(String filename) constructor that accepts the file name as a string
	public CaesarOutputStream(String fileName) {
		try {
			fStream = new FileOutputStream(fileName);
			outFile = new DataOutputStream(fStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//void write(char c) � writes one character to the file
	public void write(char c) {
		char character;
		//encrypt char c
		if (c >= 0 && c <= 242) {
			character = (char) (c + 13);
		}
		else {
			character = (char)(c - 243);
		}
		
		try {
			outFile.writeChar(character);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//void writeString(String str) � writes a string to the file
	public void writeString(String str)   {
		char newChar;
		String line = "";
		//encrypt String str
		
		for(int i = 0; i < str.length(); i++)																																		//loops through each char
		{
			if(str.charAt(i) >= 0 && str.charAt(i) <= 242)																											
			{
				newChar = (char) (str.charAt(i) + 13);				
				line = line + newChar;
			}
			else																																													
			{
				newChar = (char) (str.charAt(i) - 243);			
				line = line + newChar;
		}
		}
		try {
			outFile.writeUTF(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	//void writeLine(String str) � writes a string to the file and adds a new line character (encrypted)
	public void writeLine(String str) {
		char newChar;
		String line = "";
		//encrypt String str
		
		for(int i = 0; i < str.length(); i++)																																		//loops through each char
		{
			if(str.charAt(i) >= 0 && str.charAt(i) <= 242)																											
			{
				newChar = (char) (str.charAt(i) + 13);				
				line = line + newChar;
			}
			else																																													
			{
				newChar = (char) (str.charAt(i) - 243);			
				line = line + newChar;
			}
		}
		try {
			outFile.writeUTF(line);
			outFile.writeChar('\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
