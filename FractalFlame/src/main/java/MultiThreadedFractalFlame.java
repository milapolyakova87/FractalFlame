import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedFractalFlame extends FractalFlame {
    private final int numThreads;

    public MultiThreadedFractalFlame(int width, int height, int iterations, List<Transformation> transformations, int numThreads) {
        super(width, height, iterations, transformations);
        this.numThreads = numThreads;
    }

    @Override
    public BufferedImage generateFlame() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        try (ExecutorService executor = Executors.newFixedThreadPool(numThreads)) {
            for (int i = 0; i < numThreads; i++) {
                executor.submit(() -> {
                    double[] point = {random.nextDouble() * 2 - 1, random.nextDouble() * 2 - 1};
                    for (int j = 0; j < iterations / numThreads; j++) {
                        Transformation t = transformations.get(random.nextInt(transformations.size()));
                        t.apply(point);
                        int px = (int) ((point[0] + 1) * width / 2);
                        int py = (int) ((point[1] + 1) * height / 2);
                        if (px >= 0 && px < width && py >= 0 && py < height) {
                            synchronized (image) {
                                image.setRGB(px, py, image.getRGB(px, py) + 1);
                            }
                        }
                    }
                });
            }

            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return image;
    }
}
