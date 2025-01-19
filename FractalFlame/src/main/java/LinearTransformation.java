public class LinearTransformation extends Transformation {
    private final double a, b, c, d, e, f;

    public LinearTransformation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    @Override
    public void apply(double[] point) {
        double x = point[0];
        double y = point[1];
        double newX = a * x + b * y + c;
        double newY = d * x + e * y + f;
        point[0] = newX;
        point[1] = newY;
    }
}
