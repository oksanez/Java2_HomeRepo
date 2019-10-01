package main.java.lessonThree;

import java.util.Objects;

public class Box implements Comparable {
    private int height;
    private int width;

    public Box(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String toString() {
        return String.format("Box(%d, %d)", this.height, this.width);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Box)) {
            return false;
        } else {
            Box b = (Box)obj;
            return this.width == b.width && this.height == b.height;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.height, this.width});
    }

    private int square() {
        return this.width * this.height;
    }

    public int compareTo(Object o) {
        return this.square() - ((Box)o).square();
    }
}

