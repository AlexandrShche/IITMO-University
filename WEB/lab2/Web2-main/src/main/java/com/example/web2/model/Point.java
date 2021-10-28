package com.example.web2.model;

public class Point implements Comparable<Point>{
    private final double x;
    private final double y;
    private final double r;
    private boolean result;
    private boolean valid;
    private Clock clock;

    public Point(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.valid = true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public int compareTo(Point o) {
        return o.clock.compareTo(clock);
    }
}
