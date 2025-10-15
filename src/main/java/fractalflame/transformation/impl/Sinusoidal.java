package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Sinusoidal implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), Math.sin(point.y()));
    }
}
