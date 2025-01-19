import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class FractalFlameTest {
    public static void main(String[] args) throws IOException {
        List<Transformation> transformations = new ArrayList<>();
        transformations.add(new LinearTransformation(0.5, 0.5, 0, 0.5, -0.5, 0.5));
        transformations.add(new SinusoidalTransformation());
        transformations.add(new SphericalTransformation());
        transformations.add(new SwirlTransformation());
        transformations.add(new HorseshoeTransformation());
        transformations.add(new PolarTransformation());
        transformations.add(new HandkerchiefTransformation());

        FractalFlame singleThreaded = new FractalFlame(800, 600, 10000000, transformations); // Увеличим количество итераций
        long startTime = System.currentTimeMillis();
        BufferedImage singleThreadedImage = singleThreaded.generateFlame();
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded time: " + (endTime - startTime) + " ms");

        // Save or display singleThreadedImage
        ImageIO.write(singleThreadedImage, "png", new File("single_threaded_flame.png"));

        MultiThreadedFractalFlame multiThreaded = new MultiThreadedFractalFlame(800, 600, 10000000, transformations, 4); // Увеличим количество итераций
        startTime = System.currentTimeMillis();
        BufferedImage multiThreadedImage = multiThreaded.generateFlame();
        endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded time: " + (endTime - startTime) + " ms");

        // Save or display multiThreadedImage
        ImageIO.write(multiThreadedImage, "png", new File("multi_threaded_flame.png"));
    }
}
