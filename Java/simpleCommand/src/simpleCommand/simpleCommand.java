package simpleCommand;
import java.io.*;

public class simpleCommand {

	public static void main(String[] args) {
	
		String s = null; 
		
		try {
			
			Process p = Runtime.getRuntime().exec("netstat");
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			
			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			
			} // while
				
			// read any errors from the attempted command
			System.out.println("Here is the standard error for the command (if any):\n");
			while((s = stdError.readLine()) != null); {
				System.out.println(s);
			
			} // while 	
			
			System.exit(0);
			
		} // try 
		
		catch (IOException e) {
			System.out.println("Exception happened - Here's what I know: ");
			e.printStackTrace();
			System.exit(-1);
		} // catch
		
	} // main method 

} // main class