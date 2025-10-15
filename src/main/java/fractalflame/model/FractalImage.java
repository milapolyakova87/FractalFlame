package fractalflame.model;

import fractalflame.model.pixel.Pixel;
import java.awt.Color;

public record FractalImage(int width, int height, Pixel[][] data) {

    public Pixel pixel(PixelPoint pixelPoint) {
        return pixel(pixelPoint.x(), pixelPoint.y());
    }

    public Pixel pixel(int x, int y) {
        return data[y][x];
    }

    public Color[][] getColorsOfImage() {
        Color[][] colors = new Color[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                colors[i][j] = data[i][j].color();
            }
        }

        return colors;
    }

    public boolean contains(PixelPoint pixelPoint) {
        return contains(pixelPoint.x(), pixelPoint.y());
    }

    public boolean contains(int x, int y) {
        return x > 0 && x < width
            && y > 0 && y < height;
    }
}
