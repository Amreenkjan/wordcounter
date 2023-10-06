import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
public class wordcounter {
	
	public static void main(String[]args) {
		Scanner s=new Scanner(System.in);
		String inputText="";
		
		System.out.println("enter 'text' to provide input text, or 'file' to provide a file path:");
		String choice=s.nextLine().trim().toLowerCase();
		
		if(choice.equals("text")) {
			System.out.println("enter your text:");
			inputText=s.nextLine();
			}else if(choice.equals("file")) {
				System.out.println("enter the file path:");
				String filepath=s.nextLine().trim();
				
				try {
					inputText=readTextFromFile(filepath);
				}catch(FileNotFoundException e) {
					System.out.println("File not found.please check the file path and try again.");
					System.exit(1);
					
				}
			}else {
				System.out.println("invalid choice.please enter either 'text' or 'file'.");
				System.exit(1);
			}
				
				int wordcount= countwords(inputText);
				System.out.println("Total words:    "+ wordcount);
				
				s.close();
			}
		public static String readTextFromFile(String filepath) throws FileNotFoundException{
			StringBuilder text=new StringBuilder();
			Scanner fileScanner=new Scanner(new File(filepath));
			
			while(fileScanner.hasNextLine()) {
				text.append(fileScanner.nextLine()).append("\n");
			}
			
			fileScanner.close();
			return text.toString();
		}
		
		public static int countwords(String text) {
			if(text.isEmpty()) {
				return 0;
			}
			String[]words = text.split("\\s");
			return words.length;
		}

}
