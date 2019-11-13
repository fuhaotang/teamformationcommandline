import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		int menuChoice;
		// ---------------------------project name variables
		String projectName;
		int projectYesNo = 1;// yes no for continue to add project names
		Scanner projectScan = new Scanner(System.in); // unique Scanner object to allow spaces in input
		projectScan.useDelimiter("\n");// code to allow space input in submitting a project idea
		// ----------------------------student details variables
		String firstName;
		String lastName;
		String gender = "male";

		int genderConfirm = 1; // counter for while loop to confirm valid gender
		int personalityConfirm = 1; // counter for while loop to confirm personality selection
		int role1Validation = 1; // validate if role is available
		int role2Validation = 1; // validates if role is available
		int projectPreference1Validation = 1;
		int projectPreference2Validation = 1;
		double gpa = 5;
		String personType = "counselor";
		int yrsOfExp;
		String role1 = "programmer";
		String role2 = "programmer";
		String projectPreference1 = "a";
		String projectPreference2 = "b";
		String confirmedProjectPreference1 = "WRONGENTRY";
		String confirmedProjectPreference2 = "WRONGENTRY";

		// generating student unique id variables
		String firstNameSubString; // return part of student first name for generating ID
		String lastNameSubString; // return part of student last name for generating ID
		int randomNumID; // the numerical portion of the unique ID for each student

		int studentYesNo = 1;
		int generateTeamYesNo = 1;
		Scanner scan = new Scanner(System.in);
		Random numberStudentIdGen = new Random();
		// appends all parts together to form the unique student ID
		StringBuilder completeStudentId = new StringBuilder();

		System.out.println("Which of the following would you like to do");
		System.out.println("1. Add a project idea");
		System.out.println("2. Add a student amd details");
		System.out.println("3. Generate a random Team");
		menuChoice = scan.nextInt();

		switch (menuChoice) {
		case 1:
			// -------------------------- CODE FOR
			// PROJECTLIST------------------------------------------

			while (projectYesNo == 1) {
				System.out.println("Enter the name of the project");
				projectName = projectScan.next();

				File projectFile = new File("src/ProjectList.txt");
				FileWriter projectFw = new FileWriter(projectFile, true);
				PrintWriter projectPw = new PrintWriter(projectFw);
				projectPw.println(projectName);

				projectPw.close(); // option to add more project names
				System.out.println("Do you want to enter a new project?(1 for yes, any other number for no)");
				projectYesNo = scan.nextInt();

				// ERROR IF A STRING OR LETTER IS TYPED. HAVE TO FIX if (projectYesNo != 1) {
				System.out.println("Project name entering complete");
			}
			break;
		case 2:
			// -------------- CODE FOR ADDING STUDENT
			// DETAILS------------------------------------

			while (studentYesNo == 1) {
				System.out.println("What is your first name");
				firstName = scan.next();
				System.out.println("What is your last name");
				lastName = scan.next();
				while (genderConfirm == 1) {
					System.out.println("What is your gender(type in male or female");
					gender = scan.next();

					if (!gender.equals("male") && !gender.equals("female")) {
						System.out.println("Unspecified. Please enter again. type in male or female");
						genderConfirm = 1;
					} else {
						genderConfirm = 0;
					}

				}
				genderConfirm = 1; // outside the while loop to reset the count in case more student
				// details want to be added.
				while (gpa > 4) {
					System.out.println("what is your gpa");
					gpa = scan.nextDouble();

					if (gpa > 4 || gpa < 0) {
						System.out.println("Gpa is out of bounds");

					}
				}
				// question about personality
				while (personalityConfirm == 1) {
					System.out.println(
							"What is your personality type? (Choose between inspector, counselor,mastermind,giver,provider and supervisor");
					personType = scan.next();
					if (!personType.equals("inspector") && !personType.equals("counselor")
							&& !personType.equals("mastermind") && !personType.equals("giver")
							&& !personType.equals("provider") && !personType.equals("supervisor")) {
						System.out.println(" Please enter a valid personality type");
						personalityConfirm = 1;
					} else {
						personalityConfirm = 0;
					}
				}
				personalityConfirm = 1;// outside the while loop to reset the count in case more student details
				// want to be added
				System.out.println("how much years of experience do you have?");
				yrsOfExp = scan.nextInt();
				// student chooses their 2 most favourite roles and the sub roles they would
				// like.
				while (role1Validation == 1) {
					System.out.println(
							" First role you would be interested in?(Type in  database,programmer,designer or leader");
					role1 = scan.next();
					if (!role1.equals("database") && !role1.equals("programmer") && !role1.equals("designer")
							&& !role1.equals("leader")) {
						System.out.println("Please enter a valid role");
						role1Validation = 1;
					} else {
						role1Validation = 0;
					}
				}

				while (role2Validation == 1) {
					System.out
							.println("Second role you would be interested in?(database,programmer,designer or leader");
					role2 = scan.next();
					if (!role2.equals("database") && !role2.equals("programmer") && !role2.equals("designer")
							&& !role2.equals("leader")) {
						System.out.println("Please enter a valid role");
						role2Validation = 1;
					} else {
						role2Validation = 0;
					}
				}
				// adds the first preference project title for the student from the ProjectList
				// text file
				BufferedReader projectListLineReader = new BufferedReader(new FileReader("src/ProjectList.txt"));
				int projectListLines = 0;

				// counts the number of lines in a projectListFile
				while (projectListLineReader.readLine() != null)
					projectListLines++;
				{
					projectListLineReader.close();
				}
				// arrays for storing each line and the unique id from that line respectively
				String[] uniqueLineProjectList = new String[projectListLines];

				// loop to print all lines into an array
				for (int m = 0; m < projectListLines; m++) {
					uniqueLineProjectList[m] = Files.readAllLines(Paths.get("src/ProjectList.txt")).get(m);
				}
				System.out.println("Please enter your first project preference(no spaces)");
				projectPreference1 = scan.next();

				for (int n = 0; n < uniqueLineProjectList.length; n++) {
					if (projectPreference1.replace(" ", "")
							.equalsIgnoreCase(uniqueLineProjectList[n].replace(" ", ""))) {
						projectPreference1 = confirmedProjectPreference1;
						confirmedProjectPreference1 = uniqueLineProjectList[n];
						break;
					}
				}

				// adds the second preference project title for the student from the ProjectList
				// text file
				BufferedReader projectListLineReadertwo = new BufferedReader(new FileReader("src/ProjectList.txt"));
				int projectListLinestwo = 0;

				// counts the number of lines in a projectListFile
				while (projectListLineReadertwo.readLine() != null)
					projectListLinestwo++;
				{
					projectListLineReadertwo.close();
				}
				// arrays for storing each line and the unique id from that line respectively
				String[] uniqueLineProjectListtwo = new String[projectListLinestwo];

				// loop to print all lines into an array
				for (int p = 0; p < projectListLinestwo; p++) {
					uniqueLineProjectListtwo[p] = Files.readAllLines(Paths.get("src/ProjectList.txt")).get(p);
				}
				System.out.println("Please enter your second project preference(no spaces)");
				projectPreference2 = scan.next();

				for (int q = 0; q < uniqueLineProjectListtwo.length; q++) {
					if (projectPreference2.replace(" ", "")
							.equalsIgnoreCase(uniqueLineProjectListtwo[q].replace(" ", ""))) {
						projectPreference2 = confirmedProjectPreference2;
						confirmedProjectPreference2 = uniqueLineProjectList[q];
						break;
					}
				}

				// LOGIC FOR GENERATING UNIQUE ID FOR EACH STUDENT
				firstNameSubString = firstName.substring(0, 2);
				lastNameSubString = lastName.substring(0, 2);
				randomNumID = numberStudentIdGen.nextInt(10000);
				completeStudentId.append(firstNameSubString).append(lastNameSubString).append(randomNumID);

				// PRINTS OUT INPUTS INTO THE STUDENTLIST TEXT FILE
				File studentFile = new File("src/StudentList.txt");
				FileWriter studentFw = new FileWriter(studentFile, true);
				PrintWriter studentPw = new PrintWriter(studentFw);
				studentPw.println(completeStudentId + "|" + firstName + "|" + lastName + "|" + gender + "|" + gpa + "|"
						+ personType + "|" + yrsOfExp + "|" + role1 + "|" + role2 + "|" + confirmedProjectPreference1
						+ "|" + confirmedProjectPreference2);

				studentPw.close();

				System.out.println("Do you want to enter a new student?(press 1 for yes, any other number for no");
				studentYesNo = scan.nextInt();
				completeStudentId.setLength(0);// clears stringbuilder so its ready for new input with user decides to
												// add another student.
				if (studentYesNo != 1) {
					System.out.println("Student detail entering complete!!");
				}
			}
			break;
		case 3:
			while (generateTeamYesNo == 1) {
			int studentListLines = 0; // variable for counting the number of lines in a StudentListfile

			Random uniqueIdChooser = new Random();

			// counts the number of lines in a studentListfile

			BufferedReader StudentListLineReader = new BufferedReader(new FileReader("src/StudentList.txt"));
			while (StudentListLineReader.readLine() != null)
				studentListLines++; {
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
				studentArrayList.add(
						Files.readAllLines(Paths.get("src/StudentList.txt")).get(studentListCount).split("\\|")[5]);

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
					counselorSecondProjectList.add(Files.readAllLines(Paths.get("src/StudentList.txt"))
							.get(studentListCount).split("\\|")[10]);
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
					mastermindSecondProjectList.add(Files.readAllLines(Paths.get("src/StudentList.txt"))
							.get(studentListCount).split("\\|")[10]);
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
					otherSecondProjectListA.add(Files.readAllLines(Paths.get("src/StudentList.txt"))
							.get(studentListCount).split("\\|")[10]);
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
					otherSecondProjectListB.add(Files.readAllLines(Paths.get("src/StudentList.txt"))
							.get(studentListCount).split("\\|")[10]);
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
							+ confirmedOtherGpaListA[randomUniqueId3] + confirmedOtherGpaListB[randomUniqueId4])
							/ 4 <= 3
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

			//System.out.println(counselorFirstProjectList.get(randomUniqueId));
			//System.out.println(mastermindFirstProjectList.get(randomUniqueId2));
			//System.out.println(otherFirstProjectListA.get(randomUniqueId3));
			//System.out.println(otherFirstProjectListB.get(randomUniqueId4));

			//System.out.println(femaleCounter);
			//System.out.println(yrsOfExperienceCounter);
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
					+ mastermindGenderList.get(randomUniqueId2) + "-" + confirmedMastermindGpaList[randomUniqueId2]
					+ " " + "GPA" + "-" + confirmedMastermindExpList[randomUniqueId2] + " " + "Years of experience."
					+ "-" + mastermindFirstJobList.get(randomUniqueId2) + "-"
					+ mastermindFirstProjectList.get(randomUniqueId2));
			System.out.println(UniqueIdOtherPersonalityListA.get(randomUniqueId3) + "-"
					+ otherPersonalityListA.get(randomUniqueId3) + "-" + otherGenderListA.get(randomUniqueId3) + "-"
					+ confirmedOtherGpaListA[randomUniqueId3] + " " + "GPA" + "-"
					+ confirmedOtherExpListA[randomUniqueId3] + " " + "Years of experience." + "-"
					+ otherFirstJobListA.get(randomUniqueId3) + "-" + otherFirstProjectListA.get(randomUniqueId3));
			System.out.println(UniqueIdOtherPersonalityListB.get(randomUniqueId4) + "-"
					+ otherPersonalityListB.get(randomUniqueId4) + "-" + otherGenderListB.get(randomUniqueId4) + "-"
					+ confirmedOtherGpaListB[randomUniqueId4] + " " + "GPA" + "-"
					+ confirmedOtherExpListB[randomUniqueId4] + " " + "Years of experience." + "-"
					+ otherFirstJobListB.get(randomUniqueId4) + "-" + otherFirstProjectListB.get(randomUniqueId4));
		
			System.out.println();
			System.out.println("Do you want to generate a new team?(press 1 for yes, any other number for no");
			generateTeamYesNo = scan.nextInt();
			
			if (generateTeamYesNo != 1) {
				System.out.println("generating Team process complete!!");
			}
			}
		
			break;
			
		}
	}
}
