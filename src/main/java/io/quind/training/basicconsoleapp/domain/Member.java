package io.quind.training.basicconsoleapp.domain;

public class Member {
    private int memberID;
    private char memberType;
    private String name;
    private double fees;

    public Member(int memberID, char memberType, String name, double fees) {
        this.memberID = memberID;
        this.memberType = memberType;
        this.name = name;
        this.fees = fees;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.1f", memberID, memberType, name, fees);
    }
}
