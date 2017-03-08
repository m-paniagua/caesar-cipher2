import java.io.*;


public class CaesarInputStream {
	//A private FileInputStream object for reading from an encrypted file
		private FileInputStream fStream = null;
		private DataInputStream  inputFile = null;
	//CeasarInputStream(String filename) - constructor that accepts the file name as a string
		public CaesarInputStream(String fileName) {
			try {
				fStream = new FileInputStream(fileName);
				inputFile = new DataInputStream(fStream);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	//char read() – reads one character from the file
		public char read() throws IOException {
			char character, newChar;
			
			character = inputFile.readChar();
			if (character >= 0 && character <= 12) {
				newChar = (char)(character + 243); 
				return newChar;
			}
			else {
				newChar = (char)(character - 13);
				return newChar;
			}
		}
	//String readString(int count) – reads ‘count’ characters form the file
		public String readString(int count) throws IOException {
			String line, str = "";
			String lineAt;
			char newChar;
			
			line = inputFile.readUTF();
			lineAt = line.substring(0, count);
			for(int i = 0; i < lineAt.length(); i++)
			{
				if(lineAt.charAt(i) >= 0 && lineAt.charAt(i) <= 12)
				{
					newChar = (char) (lineAt.charAt(i) + 243);
					str = str + newChar;
				}
				else
				{
					newChar = (char) (lineAt.charAt(i) - 13);
					str = str + newChar;
				}
			}
			
			return str;

		}
	//String readLine() – reads one line from the file (up to the next encrypted new line character)
		public String readLine() throws IOException {
			String line, str = "";
			char newChar;
			
			line = inputFile.readUTF();
			for (int i = 0; i < line.length(); i++) {
				if(line.charAt(i) >= 0 && line.charAt(i) <= 12)
				{
					newChar = (char) (line.charAt(i) + 243);
					str = str + newChar;
				}
				else
				{
					newChar = (char) (line.charAt(i) - 13);
					str = str + newChar;
				}
			}
			//decrypt String line
			return str;
		}
}
