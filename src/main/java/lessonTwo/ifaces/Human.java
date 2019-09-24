package main.java.lessonTwo.ifaces;

public class Human implements BasicFunctions, SocialFunctions {
    public Human() {
    }

    public void breathe() {
        System.out.println("breathes through nose");
    }

    public void look() {
        System.out.println("looks with eyes");
    }

    public void talk() {
        System.out.println("Hey, lalala");
    }

    public void read() {
        System.out.println("Human reads");
    }
}
