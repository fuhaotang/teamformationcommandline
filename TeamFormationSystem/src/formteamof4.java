import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class formteamof4 {

	public static void main(String[] args) throws IOException {

		String userNameLine; // reads the uniqueId portion of a studentList line
		int studentListLines = 0; // variable for counting the number of lines in a StudentListfile

		Random uniqueIdChooser = new Random();
		Scanner scan = new Scanner(System.in);
		// counts the number of lines in a studentListfile

		BufferedReader StudentListLineReader = new BufferedReader(new FileReader("src/StudentList.txt"));
		while (StudentListLineReader.readLine() != null)
			studentListLines++;
		{
			StudentListLineReader.close();
		}

		System.out.println(studentListLines);

		String[] uniqueLineList = new String[studentListLines];
		String[] uniqueIdList = new String[studentListLines];
		String uniqueIdValidation; // validates input of unique id aganist uniqueIDList

		// loop to print all lines into an array
		for (int i = 0; i < studentListLines; i++) {
			uniqueLineList[i] = Files.readAllLines(Paths.get("src/StudentList.txt")).get(i);
		}

		System.out.println(Arrays.toString(uniqueLineList));

		int k = 0; // counter to print uniqueid

		while (uniqueLineList.length > k) {
			uniqueIdList[k] = uniqueLineList[k].substring(0, 8);
			k++;
		}

		System.out.println(Arrays.toString(uniqueIdList));
		System.out.println(uniqueIdList[0]);

		// randomises id selection and make sure there are no duplicates
		int randomIndex = uniqueIdChooser.nextInt(uniqueIdList.length);
		int randomIndex2 = uniqueIdChooser.nextInt(uniqueIdList.length);
		int randomIndex3 = uniqueIdChooser.nextInt(uniqueIdList.length);
		int randomIndex4 = uniqueIdChooser.nextInt(uniqueIdList.length);

		// tests to see if there are duplicate unique IDS
		while (randomIndex == randomIndex2) {
			randomIndex2 = uniqueIdChooser.nextInt(uniqueIdList.length);
		}

		while (randomIndex == randomIndex3) {
			randomIndex3 = uniqueIdChooser.nextInt(uniqueIdList.length);
		}

		while (randomIndex == randomIndex4) {
			randomIndex4 = uniqueIdChooser.nextInt(uniqueIdList.length);
		}

		while (randomIndex2 == randomIndex3) {
			randomIndex3 = uniqueIdChooser.nextInt(uniqueIdList.length);
		}
		while (randomIndex2 == randomIndex4) {
			randomIndex4 = uniqueIdChooser.nextInt(uniqueIdList.length);
		}
		while (randomIndex3 == randomIndex4) {
			randomIndex4 = uniqueIdChooser.nextInt(uniqueIdList.length);
		}

		// variables and methods to determine gender balance
		int femaleCounter = 0;
		int maleCounter = 0;
		// gets the whole line of the 4 randomIndexes
		String test1 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex);
		String test2 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex2);
		String test3 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex3);
		String test4 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex4);

		String[] genderCompareList = new String[] { test1, test2, test3, test4 };

		System.out.println(Arrays.toString(genderCompareList));

		// counter to compare aganist the genderCompareList array
		int genderCounter = 0;

		// while loop to count femalecounter and malecounter
		while (genderCounter < genderCompareList.length) {

			if (genderCompareList[genderCounter].contains("female")) {
				femaleCounter++;
			} else
				maleCounter++;

			genderCounter++;
		}

		String validGroup;
		if (femaleCounter > 1) {
			validGroup = " Not a valid group as there is more than one female in the group";
		} else {
			validGroup = "Perfect gender balance for  Group";
		}

		// method to test average gpa is greater or less than 3.0
		String gpatest1 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex);
		String gpatest2 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex2);
		String gpatest3 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex3);
		String gpatest4 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex4);

		// gets the string at the 4th "|"
		String gpaResult1 = gpatest1.split("\\|")[4];
		String gpaResult2 = gpatest2.split("\\|")[4];
		String gpaResult3 = gpatest3.split("\\|")[4];
		String gpaResult4 = gpatest4.split("\\|")[4];

		double convertGpatoDouble = Double.parseDouble(gpaResult1);
		double convertGpatoDouble2 = Double.parseDouble(gpaResult2);
		double convertGpatoDouble3 = Double.parseDouble(gpaResult3);
		double convertGpatoDouble4 = Double.parseDouble(gpaResult4);

		String validOrInvalidGpa = "Correct Gpa requirement.";

		Double aggregateGpa = ((convertGpatoDouble + convertGpatoDouble2 + convertGpatoDouble3 + convertGpatoDouble4)
				/ 4);

		if ((convertGpatoDouble + convertGpatoDouble2 + convertGpatoDouble3 + convertGpatoDouble4) / 4 <= 3) {
			validOrInvalidGpa = "The gpa average for this group is not high enough";
		}

		// analyze years of experience for each student to see if there is at least one
		// student
		// with at least 5 years experience.

		String expyears = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex);
		String expyears2 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex2);
		String expyears3 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex3);
		String expyears4 = Files.readAllLines(Paths.get("src/StudentList.txt")).get(randomIndex4);

		String yearsofExp1 = expyears.split("\\|")[6];
		double convertedYearsOfExp1 = Double.parseDouble(yearsofExp1);
		String yearsofExp2 = expyears2.split("\\|")[6];
		double convertedYearsOfExp2 = Double.parseDouble(yearsofExp2);
		String yearsofExp3 = expyears3.split("\\|")[6];
		double convertedYearsOfExp3 = Double.parseDouble(yearsofExp3);
		String yearsofExp4 = expyears4.split("\\|")[6];
		double convertedYearsOfExp4 = Double.parseDouble(yearsofExp4);

		Double[] yrsOfExpArray = new Double[] { convertedYearsOfExp1, convertedYearsOfExp2, convertedYearsOfExp3,
				convertedYearsOfExp4 };

		int yrsExpCount = 0;
		int yrsCounter = 0;

		while (yrsOfExpArray.length > yrsCounter) {

			if (yrsOfExpArray[yrsCounter] >= 5) {
				yrsExpCount++;
			}

			yrsCounter++;
		}

		System.out.println(yrsExpCount);

		String yearsExpText = "Good!! there is at least one member with 5 years of work experience";
		if (yrsExpCount < 1) {
			yearsExpText = "BAD!! There is no worker with at least 5 years of experience";
		}

		System.out.println("Group members : " + uniqueIdList[randomIndex] + "  " + uniqueIdList[randomIndex2] + "  "
				+ uniqueIdList[randomIndex3] + " " + uniqueIdList[randomIndex4] + " . " + validOrInvalidGpa + " "
				+ aggregateGpa + " . " + validGroup + " . " + yearsExpText);

	}
}
