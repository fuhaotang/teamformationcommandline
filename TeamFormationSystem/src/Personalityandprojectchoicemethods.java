import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Personalityandprojectchoicemethods {

	public static void main(String[] args) throws IOException {

		int studentListLines = 0; // variable for counting the number of lines in a StudentListfile

		Random uniqueIdChooser = new Random();

		// counts the number of lines in a studentListfile

		BufferedReader StudentListLineReader = new BufferedReader(new FileReader("src/StudentList.txt"));
		while (StudentListLineReader.readLine() != null)
			studentListLines++;
		{
			StudentListLineReader.close();
		}

		ArrayList<String> studentArrayList = new ArrayList<String>();
		// personality type array lists
		ArrayList<String> UniqueIdCounselorList = new ArrayList<String>();
		ArrayList<String> UniqueIdMastermindList = new ArrayList<String>();
		ArrayList<String> UniqueIdOtherPersonalityListA = new ArrayList<String>();
		ArrayList<String> UniqueIdOtherPersonalityListB = new ArrayList<String>();
		ArrayList<String> otherPersonalityListA = new ArrayList<String>();
		ArrayList<String> otherPersonalityListB = new ArrayList<String>();

		// gender type array lists
		ArrayList<String> counselorGenderList = new ArrayList<String>();
		ArrayList<String> mastermindGenderList = new ArrayList<String>();
		ArrayList<String> otherGenderListA = new ArrayList<String>();
		ArrayList<String> otherGenderListB = new ArrayList<String>();

		// GPA array lists
		ArrayList<String> counselorGpaList = new ArrayList<String>();
		ArrayList<String> mastermindGpaList = new ArrayList<String>();
		ArrayList<String> otherGpaListA = new ArrayList<String>();
		ArrayList<String> otherGpaListB = new ArrayList<String>();

		// years of experience lists
		ArrayList<String> counselorExpList = new ArrayList<String>();
		ArrayList<String> mastermindExpList = new ArrayList<String>();
		ArrayList<String> otherExpListA = new ArrayList<String>();
		ArrayList<String> otherExpListB = new ArrayList<String>();

		// first preference job lists
		ArrayList<String> counselorFirstJobList = new ArrayList<String>();
		ArrayList<String> mastermindFirstJobList = new ArrayList<String>();
		ArrayList<String> otherFirstJobListA = new ArrayList<String>();
		ArrayList<String> otherFirstJobListB = new ArrayList<String>();

		// second preference job lists
		ArrayList<String> counselorSecondJobList = new ArrayList<String>();
		ArrayList<String> mastermindSecondJobList = new ArrayList<String>();
		ArrayList<String> otherSecondJobListA = new ArrayList<String>();
		ArrayList<String> otherSecondJobListB = new ArrayList<String>();

		// first preference project list
		ArrayList<String> counselorFirstProjectList = new ArrayList<String>();
		ArrayList<String> mastermindFirstProjectList = new ArrayList<String>();
		ArrayList<String> otherFirstProjectListA = new ArrayList<String>();
		ArrayList<String> otherFirstProjectListB = new ArrayList<String>();

		// second preference project list
		ArrayList<String> counselorSecondProjectList = new ArrayList<String>();
		ArrayList<String> mastermindSecondProjectList = new ArrayList<String>();
		ArrayList<String> otherSecondProjectListA = new ArrayList<String>();
		ArrayList<String> otherSecondProjectListB = new ArrayList<String>();

		// generating team of 4 with unique id. with unique personalities(mastermind and
		// counselor personality a must)

		int studentListCount = 0;

		// loops the studentList text file and compares the personality type. returns
		// the unique id and puts them into their respective array types.
		// sorts into arrays for gender
		while (studentListLines > studentListCount) {
			studentArrayList
					.add(Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[5]);

			if (studentArrayList.get(studentListCount).equalsIgnoreCase("counselor")) {
				UniqueIdCounselorList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[0]);
				// adds the genders of all counselors to the counselorGenderList arraylist
				counselorGenderList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[3]);
				// adds the gpa of all counselors to the counselorGpaList arraylist
				counselorGpaList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[4]);
				counselorExpList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[6]);
				counselorFirstJobList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[7]);
				counselorSecondJobList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[8]);
				counselorFirstProjectList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[9]);
				counselorSecondProjectList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[10]);
			}

			else if (studentArrayList.get(studentListCount).equalsIgnoreCase("mastermind")) {
				UniqueIdMastermindList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[0]);

				mastermindGenderList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[3]);
				// adds the gpa of all masterminds to the mastermindGpaList arraylist
				mastermindGpaList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[4]);
				mastermindExpList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[6]);
				mastermindFirstJobList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[7]);
				mastermindSecondJobList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[8]);
				mastermindFirstProjectList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[9]);
				mastermindSecondProjectList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[10]);
			} else if (studentArrayList.get(studentListCount).equalsIgnoreCase("inspector")
					|| studentArrayList.get(studentListCount).equalsIgnoreCase("giver")) {
				UniqueIdOtherPersonalityListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[0]);
				otherPersonalityListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[5]);
				otherGenderListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[3]);
				// adds the gpa of all inspectos and givers to the otherGpaListA arraylist
				otherGpaListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[4]);
				otherExpListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[6]);
				otherFirstJobListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[7]);
				otherSecondJobListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[8]);
				otherFirstProjectListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[9]);
				otherSecondProjectListA.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[10]);
			} else {
				UniqueIdOtherPersonalityListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[0]);
				otherPersonalityListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[5]);
				otherGenderListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[3]);
				// adds the gpa of all other personalities to the otherGpaListB arraylist
				otherGpaListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[4]);
				otherExpListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[6]);
				otherFirstJobListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[7]);
				otherSecondJobListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[8]);
				otherFirstProjectListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[9]);
				otherSecondProjectListB.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[10]);
			}
			studentListCount++;
		}
		// unique id indexes to be used for all criteria
		int randomUniqueId = uniqueIdChooser.nextInt(UniqueIdCounselorList.size());
		int randomUniqueId2 = uniqueIdChooser.nextInt(UniqueIdMastermindList.size());
		int randomUniqueId3 = uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListA.size());
		int randomUniqueId4 = uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListB.size());

		// Calculate if Gpa is greater than 3 for all group members. Parse string array
		// into a
		// double array so gpa can be calculated.

		double[] confirmedCounselorGpaList = new double[counselorGpaList.size()];
		double[] confirmedMastermindGpaList = new double[mastermindGpaList.size()];
		double[] confirmedOtherGpaListA = new double[otherGpaListA.size()];
		double[] confirmedOtherGpaListB = new double[otherGpaListB.size()];

		for (int gpaCount = 0; gpaCount < counselorGpaList.size(); ++gpaCount) {
			confirmedCounselorGpaList[gpaCount] = Double.parseDouble(counselorGpaList.get(gpaCount));

		}
		for (int gpaCount2 = 0; gpaCount2 < mastermindGpaList.size(); ++gpaCount2) {
			confirmedMastermindGpaList[gpaCount2] = Double.parseDouble(mastermindGpaList.get(gpaCount2));

		}
		for (int gpaCount3 = 0; gpaCount3 < otherGpaListA.size(); ++gpaCount3) {
			confirmedOtherGpaListA[gpaCount3] = Double.parseDouble(otherGpaListA.get(gpaCount3));

		}
		for (int gpaCount4 = 0; gpaCount4 < otherGpaListB.size(); ++gpaCount4) {
			confirmedOtherGpaListB[gpaCount4] = Double.parseDouble(otherGpaListB.get(gpaCount4));

		}

		// years of experience. check to see if one of the teammates have more than 5
		// years experience.

		int[] confirmedCounselorExpList = new int[counselorExpList.size()];
		int[] confirmedMastermindExpList = new int[mastermindExpList.size()];
		int[] confirmedOtherExpListA = new int[otherExpListA.size()];
		int[] confirmedOtherExpListB = new int[otherExpListB.size()];

		for (int expCount = 0; expCount < counselorExpList.size(); ++expCount) {
			confirmedCounselorExpList[expCount] = Integer.parseInt(counselorExpList.get(expCount));

		}
		for (int expCount2 = 0; expCount2 < mastermindExpList.size(); ++expCount2) {
			confirmedMastermindExpList[expCount2] = Integer.parseInt(mastermindExpList.get(expCount2));

		}
		for (int expCount3 = 0; expCount3 < otherExpListA.size(); ++expCount3) {
			confirmedOtherExpListA[expCount3] = Integer.parseInt(otherExpListA.get(expCount3));

		}
		for (int expCount4 = 0; expCount4 < otherExpListB.size(); ++expCount4) {
			confirmedOtherExpListB[expCount4] = Integer.parseInt(otherExpListB.get(expCount4));

		}

		// check to see if there is more than one female in a group. Code to make one
		// female or none.
		// Inner while loop to cheack if cumulative GPA is more than 3. reiterates if
		// less than 3.0 GPA
		// outerwhileloop. if statements to see if there is at least one team member
		// with 5 years or more experience.
		int yrsOfExperienceCounter = 0;
		int femaleCounter = 2;
		while (femaleCounter > 1
				|| (confirmedCounselorGpaList[randomUniqueId] + confirmedMastermindGpaList[randomUniqueId2]
						+ confirmedOtherGpaListA[randomUniqueId3] + confirmedOtherGpaListB[randomUniqueId4]) / 4 <= 3
				|| yrsOfExperienceCounter > 3
				|| counselorFirstJobList.get(randomUniqueId)
						.equalsIgnoreCase(mastermindFirstJobList.get(randomUniqueId2)) == true
				|| counselorFirstJobList.get(randomUniqueId)
						.equalsIgnoreCase(otherFirstJobListA.get(randomUniqueId3)) == true
				|| counselorFirstJobList.get(randomUniqueId)
						.equalsIgnoreCase(otherFirstJobListB.get(randomUniqueId4)) == true
				|| mastermindFirstJobList.get(randomUniqueId2)
						.equalsIgnoreCase(otherFirstJobListA.get(randomUniqueId3)) == true
				|| mastermindFirstJobList.get(randomUniqueId2)
						.equalsIgnoreCase(otherFirstJobListB.get(randomUniqueId4)) == true
				|| otherFirstJobListA.get(randomUniqueId3)
						.equalsIgnoreCase(otherFirstJobListB.get(randomUniqueId4)) == true
				|| counselorFirstProjectList.get(randomUniqueId)
						.equalsIgnoreCase(mastermindFirstProjectList.get(randomUniqueId2)) == false
				|| counselorFirstProjectList.get(randomUniqueId)
						.equalsIgnoreCase(otherFirstProjectListA.get(randomUniqueId3)) == false
				|| counselorFirstProjectList.get(randomUniqueId)
						.equalsIgnoreCase(otherFirstProjectListB.get(randomUniqueId4)) == false
				|| mastermindFirstProjectList.get(randomUniqueId2)
						.equalsIgnoreCase(otherFirstProjectListA.get(randomUniqueId3)) == false
				|| mastermindFirstProjectList.get(randomUniqueId2)
						.equalsIgnoreCase(otherFirstProjectListB.get(randomUniqueId4)) == false
				|| otherFirstProjectListA.get(randomUniqueId3)
						.equalsIgnoreCase(otherFirstProjectListB.get(randomUniqueId4)) == false) {
			while ((confirmedCounselorGpaList[randomUniqueId] + confirmedMastermindGpaList[randomUniqueId2]
					+ confirmedOtherGpaListA[randomUniqueId3] + confirmedOtherGpaListB[randomUniqueId4]) / 4 <= 3) {
				randomUniqueId = uniqueIdChooser.nextInt(UniqueIdCounselorList.size());
				randomUniqueId2 = uniqueIdChooser.nextInt(UniqueIdMastermindList.size());
				randomUniqueId3 = uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListA.size());
				randomUniqueId4 = uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListB.size());

			}

			randomUniqueId = uniqueIdChooser.nextInt(UniqueIdCounselorList.size());
			randomUniqueId2 = uniqueIdChooser.nextInt(UniqueIdMastermindList.size());
			randomUniqueId3 = uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListA.size());
			randomUniqueId4 = uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListB.size());
			yrsOfExperienceCounter = 0;
			femaleCounter = 0;

			if (confirmedCounselorExpList[randomUniqueId] < 5 == true) {
				yrsOfExperienceCounter++;

			}
			if (confirmedMastermindExpList[randomUniqueId2] < 5 == true) {
				yrsOfExperienceCounter++;

			}
			if (confirmedOtherExpListA[randomUniqueId3] < 5 == true) {
				yrsOfExperienceCounter++;

			}
			if (confirmedOtherExpListB[randomUniqueId4] < 5 == true) {
				yrsOfExperienceCounter++;

			}
			if (counselorGenderList.get(randomUniqueId).equalsIgnoreCase("female") == true) {
				femaleCounter++;

			}
			if (mastermindGenderList.get(randomUniqueId2).equalsIgnoreCase("female") == true) {
				femaleCounter++;

			}
			if (otherGenderListA.get(randomUniqueId3).equalsIgnoreCase("female") == true) {
				femaleCounter++;

			}
			if (otherGenderListB.get(randomUniqueId4).equalsIgnoreCase("female") == true) {
				femaleCounter++;

			}

		}

		/*
		 * while (counselorFirstProjectList.get(randomUniqueId)
		 * .equalsIgnoreCase(mastermindFirstProjectList.get(randomUniqueId2)) == false
		 * || counselorFirstProjectList.get(randomUniqueId)
		 * .equalsIgnoreCase(otherFirstProjectListA.get(randomUniqueId3)) == false ||
		 * counselorFirstProjectList.get(randomUniqueId)
		 * .equalsIgnoreCase(otherFirstProjectListB.get(randomUniqueId4)) == false ||
		 * mastermindFirstProjectList.get(randomUniqueId2)
		 * .equalsIgnoreCase(otherFirstProjectListA.get(randomUniqueId3)) == false ||
		 * mastermindFirstProjectList.get(randomUniqueId2)
		 * .equalsIgnoreCase(otherFirstProjectListB.get(randomUniqueId4)) == false ||
		 * otherFirstProjectListA.get(randomUniqueId3)
		 * .equalsIgnoreCase(otherFirstProjectListB.get(randomUniqueId4)) == false) {
		 * 
		 * randomUniqueId = uniqueIdChooser.nextInt(UniqueIdCounselorList.size());
		 * randomUniqueId2 = uniqueIdChooser.nextInt(UniqueIdMastermindList.size());
		 * randomUniqueId3 =
		 * uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListA.size());
		 * randomUniqueId4 =
		 * uniqueIdChooser.nextInt(UniqueIdOtherPersonalityListB.size());
		 * 
		 * }
		 */

		System.out.println(counselorFirstProjectList.get(randomUniqueId));
		System.out.println(mastermindFirstProjectList.get(randomUniqueId2));
		System.out.println(otherFirstProjectListA.get(randomUniqueId3));
		System.out.println(otherFirstProjectListB.get(randomUniqueId4));

		System.out.println(femaleCounter);
		System.out.println(yrsOfExperienceCounter);
		System.out.println((confirmedCounselorGpaList[randomUniqueId] + confirmedMastermindGpaList[randomUniqueId2]
				+ confirmedOtherGpaListA[randomUniqueId3] + confirmedOtherGpaListB[randomUniqueId4]) / 4);

		// Prints unique group members with unique personality types.
		// Prints gender balance. should be no more than one female in a group of four

		System.out.println(" The group members are : ");
		System.out.println(UniqueIdCounselorList.get(randomUniqueId) + "-" + "counselor" + "-"
				+ counselorGenderList.get(randomUniqueId) + "-" + confirmedCounselorGpaList[randomUniqueId] + " "
				+ "GPA" + "-" + confirmedCounselorExpList[randomUniqueId] + " " + "Years of experience." + "-"
				+ counselorFirstJobList.get(randomUniqueId) + "-" + counselorFirstProjectList.get(randomUniqueId));
		System.out.println(UniqueIdMastermindList.get(randomUniqueId2) + "-" + "mastermind" + "-"
				+ mastermindGenderList.get(randomUniqueId2) + "-" + confirmedMastermindGpaList[randomUniqueId2] + " "
				+ "GPA" + "-" + confirmedMastermindExpList[randomUniqueId2] + " " + "Years of experience." + "-"
				+ mastermindFirstJobList.get(randomUniqueId2) + "-" + mastermindFirstProjectList.get(randomUniqueId2));
		System.out.println(UniqueIdOtherPersonalityListA.get(randomUniqueId3) + "-"
				+ otherPersonalityListA.get(randomUniqueId3) + "-" + otherGenderListA.get(randomUniqueId3) + "-"
				+ confirmedOtherGpaListA[randomUniqueId3] + " " + "GPA" + "-" + confirmedOtherExpListA[randomUniqueId3]
				+ " " + "Years of experience." + "-" + otherFirstJobListA.get(randomUniqueId3) + "-"
				+ otherFirstProjectListA.get(randomUniqueId3));
		System.out.println(UniqueIdOtherPersonalityListB.get(randomUniqueId4) + "-"
				+ otherPersonalityListB.get(randomUniqueId4) + "-" + otherGenderListB.get(randomUniqueId4) + "-"
				+ confirmedOtherGpaListB[randomUniqueId4] + " " + "GPA" + "-" + confirmedOtherExpListB[randomUniqueId4]
				+ " " + "Years of experience." + "-" + otherFirstJobListB.get(randomUniqueId4) + "-"
				+ otherFirstProjectListB.get(randomUniqueId4));
	}

}
