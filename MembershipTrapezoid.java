class MembershipTrapezoid {
    private float a, b, c, d;

    public MembershipTrapezoid(float a, float b, float c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public float getMembership(float value) {
        Line line = null;
        if (value >= a && value <= b) {
            line = Line.fromTwoPoints(new CartesianPoint(a, 0), new CartesianPoint(b, 1));
        } else if (value > b && value <= c) {
            line = Line.fromTwoPoints(new CartesianPoint(b, 1), new CartesianPoint(c, 1));
        } else if (value > c && value <= d) {
            line = Line.fromTwoPoints(new CartesianPoint(c, 1), new CartesianPoint(d, 0));
        }
        if (line != null) {
            return line.getY(value);
        } else {
            return 0;
        }
    }

    public float getCentroid() {
        return (a + b + c + d) / 4.0f;
    }
}
