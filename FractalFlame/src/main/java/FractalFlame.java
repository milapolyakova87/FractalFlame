import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

public class FractalFlame {
    protected final int width;
    protected final int height;
    protected final int iterations;
    protected final List<Transformation> transformations;
    protected final Random random;

    public FractalFlame(int width, int height, int iterations, List<Transformation> transformations) {
        this.width = width;
        this.height = height;
        this.iterations = iterations;
        this.transformations = transformations;
        this.random = new Random();
    }

    public BufferedImage generateFlame() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        double[] point = {random.nextDouble() * 2 - 1, random.nextDouble() * 2 - 1};

        for (int i = 0; i < iterations; i++) {
            Transformation t = transformations.get(random.nextInt(transformations.size()));
            t.apply(point);
            int px = (int) ((point[0] + 1) * width / 2);
            int py = (int) ((point[1] + 1) * height / 2);
            if (px >= 0 && px < width && py >= 0 && py < height) {
                image.setRGB(px, py, image.getRGB(px, py) + 1);
            }
        }

        return image;
    }

    public BufferedImage generateFlameWithSymmetry(int symmetry) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        double[] point = {random.nextDouble() * 2 - 1, random.nextDouble() * 2 - 1};

        for (int i = 0; i < iterations; i++) {
            Transformation t = transformations.get(random.nextInt(transformations.size()));
            t.apply(point);
            int px = (int) ((point[0] + 1) * width / 2);
            int py = (int) ((point[1] + 1) * height / 2);
            if (px >= 0 && px < width && py >= 0 && py < height) {
                image.setRGB(px, py, image.getRGB(px, py) + 1);
            }

            if (symmetry > 0) {
                for (int j = 1; j < symmetry; j++) {
                    double angle = 2 * Math.PI * j / symmetry;
                    double newX = point[0] * Math.cos(angle) - point[1] * Math.sin(angle);
                    double newY = point[0] * Math.sin(angle) + point[1] * Math.cos(angle);
                    int sx = (int) ((newX + 1) * width / 2);
                    int sy = (int) ((newY + 1) * height / 2);
                    if (sx >= 0 && sx < width && sy >= 0 && sy < height) {
                        image.setRGB(sx, sy, image.getRGB(sx, sy) + 1);
                    }
                }
            }
        }

        return image;
    }

    public BufferedImage applyGammaCorrection(BufferedImage image, double gamma) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;
                r = (int) (Math.pow(r / 255.0, 1 / gamma) * 255);
                g = (int) (Math.pow(g / 255.0, 1 / gamma) * 255);
                b = (int) (Math.pow(b / 255.0, 1 / gamma) * 255);
                int newRGB = (r << 16) | (g << 8) | b;
                image.setRGB(x, y, newRGB);
            }
        }
        return image;
    }
}
