package fractalflame.postprocessing;

import fractalflame.model.FractalImage;

@FunctionalInterface
public interface ImageProcessor {
    void process(FractalImage image);
}
