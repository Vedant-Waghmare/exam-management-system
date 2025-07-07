package vedant;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExamConsole ec = new ExamConsole();
		try {
			ec.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e); 
		}
	}

}
