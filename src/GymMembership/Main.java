package GymMembership;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Member> members = IOUtil.readMembersFromFile("src/data.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ange ett namn eller personnummer: ");
            String input = scanner.nextLine();
            Member foundMember = null;
            for (Member member : members) {

                if (member.getPersonnummer().equals(input) || member.getName().equalsIgnoreCase(input)) {
                    foundMember = member;
                    break;
                }
            }

            if (foundMember == null) {
                System.out.println("Obehörig besökare.");
            } else if (foundMember.isMembershipActive()) {
                System.out.println("Medlemskapet är aktivt.");
                foundMember.registerTraining();
                IOUtil.writeMembersToFile("träningslogg.txt", foundMember);
            } else {
                System.out.println("Medlemskapet har gått ut.");
            }

        }


    }


}