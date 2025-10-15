package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Noise implements Transformation {
    public static final double NOISE_VALUE = 0.5;

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();

        double noiseX = Math.random() - NOISE_VALUE;
        double noiseY = Math.random() - NOISE_VALUE;

        return new Point(x + noiseX, y + noiseY);
    }
}
