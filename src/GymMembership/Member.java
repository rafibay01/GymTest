package GymMembership;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Member {
    protected String name;
    protected String personnummer;
    protected LocalDate paymentDate;
    protected List<LocalDate> trainingDates;


    public Member(String personnummer, String name, LocalDate paymentDate) {
        this.personnummer = personnummer;
        this.name = name;
        this.paymentDate = paymentDate;
        this.trainingDates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public boolean isMembershipActive() {
        return LocalDate.now().isBefore(paymentDate.plusYears(1));
    }

    public void registerTraining() {
        trainingDates.add(LocalDate.now());
    }


}