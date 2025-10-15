package fractalflame.service;

import fractalflame.constant.Constants;
import fractalflame.core.FractalImageGenerator;
import fractalflame.dto.FractalImageRequest;
import fractalflame.model.FractalImage;
import fractalflame.model.Rect;
import fractalflame.model.Variation;
import fractalflame.postprocessing.ImageProcessor;
import fractalflame.transformation.Transformation;
import fractalflame.transformation.impl.Symmetry;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FractalFlameService {
    private final FractalImageGenerator fractalImageGenerator;
    private final ImageProcessor imageProcessor;

    public FractalImage createFractalImage(FractalImageRequest request) {
        List<Variation> variations = request.variations();

        addSymmetry(variations, request.symmetry(), Constants.WORLD);

        return fractalImageGenerator.generate(
            request.width(),
            request.height(),
            request.iterations(),
            request.variations(),
            Constants.WORLD
        );
    }

    public FractalImage postProcessing(FractalImage image) {
        imageProcessor.process(image);

        return image;
    }

    private void addSymmetry(List<Variation> variations, int symmetryParts, Rect world) {
        double sum = variations.stream()
            .mapToDouble(Variation::weight).sum();
        Transformation symmetry = new Symmetry(symmetryParts, world);

        variations.add(new Variation(symmetry, sum, null));
    }
}
