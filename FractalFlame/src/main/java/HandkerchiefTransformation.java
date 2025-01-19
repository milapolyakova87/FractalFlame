public class HandkerchiefTransformation extends Transformation {
    @Override
    public void apply(double[] point) {
        double r = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        double theta = Math.atan2(point[1], point[0]);
        double newX = r * Math.sin(theta + r);
        double newY = r * Math.cos(theta - r);
        point[0] = newX;
        point[1] = newY;
    }
}
