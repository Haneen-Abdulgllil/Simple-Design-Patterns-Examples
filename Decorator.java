class Decorator {
    // Component Interface
    interface Order {
        String getDescription();
        double getPrice();
    }

    // Concrete Component
   static class BaseOrder implements Order {
        private final String description;
        private final double price;

        public BaseOrder(String description, double price) {
            this.description = description;
            this.price = price;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public double getPrice() {
            return price;
        }
    }

    // Decorator
    static abstract class OrderDecorator implements Order {
        protected Order decoratedOrder;

        public OrderDecorator(Order decoratedOrder) {
            this.decoratedOrder = decoratedOrder;
        }

        @Override
        public String getDescription() {
            return decoratedOrder.getDescription();
        }

        @Override
        public double getPrice() {
            return decoratedOrder.getPrice();
        }
    }

    // Concrete Decorators
    static class PriorityOrder extends OrderDecorator {
        public PriorityOrder(Order decoratedOrder) {
            super(decoratedOrder);
        }

        @Override
        public String getDescription() {
            return decoratedOrder.getDescription() + ", Priority Order";
        }

        @Override
        public double getPrice() {
            return decoratedOrder.getPrice() * 1.2; // Increase price for priority order
        }
    }

    static class GiftWrap extends OrderDecorator {
        public GiftWrap(Order decoratedOrder) {
            super(decoratedOrder);
        }

        @Override
        public String getDescription() {
            return decoratedOrder.getDescription() + ", Gift Wrap";
        }

        @Override
        public double getPrice() {
            return decoratedOrder.getPrice() + 5.0; // Additional cost for gift wrap
        }
    }

    // Client
        public static void main(String[] args) {
            // Create a base order
            Order order = new BaseOrder("Shirt", 20.0);
            System.out.println("Order: " + order.getDescription() + ", Price: $" + order.getPrice());

            // Decorate with priority order
            order = new PriorityOrder(order);
            System.out.println("Order: " + order.getDescription() + ", Price: $" + order.getPrice());

            // Decorate with gift wrap
            order = new GiftWrap(order);
            System.out.println("Order: " + order.getDescription() + ", Price: $" + order.getPrice());
        }
}