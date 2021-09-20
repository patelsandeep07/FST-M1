package activities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			File file = new File("src/activities/newfile.txt");
			boolean fStatus = file.createNewFile();

			if (fStatus) {
				System.out.println("File created successfully!");
			} else {
				System.out.println("File already exists at this path.");
			}

			FileWriter fw = new FileWriter("src/activities/newfile.txt");
			fw.write("Data Added into file");
			fw.close();

			// get the file object
			File fileUtil = FileUtils.getFile("src/activities/newfile.txt");

			// Read File
			System.out.println("Data in file:  " + FileUtils.readFileToString(fileUtil, "UTF8"));

			// Create Directory
			File destDir = new File("resources");

			// copy file to directory
			FileUtils.copyFileToDirectory(file, destDir);

			// Get file form new directory
			File newFile = FileUtils.getFile(destDir, "newfile.txt");

			// Read data form file
			String newFileData = FileUtils.readFileToString(newFile, "UTF8");

			System.out.println("Data in new file: " + newFileData);

		}

		catch (IOException errMessage) {
			System.out.println(errMessage);
		}

	}

}
