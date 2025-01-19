import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class GammaCorrectionTest {
    public static void main(String[] args) throws IOException {
        List<Transformation> transformations = new ArrayList<>();
        transformations.add(new LinearTransformation(0.5, 0.5, 0, 0.5, -0.5, 0.5));
        transformations.add(new SinusoidalTransformation());
        transformations.add(new SphericalTransformation());
        transformations.add(new SwirlTransformation());
        transformations.add(new HorseshoeTransformation());
        transformations.add(new PolarTransformation());
        transformations.add(new HandkerchiefTransformation());

        FractalFlame fractalFlame = new FractalFlame(800, 600, 1000000, transformations);
        BufferedImage image = fractalFlame.generateFlame();

        // Применение гамма-коррекции
        BufferedImage gammaCorrectedImage = fractalFlame.applyGammaCorrection(image, 2.2);

        // Сохранение изображений для сравнения
        ImageIO.write(image, "png", new File("original_flame.png"));
        ImageIO.write(gammaCorrectedImage, "png", new File("gamma_corrected_flame.png"));
    }
}
