public class TransformationTest {
    public static void main(String[] args) {
        double[] point = {0.5, 0.5};

        // Тестирование LinearTransformation
        Transformation linear = new LinearTransformation(0.5, 0.5, 0, 0.5, -0.5, 0.5);
        linear.apply(point);
        System.out.println("LinearTransformation: " + point[0] + ", " + point[1]);

        // Тестирование SinusoidalTransformation
        Transformation sinusoidal = new SinusoidalTransformation();
        sinusoidal.apply(point);
        System.out.println("SinusoidalTransformation: " + point[0] + ", " + point[1]);

        // Тестирование SphericalTransformation
        Transformation spherical = new SphericalTransformation();
        spherical.apply(point);
        System.out.println("SphericalTransformation: " + point[0] + ", " + point[1]);

        // Тестирование SwirlTransformation
        Transformation swirl = new SwirlTransformation();
        swirl.apply(point);
        System.out.println("SwirlTransformation: " + point[0] + ", " + point[1]);

        // Тестирование HorseshoeTransformation
        Transformation horseshoe = new HorseshoeTransformation();
        horseshoe.apply(point);
        System.out.println("HorseshoeTransformation: " + point[0] + ", " + point[1]);

        // Тестирование PolarTransformation
        Transformation polar = new PolarTransformation();
        polar.apply(point);
        System.out.println("PolarTransformation: " + point[0] + ", " + point[1]);

        // Тестирование HandkerchiefTransformation
        Transformation handkerchief = new HandkerchiefTransformation();
        handkerchief.apply(point);
        System.out.println("HandkerchiefTransformation: " + point[0] + ", " + point[1]);
    }
}

