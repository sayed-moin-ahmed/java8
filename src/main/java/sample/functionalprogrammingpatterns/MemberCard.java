package sample.functionalprogrammingpatterns;

public class MemberCard {

    private int fidelityPoints;

    public MemberCard(int i) {
        this.fidelityPoints = i;
    }

    public int getFidelityPoints() {
        return fidelityPoints;
    }

    public void setFidelityPoints(int fidelityPoints) {
        this.fidelityPoints = fidelityPoints;
    }

    @Override
    public String toString() {
        return "MemberCard{" +
                "fidelityPoints=" + fidelityPoints +
                '}';
    }
}
