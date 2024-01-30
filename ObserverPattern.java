package com.melouk.personal.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public enum OrderStatus{
        RECEIVED,
        PACKING,
        DELIVERING,
        DELIVERED
    }

    public interface Observer {
        void update(OrderStatus orderStatus);
    }

    public interface Subject {
        void attach(Observer observer);

        void detach(Observer observer);

        void notifyObservers();
    }
    public static class Order implements Subject {//concrete subject
        private final List<Observer> observers = new ArrayList<>();
        private OrderStatus orderStatus;

        public void setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            notifyObservers();
        }

        @Override
        public void attach(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void detach(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(orderStatus);
            }
        }
    }


    public static class Warehouse implements Observer {
        @Override
        public void update(OrderStatus orderStatus) {
            //when it's received it should
            System.out.println("Warehouse: Order status - " + orderStatus);
        }
    }

    public static class Carrier implements Observer {
        @Override
        public void update(OrderStatus orderStatus) {
            System.out.println("Carrier: Order status - " + orderStatus);
        }
    }

    public static class Customer implements Observer {
        @Override
        public void update(OrderStatus orderStatus) {
            // can send updates via email, mobile notification
            System.out.println("Customer: Order status - " + orderStatus);
        }
    }


        public static void main(String[] args) {
            Order order = new Order();
            Observer restaurant = new Warehouse();
            Observer carrier = new Carrier();
            Observer customer = new Customer();

            order.attach(restaurant);
            order.attach(carrier);
            order.attach(customer);

            // Signal the order is received
            order.setOrderStatus(OrderStatus.RECEIVED);
            // Ideally we could send the order id in the notification so that the warehouse can look it up
            // and package it
            order.setOrderStatus(OrderStatus.PACKING);
            order.setOrderStatus(OrderStatus.DELIVERING);
            order.setOrderStatus(OrderStatus.DELIVERED);
        }

}
