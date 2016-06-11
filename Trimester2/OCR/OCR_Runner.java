//Nick Keirstead
import java.util.*;
import java.io.*;

public class OCR_Runner {
	public static void main(String[] args) {
		System.out.println("Hello, Welcome to OCR!");
		Scanner s = new Scanner(System.in);
		boolean again = false;
		do {
			System.out.print("Enter the Name of the Picture File to Match With a Letter Or Type \"All\" To Match All Images: ");
			String filename = s.nextLine();
			
			if (!filename.toLowerCase().equals("all")) {
				int[][] image = loadImage(filename);
			
				char closestMatch = OCR.ocr(image);
				System.out.println("Closest Match to the Image in \"" + filename + "\" is the letter " + closestMatch);
			} else {
				for (int i = 1; i <= 6; i++) {
					String fName = "Image" + i + ".pgm";
					char closestMatch = OCR.ocr(loadImage(fName));
					System.out.println(fName + ": " + closestMatch);
				}
			}
			
			System.out.print("\nGo again (y/n)? ");
			again = s.nextLine().toLowerCase().equals("y");
		} while (again);
		
		System.out.println("\nThank You For Using OCR!");
		System.out.println("Designed By Nick Keirstead (2016)");
	}
	
	public static int[][] loadImage(String fileName) {
		//figure out dimensions without having to pass them in
		//by loading pixels into arraylist of arraylists, then
		//turning the 2d list into 2d array to be
		//returned
		BufferedReader br = null;
		ArrayList<ArrayList<Integer>> imageList = null;
		
		try {
			br = new BufferedReader(new FileReader(fileName));
			imageList = new ArrayList<ArrayList<Integer>>();
			
			//ignore headers
			br.readLine(); br.readLine(); br.readLine();
			
			//read all ints from file into imageList
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] numStrings = line.split(" ");
				ArrayList<Integer> row = new ArrayList<Integer>();
				for (String s : numStrings) {
					row.add(Integer.parseInt(s));
				}
				imageList.add(row);
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println("We cannot find the file \"" + fileName + "\". Make sure you add .pgm to file name.");
			System.exit(1);
		} catch(IOException e) {
			System.out.println("Error Reading the file \"" + fileName + "\".");
			System.exit(1);
		}
		
		//find longest row in imageList
		int longestRowLen = -1;
		for (int row = 0; row < imageList.size(); row++) {
			if (imageList.get(row).size() > longestRowLen) {
				longestRowLen = imageList.get(row).size();
			}
		}
		//fill out all rows with less than length of longest row with white pixels,
		//so that entire matrix is same size
		for (int row = 0; row < imageList.size(); row++) {
			int whitePixelsToAdd = longestRowLen - imageList.get(row).size();
			for (int i = 0; i < whitePixelsToAdd; i++) {
				imageList.get(row).add(255);
			}
		}
		int[][] image = new int[imageList.size()][longestRowLen];
		for (int row = 0; row < imageList.size(); row++) {
			for (int pixel = 0; pixel < longestRowLen; pixel++) {
				image[row][pixel] = imageList.get(row).get(pixel);
			}
		}
		return image;
	}
}