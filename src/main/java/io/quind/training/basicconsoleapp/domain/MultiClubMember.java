package io.quind.training.basicconsoleapp.domain;

public class MultiClubMember extends Member {
    private int membershipPoints;

    public MultiClubMember(int memberID, char memberType, String name, double fees, int membershipPoints) {
        super(memberID, memberType, name, fees);
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + membershipPoints;
    }
}
