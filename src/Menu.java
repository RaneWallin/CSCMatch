import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


public class Menu {
	
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
	
	private static void quit() {
		System.exit(0);
	}
	public static void main(String[] args) {
		String memberName;
		int gradeYear;
		String interestIn;
		int interestScore;
		Interest interest = new Interest();
		Member member;
		MemberSet members = new MemberSet(new InterestMap);

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter name of the person.");
		memberName = s.nextLine();
		
		System.out.println("Enter the grade year. (Freshman = 1, Sophomore = 2, Junior = 3,"
				+ " Senior = 4, CS student with degree = 5)");
		gradeYear = s.nextInt();
		s.nextLine();
		
		//addMember(memberName, gradeYear);
		member = new Member(memberName, gradeYear, members);
		members.addMember(member);

		
		System.out.println("Enter the interest.");
		interestIn = s.nextLine();
		interest.setName(interestIn);
		
		System.out.println("Enter score for interest.");
		interestScore = s.nextInt();
		interest.setScore(interestScore);
		
		//System.out.println("Adding Interest:");
		//addInterest(memberName, interestIn, interest);
		
		System.out.println(memberList);
		
		

	}

}
