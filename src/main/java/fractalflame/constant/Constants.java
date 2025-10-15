package fractalflame.constant;

import fractalflame.model.Rect;
import java.awt.Color;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    public static final String CONFIG_PATH = "src/main/resources/config.json";
    public static final String OUTPUT_DIRECTORY = "fractals";
    public static final int WARMUP_ITERATIONS = 20;
    public static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final double X_RECT = -1;
    public static final double Y_RECT = -1;
    public static final double WIDTH_RECT = 2;
    public static final double HEIGHT_RECT = 2;
    public static final Rect WORLD = new Rect(X_RECT, Y_RECT, WIDTH_RECT, HEIGHT_RECT);
    public static final double GAMMA = 6.0;
}
