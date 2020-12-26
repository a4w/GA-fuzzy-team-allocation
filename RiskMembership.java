class RiskMembership {
    private float high;
    private float normal;
    private float low;

    private static MembershipTriangle highMembership = new MembershipTriangle(0, 25, 50);
    private static MembershipTriangle normalMembership = new MembershipTriangle(25, 50, 75);
    private static MembershipTriangle lowMembership = new MembershipTriangle(50, 100, 100.001f);

    public RiskMembership(float high, float normal, float low) {
        this.high = high;
        this.normal = normal;
        this.low = low;
    }

    public static RiskMembership calculateForCrisp(float crisp) {
        float high = highMembership.getMembership(crisp);
        float normal = normalMembership.getMembership(crisp);
        float low = lowMembership.getMembership(crisp);
        return new RiskMembership(high, normal, low);
    }

    public float getHigh() {
        return high;
    }

    public float getNormal() {
        return normal;
    }

    public float getLow() {
        return low;
    }

    static public float getHighCentroid() {
        return highMembership.getCentroid();
    }

    static public float getNormalCentroid() {
        return normalMembership.getCentroid();
    }

    static public float getLowCentroid() {
        return lowMembership.getCentroid();
    }

}
