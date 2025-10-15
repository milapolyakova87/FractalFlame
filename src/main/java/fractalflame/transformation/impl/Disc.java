package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Disc implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double theta = point.distance();
        return new Point(theta * Math.sin(Math.PI * r) / Math.PI, theta * Math.cos(Math.PI * r) / Math.PI);
    }
}
