import java.util.Scanner;


public class CSCMatch {
	
	private static void quit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		Boolean quit = false;
		String memberName, interestIn, fileName, otherChoice;
		int gradeYear, interestScore, choice;
		Interest interest;
		Member member;
		MemberSet members = new MemberSet(new InterestMap());

		Scanner s = new Scanner(System.in);

		while(s.hasNext() && !quit) {
			System.out.println("What would you like to do (pick a number)?\n1. Load members " +
					" 2. Save members 3. List all members 4. Add a member " +
					"5. Remove a member 6. List member 7. Add an interest to a member " +
					"8. Quit");
			choice = s.nextInt();

			switch(choice) {
				case 1:
					System.out.println("Enter the file name: ");
					fileName = s.next();
					break;
				case 2:
					System.out.println("Enter file name: ");
					fileName = s.next();
					break;
				case 3:
					members.toString();
				case 4:
					System.out.println("Enter new member's name: ");
					memberName = s.next();
					if (members.hasMemberByName(memberName)) {
						System.out.println("This member exists, do you with to overwrite them? [Y/N] ");
						otherChoice = s.next();

						if (otherChoice.toLowerCase() == "y") {
							members.removeMember(members.getMemberByName(memberName));
						}
					}

					if (!members.hasMemberByName(memberName)) {
						System.out.println("What year is this member: ");
						gradeYear = s.nextInt();

						members.addMember(new Member(memberName, gradeYear));
					}
				case 5:
					System.out.println("Enter name of member to remove: ");
					memberName = s.next();
					if (!members.hasMemberByName(memberName)) {
						System.out.println("This member does not exist.");
					} else {
						members.removeMember(members.getMemberByName(memberName));
					}
				case 6:
					System.out.println("Enter name of member to list: ");
					memberName = s.next();
					member = members.getMemberByName(memberName);
					member.toString();
				case 7:
				case 8:
					quit = true;
				default:
					System.out.println("Invalid choice, please pick again or type 8 to quit.");
			}
		}

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