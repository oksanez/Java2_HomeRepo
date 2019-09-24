package main.java.lessonTwo.ifaces;

/**
 * Java. Уровень 2. Урок 2
 *
 * @author Oksana Nezlobina
 * @version 2019-09-24
 */
public class Computer implements SocialFunctions {
    public Computer() {
    }

    public void talk() {
        System.out.println("sound like Siri");
    }

    public void read() {
        System.out.println("insert a disk into me!");
    }
}