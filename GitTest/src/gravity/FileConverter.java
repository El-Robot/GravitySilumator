package gravity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileConverter {
	// converts the format given into an array then inputs the array into a Planet constructor

	public static ArrayList fileToSystem(File gvtyFile) {
		ArrayList<Planet> result = new ArrayList<Planet>();

		try {
			Scanner reader = new Scanner(gvtyFile);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				String[] dataArr = data.split(", ");
				result.add(new Planet(Integer.parseInt(dataArr[0]), Integer.parseInt(dataArr[1]),
						Double.parseDouble(dataArr[2]), Double.parseDouble(dataArr[3]),
						Double.parseDouble(dataArr[4])));
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
//	public static void saveSystemAsFile(File dir, ArrayList<Planet> planets) {
//		
//		File file = new File(dir + "\");
//		OutputStream out = new FileOutputStream(file);
//		// Write your data
//		out.close();
//		
//	}

}
