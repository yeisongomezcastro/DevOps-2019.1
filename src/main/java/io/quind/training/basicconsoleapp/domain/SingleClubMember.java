package io.quind.training.basicconsoleapp.domain;

public class SingleClubMember extends Member {
    private int club;

    public SingleClubMember(int memberID, char memberType, String name, double fees, int club) {
        super(memberID, memberType, name, fees);
        this.club = club;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + club;
    }
}
