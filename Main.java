import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt(); // Digest number of inputs from stdin
        sc.next(); // Digest string label from stdin
        final float projectFundingCrisp = sc.nextFloat();
        sc.next(); // Digest string label from stdin
        final float experienceLevelCrisp = sc.nextFloat();
        sc.close();

        ProjectFundingMembership pfMembership = ProjectFundingMembership.calculateForCrisp(projectFundingCrisp);
        TeamExperienceMembership teMembership = TeamExperienceMembership.calculateForCrisp(experienceLevelCrisp);

        float riskLow = Math.max(pfMembership.getHigh(), teMembership.getExpert());
        float riskNormal = Math.min(pfMembership.getMedium(), teMembership.getIntermediate());
        float riskHigh_1 = pfMembership.getVeryLow();
        float riskHigh_2 = Math.min(pfMembership.getLow(), teMembership.getBeginner());

        float weightedAverage = (riskLow * RiskMembership.getLowCentroid()
                + riskNormal * RiskMembership.getNormalCentroid() + riskHigh_1 * RiskMembership.getHighCentroid()
                + riskHigh_2 * RiskMembership.getHighCentroid()) / (riskLow + riskNormal + riskHigh_1 + riskHigh_2);

        RiskMembership riskMembership = RiskMembership.calculateForCrisp(weightedAverage);
        System.out.println("Predicted value (Risk): " + weightedAverage);

        if (riskMembership.getHigh() > riskMembership.getNormal()
                && riskMembership.getHigh() > riskMembership.getLow()) {
            System.out.println("Risk will be High");
        } else if (riskMembership.getNormal() > riskMembership.getHigh()
                && riskMembership.getNormal() > riskMembership.getLow()) {
            System.out.println("Risk will be Normal");
        } else if (riskMembership.getLow() > riskMembership.getHigh()
                && riskMembership.getLow() > riskMembership.getNormal()) {
            System.out.println("Risk will be Low");
        }
        System.out.println("---");
        System.out.println("High Risk: " + riskMembership.getHigh());
        System.out.println("Normal Risk: " + riskMembership.getNormal());
        System.out.println("Low Risk: " + riskMembership.getLow());

    }
}
