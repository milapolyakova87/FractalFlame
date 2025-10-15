package fractalflame.transformation.impl;

import fractalflame.model.Point;
import fractalflame.transformation.Transformation;

public class Heart implements Transformation {
    @Override
    public Point apply(Point point) {
        double r = point.distance();
        double theta = point.theta();
        return new Point(r * Math.sin(theta * r), -r * Math.cos(theta * r));
    }
}
