package utilitaires;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class File_Manager {
	public static void writeToFile(String Filename,String data) 
{
		File file = new File(Filename+".txt");
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter br = new BufferedWriter(fr);
		try {
			br.write(data);
			br.close();
			fr.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
	}
}
