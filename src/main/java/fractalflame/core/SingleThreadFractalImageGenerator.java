package fractalflame.core;

import fractalflame.constant.Constants;
import fractalflame.model.FractalImage;
import fractalflame.model.Rect;
import fractalflame.model.Variation;
import fractalflame.model.pixel.Pixel;
import fractalflame.model.pixel.UnsafePixel;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SingleThreadFractalImageGenerator implements FractalImageGenerator {
    @Override
    public FractalImage generate(
        int width,
        int height,
        int iterations,
        List<Variation> variations,
        Rect world
    ) {
        FractalImage image = new FractalImage(width, height, unsafePixelMatrix(width, height));

        FractalGeneratingProcessor processor = new FractalGeneratingProcessor(new Random(), variations, world);

        processor.process(image, iterations);

        return image;
    }

    private Pixel[][] unsafePixelMatrix(int width, int height) {
        Pixel[][] data = new Pixel[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                data[i][j] = new UnsafePixel(Constants.BACKGROUND_COLOR, 0);
            }
        }

        return data;
    }

}
