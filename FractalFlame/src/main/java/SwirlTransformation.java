public class SwirlTransformation extends Transformation {
    @Override
    public void apply(double[] point) {
        double r = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        double newX = point[0] * Math.sin(r * r) - point[1] * Math.cos(r * r);
        double newY = point[0] * Math.cos(r * r) + point[1] * Math.sin(r * r);
        point[0] = newX;
        point[1] = newY;
    }
}
