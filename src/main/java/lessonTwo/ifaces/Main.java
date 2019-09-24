package main.java.lessonTwo.ifaces;

public class Main {
    public Main() {
    }

    private static void method1(Main.MouseListener ml) {
        ml.mouseUp();
    }

    public static void main(String[] args) {
        method1(new Main.MouseListener() {
            public void mouseUp() {
                System.out.println("Mouse is up!");
            }
        });
        method1(() -> {
            System.out.println("Mouse is up!");
        });
        Cat cat = new Cat();
        Human h = new Human();
        Computer comp = new Computer();
        cat.breathe();
        cat.look();
        SocialFunctions[] game = new SocialFunctions[]{h, comp};

        for(int i = 0; i < game.length; ++i) {
            game[i].talk();
        }

    }

    private interface MouseListener {
        void mouseUp();
    }
}