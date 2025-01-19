public class SphericalTransformation extends Transformation {
    @Override
    public void apply(double[] point) {
        double r = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        point[0] /= r * r;
        point[1] /= r * r;
    }
}
