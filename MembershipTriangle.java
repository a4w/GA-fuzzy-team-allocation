class MembershipTriangle {
    private float a, b, c;

    public MembershipTriangle(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float getMembership(float value) {
        Line line = null;
        if (value >= a && value <= b) {
            line = Line.fromTwoPoints(new CartesianPoint(a, 0), new CartesianPoint(b, 1));
        } else if (value > b && value <= c) {
            line = Line.fromTwoPoints(new CartesianPoint(b, 1), new CartesianPoint(c, 0));
        }
        if (line != null) {
            return line.getY(value);
        } else {
            return 0;
        }
    }

    public float getCentroid() {
        return (a + b + c) / 3.0f;
    }
}
