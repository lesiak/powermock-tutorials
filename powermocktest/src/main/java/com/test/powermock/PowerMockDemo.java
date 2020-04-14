package com.test.powermock;

import java.awt.*;

public class PowerMockDemo {

    public Point callPrivateMethod() {
        System.out.println("in public method");
        return C(new Point(1, 1));
    }

    private Point C(Point point) {
        System.out.println("in private method");
        return new Point(point.x + 1, point.y + 1);
    }
}
