public class HorseshoeTransformation extends Transformation {
    @Override
    public void apply(double[] point) {
        double r = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        double newX = (point[0] - point[1]) * (point[0] + point[1]) / r;
        double newY = 2 * point[0] * point[1] / r;
        point[0] = newX;
        point[1] = newY;
    }
}
