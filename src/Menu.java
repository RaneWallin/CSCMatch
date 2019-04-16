import java.util.Scanner;

public class Menu {

    public static void go(Scanner s) {
        Boolean quit = false, validInput = false;
        String memberName, interestName, fileName, otherChoice;
        int gradeYear, interestScore, choice;
        Interest interest;
        Member member;
        MemberSet members = new MemberSet(new InterestMap());

        System.out.println("What would you like to do (pick a number)?\n1. Load members " +
                " 2. Save members 3. List all members 4. Add a member " +
                "5. Remove a member 6. List member 7. Add an interest to a member " +
                "8. Quit");
        choice = s.nextInt();

        while (!quit) {
            switch (choice) {
                case 1: // Load membes
                    System.out.println("Enter the file name: ");
                    fileName = s.next();
                    break;
                case 2: // Save members
                    System.out.println("Enter file name: ");
                    fileName = s.next();
                    break;
                case 3: // Print all members
                    System.out.println(members.toString());
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
                        validInput = false;
                        while (!validInput) {
                            System.out.println("What grade level is this member: ");
                            try {
                                gradeYear = s.nextInt();
                                validInput = true;

                                // Add member to MemberMap
                                members.addMember(new Member(memberName, gradeYear, members));
                            } catch (Exception e) {
                                System.out.println("Please enter a number for the grade level: ");
                                // flush the buffer
                                s.nextLine();
                            }
                        }
                    }
                    break;
                case 5: // Remove member
                    System.out.println("Enter name of member to remove: ");
                    memberName = s.next();
                    // Veify member exists
                    if (!members.hasMemberByName(memberName)) {
                        System.out.println(memberName + " is not a member.");
                    } else {
                        member = members.getMemberByName(memberName);
                        if (member == null) System.out.println("Nope");
                        else System.out.println(member.getName());
                        // Remove member
                        members.removeMember(member);
                    }
                    break;
                case 6: // Print single members
                    System.out.println("Enter name of member to list: ");
                    memberName = s.next();
                    if (members.hasMemberByName(memberName)) {
                        member = members.getMemberByName(memberName);
                        System.out.println(member.toString());
                    } else {
                        System.out.println("No such member.");
                    }
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
                    } else System.out.println("This member does not exist.");
                    break;
                case 8:
                    System.out.println("Quitting....");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please pick again or type 8 to quit.");
            }
            if (!quit) {
                System.out.println("What would you like to do (pick a number)?\n1. Load members " +
                        " 2. Save members 3. List all members 4. Add a member " +
                        "5. Remove a member 6. List member 7. Add an interest to a member " +
                        "8. Quit");
                choice = s.nextInt();
            }
        }

        quit();

    }


    private static void quit() {
        System.exit(0);
    }
}
