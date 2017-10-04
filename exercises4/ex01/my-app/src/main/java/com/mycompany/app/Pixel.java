package com.mycompany.app;

public class Pixel extends Point {
    public String color;

    public Pixel(String color) {
        this.color = color;
    }

    public void print() {
        System.out.println("x=" + x + ", y=" + y + ", color=" + color);
    }
}