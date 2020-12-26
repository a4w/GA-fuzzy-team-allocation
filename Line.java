class Line {
    private float slope;
    private float yIntercept;

    Line(float slope, float yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    public float getY(float x) {
        return (this.slope * x) + this.yIntercept;
    }

    public static Line fromTwoPoints(CartesianPoint a, CartesianPoint b) {
        final float slope = (b.getY() - a.getY()) / (b.getX() - a.getX());
        final float yIntercept = a.getY() - (slope * a.getX());
        return new Line(slope, yIntercept);
    }
}
