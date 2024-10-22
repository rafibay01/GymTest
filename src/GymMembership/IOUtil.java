package GymMembership;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {


    public static List<Member> readMembersFromFile(String fileName) {
        List<Member> members = new ArrayList<Member>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                String personnummer = parts[0].trim();
                String name = parts[1].trim();

                String dateLine = br.readLine();
                if (dateLine == null) {
                    break;
                }

                LocalDate paymentDate = LocalDate.parse(dateLine.trim(), formatter);
                members.add(new Member(personnummer,name,paymentDate));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return members;

    }

    public static void writeMembersToFile(String fileName, Member member) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println("Personnummer: " + member.getPersonnummer() + " Medlem: " + member.getName() + " Träningsdatum: " + LocalDate.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}