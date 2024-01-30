import java.util.Map;

class Adapter {

    private static final Map<String, MillimeterProductDimensions> PRODUCT_DIMENSIONS_IN_MILLIMETERS_STORE = Map.of(
            "product1", new MillimeterProductDimensions(20, 10, 50)
    );

    static abstract class ProductDimensions {
        private final double length;
        private final double height;
        private final double width;

        private ProductDimensions(double length, double height, double width) {
            this.length = length;
            this.height = height;
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }
    }

    static class MillimeterProductDimensions extends ProductDimensions {
        private MillimeterProductDimensions(double length, double height, double width) {
            super(length, height, width);
        }
    }

    static class InchProductDimensions extends ProductDimensions {
        private InchProductDimensions(double length, double height, double width) {
            super(length, height, width);
        }
    }

    static class MillimeterToInchAdapter {
        private final MillimeterProductDimensions millimeterProductDimensions;

        public MillimeterToInchAdapter(MillimeterProductDimensions millimeterProductDimensions) {
            this.millimeterProductDimensions = millimeterProductDimensions;
        }

        public InchProductDimensions convertToInches() {
            // Convert millimeters to inches
            return new InchProductDimensions(
                    millimeterProductDimensions.getLength() / 25.4,

                    millimeterProductDimensions.getWidth() / 25.4,

                    millimeterProductDimensions.getHeight() / 25.4
            ); // 1 inch = 25.4 millimeters
        }
    }

    public static void main(String[] args) {
        MillimeterProductDimensions millimeter = PRODUCT_DIMENSIONS_IN_MILLIMETERS_STORE.get("product1");
        MillimeterToInchAdapter adapter = new MillimeterToInchAdapter(millimeter);
        System.out.println("Length in inches: " + adapter.convertToInches());
    }

}