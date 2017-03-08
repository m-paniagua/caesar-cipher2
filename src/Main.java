import java.io.*;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException {
		String choice, input;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter encrypt or decrypt: ");
		choice = keyboard.next();
		
		while(!(choice.equalsIgnoreCase("encrypt")) && !(choice.equalsIgnoreCase("decrypt"))) 	{										//if invalid input, stuck in loop
			System.out.println("Invalid input!\nOnly valid options are encrypt or decrypt:");
			choice = keyboard.next();
		}
		
		if (choice.equalsIgnoreCase("encrypt")) {
			System.out.println("Enter file name to encrypt:");
			input = keyboard.next();
			 FileOutputStream fstream =
		                new FileOutputStream(input);
		      DataOutputStream outputFile =
		                new DataOutputStream(fstream);
			CaesarOutputStream coStream = new CaesarOutputStream(input);
			
			System.out.println("Enter data to encrypt (zzz to stop):");
			input = keyboard.nextLine();
			
			while (!input.equalsIgnoreCase("zzz")) {
				
				coStream.writeString(input);
				input = keyboard.nextLine();
			}
			outputFile.close();   
		}
		else {
			boolean endOfFile = false;
			System.out.println("Enter file name to decrypt:");
			input = keyboard.next();
			
			FileInputStream fstream =
	                null;
	      DataInputStream inputFile =
	               null;
			try {
				 fstream =
		                new FileInputStream(input);
		       inputFile =
		               new DataInputStream(fstream);
			}
			catch (FileNotFoundException e) {
				System.out.println("File not found, try again later");
				System.exit(0);
			}
			
	      
			CaesarInputStream ciStream = new CaesarInputStream(input);
			while (!endOfFile)
		      {
		         try
		         {
		        	 System.out.println(ciStream.readLine());
		         }
		         catch (EOFException e)
		         {
		            endOfFile = true;
		         }
		      }
			inputFile.close();
		}
	}

}
