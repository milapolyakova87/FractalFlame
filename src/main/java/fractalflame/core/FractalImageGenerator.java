package fractalflame.core;

import fractalflame.model.FractalImage;
import fractalflame.model.Rect;
import fractalflame.model.Variation;
import java.util.List;

public interface FractalImageGenerator {
    FractalImage generate(
        int width,
        int height,
        int iterations,
        List<Variation> variations,
        Rect world
    );
}
