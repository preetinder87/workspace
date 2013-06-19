package RandomNo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Random_Generator {
	
	public void generator() throws IOException{
		
		int n = 0;
		Random wheel = new Random();
		BufferedWriter username = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("username.txt")));
		BufferedWriter password = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("password.txt")));
		String unique = "";
		while(n<50){
			unique = Long.toString(wheel.nextLong() & Long.MAX_VALUE,36);
			int len = unique.length() ;
			if(len == 12){
			username.write(unique);
			username.newLine();
			n++;
			}
		}
		
		while(true){
			unique = Long.toString(wheel.nextLong() & Long.MAX_VALUE,36);
			int len = unique.length();
			if(len ==12){
					username.write(unique);
					break;
				}
		}
		n=0;
		
		while(n<50){
			unique = Long.toString(wheel.nextLong() & Long.MAX_VALUE,36);
			int len = unique.length();
			if(len==12){
			password.write(unique);
			password.newLine();
			n++;
			}
		}
		
		while(true){
			unique = Long.toString(wheel.nextLong() & Long.MAX_VALUE,36);
			int len = unique.length();
			if(len ==12){
					password.write(unique);
					break;
				}
		}
		
		username.close();
		password.close();
		
		
	}
	public static void main(String[]arg) throws IOException{
		
		Random_Generator R = new Random_Generator();
		R.generator();
	}
	

}
