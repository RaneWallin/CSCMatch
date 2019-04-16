import java.util.Scanner;


public class CSCMatch {
	
	private static void quit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		Boolean quit = false;
		String memberName, interestName, fileName, otherChoice;
		int gradeYear, interestScore, choice;
		Interest interest;
		Member member;
		MemberSet members = new MemberSet(new InterestMap());

		Scanner s = new Scanner(System.in);

		System.out.println("What would you like to do (pick a number)?\n1. Load members " +
				" 2. Save members 3. List all members 4. Add a member " +
				"5. Remove a member 6. List member 7. Add an interest to a member " +
				"8. Quit");
		choice = s.nextInt();

		while(!quit) {

			switch(choice) {
				case 1: // Load membes
					System.out.println("Enter the file name: ");
					fileName = s.next();
					break;
				case 2: // Save members
					System.out.println("Enter file name: ");
					fileName = s.next();
					break;
				case 3: // Print all members
					members.toString();
					break;
				case 4: // Add new member

					System.out.println("Enter new member's name: ");
					memberName = s.next();

					// Check if member exists
					if (members.hasMemberByName(memberName)) {
						System.out.println("This member exists, do you with to overwrite them? [Y/N] ");
						otherChoice = s.next();

						// ask user if they want to replace the member and delete then member from
                        // the MemberMap if they do
						if (otherChoice.toLowerCase() == "y") {
							members.removeMember(members.getMemberByName(memberName));
						}
					}

					// Add the member if they don't exist
					if (!members.hasMemberByName(memberName)) {
					    // Get the member's year
                        // TODO - add error handling
						System.out.println("What year is this member: ");
						gradeYear = s.nextInt();

						// Add member to MemberMap
						members.addMember(new Member(memberName, gradeYear, members));
					}
					break;
				case 5: // Remove member
					System.out.println("Enter name of member to remove: ");
					memberName = s.next();
					// Veify member exists
					if (!members.hasMemberByName(memberName)) {
						System.out.println("This member does not exist.");
					} else {
					    // Remove member
						members.removeMember(members.getMemberByName(memberName));
					}
					break;
				case 6: // Print single members
					System.out.println("Enter name of member to list: ");
					memberName = s.next();
					member = members.getMemberByName(memberName);
					member.toString();
					break;
				case 7: // Add an interest to the member
					System.out.println("Enter member name: ");
					memberName = s.next();
					// TODO - add error handling
					if (members.hasMemberByName(memberName)) {
						member = members.getMemberByName(memberName);
						System.out.println("What is the interest? ");
						interestName = s.next();

						System.out.println("What is the interest level? ");
						interestScore = s.nextInt();

						interest = new Interest(interestName, interestScore);

						member.addInterest(interest);
					}
					else System.out.println("This member does not exist.");
					break;
				case 8:
					quit = true;
					break;
				default:
					System.out.println("Invalid choice, please pick again or type 8 to quit.");
			}
			System.out.println("What would you like to do (pick a number)?\n1. Load members " +
					" 2. Save members 3. List all members 4. Add a member " +
					"5. Remove a member 6. List member 7. Add an interest to a member " +
					"8. Quit");
			choice = s.nextInt();
		}

		quit();

	}

}




//	static LinkedList<Member> memberList = new LinkedList();
//
//
//
//	private static void loadFile() {
//
//	}
//
//	private static void saveFile() {
//
//	}
//
//	private static void removeFile() {
//
//	}
//
//	private static void addMember(String memberName, int gradeYear) {
//		HashMap map = new HashMap<>();
//		Member member1 = new Member(memberName, gradeYear);
//		memberList.add(member1);
//	}
//
//	private static void removeMember(String memberName) {
//		Member member = new Member(memberName, 0);
//
//		memberList.remove(member);
//
//
//	}
//
//	private static void listMember() {
//
//		for (Member member : memberList) {
//			System.out.println(member);
//		}
//
//	}
//
//	private static void addInterest(String memberName, String interestname, Interest interest) {
//
//		Member memberin = new Member(memberName, 0);
//		for (Member member : memberList) {
//			if (member.equals(memberin)) {
//				member.getInterest().put(interestname, interest);
//			}
//		}
//
//	}

//		System.out.println("Enter name of the person.");
//		memberName = s.nextLine();
//
//		System.out.println("Enter the grade year. (Freshman = 1, Sophomore = 2, Junior = 3,"
//				+ " Senior = 4, CS student with degree = 5)");
//		gradeYear = s.nextInt();
//		s.nextLine();
//
//		//addMember(memberName, gradeYear);
//		member = new Member(memberName, gradeYear, members);
//		members.addMember(member);
//
//
//		System.out.println("Enter the interest.");
//		interestIn = s.nextLine();
//		interest.setName(interestIn);
//
//		System.out.println("Enter score for interest.");
//		interestScore = s.nextInt();
//		interest.setScore(interestScore);
//
//		//System.out.println("Adding Interest:");
//		//addInterest(memberName, interestIn, interest);
//		members.getMemberByName()