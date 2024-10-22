package GymMembership;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IOUtilTest {

    @Test
    public void testReadMembersFromFile() {
        List<Member> members = IOUtil.readMembersFromFile("test/testdata.txt");

        assertFalse(members.isEmpty(), "Medlemslistan ska inte vara tom.");
        assertEquals(2, members.size(), "Det ska finnas två medlemmar i listan.");

        Member firstMember = members.get(0);
        assertEquals("7703021234", firstMember.getPersonnummer(), "Personnummer ska stämma.");
        assertEquals("Alhambra Aromes", firstMember.getName(), "Namn ska stämma.");
        assertEquals(LocalDate.of(2024, 7, 1), firstMember.getPaymentDate(), "Betalningsdatum ska stämma.");

        Member secondMember = members.get(1);
        assertEquals("8204021234", secondMember.getPersonnummer(), "Personnummer ska stämma");
        assertEquals("Bear Belle", secondMember.getName(), "Namnet ska stämma");
        assertEquals(LocalDate.of(2019, 12, 2), secondMember.getPaymentDate(), "Betalningdatum ska stämma.");
    }

    @Test
    public void testWriteMembersToFile() {
        String testFileName = "test/test_write_members.txt";

        Member testMember = new Member("0001032345", "Elias OIsson", LocalDate.of(2024, 1, 1));
        IOUtil.writeMembersToFile(testFileName, testMember);

        try (BufferedReader reader = new BufferedReader(new FileReader(testFileName))) {
            String line = reader.readLine();
            assertTrue(line.contains("Personnummer: 0001032345"), "Personnumret ska finnas i filen.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
