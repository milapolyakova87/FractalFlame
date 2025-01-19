public class SinusoidalTransformation extends Transformation {
    @Override
    public void apply(double[] point) {
        point[0] = Math.sin(point[0]);
        point[1] = Math.sin(point[1]);
    }
}
