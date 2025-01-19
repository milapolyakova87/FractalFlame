public class PolarTransformation extends Transformation {
    @Override
    public void apply(double[] point) {
        double theta = Math.atan2(point[1], point[0]);
        double r = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        point[0] = theta / Math.PI;
        point[1] = r - 1;
    }
}
