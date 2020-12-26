class TeamExperienceMembership {
    private float beginner;
    private float intermediate;
    private float expert;

    private static MembershipTriangle beginnerMembership = new MembershipTriangle(0, 15, 30);
    private static MembershipTriangle intermediateMembership = new MembershipTriangle(15, 30, 45);
    private static MembershipTriangle expertMembership = new MembershipTriangle(30, 60, 60.001f);

    public TeamExperienceMembership(float beginner, float intermediate, float expert) {
        this.beginner = beginner;
        this.intermediate = intermediate;
        this.expert = expert;
    }

    public static TeamExperienceMembership calculateForCrisp(float crisp) {
        float beginner = beginnerMembership.getMembership(crisp);
        float intermediate = intermediateMembership.getMembership(crisp);
        float expert = expertMembership.getMembership(crisp);
        return new TeamExperienceMembership(beginner, intermediate, expert);
    }

    public float getBeginner() {
        return beginner;
    }

    public float getIntermediate() {
        return intermediate;
    }

    public float getExpert() {
        return expert;
    }

    public float getBeginnerCentroid() {
        return beginnerMembership.getCentroid();
    }

    public float getIntermediateCentroid() {
        return intermediateMembership.getCentroid();
    }

    public float getExpertCentroid() {
        return expertMembership.getCentroid();
    }
}
