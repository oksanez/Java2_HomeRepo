package main.java.lessonOne;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Animal[] zoo = new Animal[]{new Cat(), new Parrot()};

        for(int i = 0; i < zoo.length; ++i) {
            zoo[i].voice();
            if (zoo[i] instanceof Parrot) {
                ((Parrot)zoo[i]).speak();
            }
        }

    }
}