class ProjectFundingMembership {
    private float veryLow;
    private float low;
    private float medium;
    private float high;

    private static MembershipTrapezoid veryLowMembership = new MembershipTrapezoid(-0.001f, 0, 10, 30);
    private static MembershipTrapezoid lowMembership = new MembershipTrapezoid(10, 30, 40, 60);
    private static MembershipTrapezoid mediumMembership = new MembershipTrapezoid(40, 60, 70, 90);
    private static MembershipTrapezoid highMembership = new MembershipTrapezoid(70, 90, 100, 100.001f);

    public ProjectFundingMembership(float veryLow, float low, float medium, float high) {
        this.veryLow = veryLow;
        this.low = low;
        this.medium = medium;
        this.high = high;
    }

    public static ProjectFundingMembership calculateForCrisp(float crisp) {
        float veryLow = veryLowMembership.getMembership(crisp);
        float low = lowMembership.getMembership(crisp);
        float medium = mediumMembership.getMembership(crisp);
        float high = highMembership.getMembership(crisp);
        return new ProjectFundingMembership(veryLow, low, medium, high);
    }

    public float getVeryLow() {
        return veryLow;
    }

    public float getLow() {
        return low;
    }

    public float getMedium() {
        return medium;
    }

    public float getHigh() {
        return high;
    }

    public float getVeryLowCentroid() {
        return veryLowMembership.getCentroid();
    }

    public float getLowCentroid() {
        return lowMembership.getCentroid();
    }

    public float getMediumCentroid() {
        return mediumMembership.getCentroid();
    }

    public float getHighCentroid() {
        return highMembership.getCentroid();
    }
}
