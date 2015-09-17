package de.hhbk.de.cb;

/**
 * Created by admin on 17.09.15.
 */
public class debug {
    private static debug ourInstance = new debug();
    private static int anInt;

    public static debug getInt() {
        return ourInstance;
    }

    private debug() {
        anInt = 0;
    }
    public void message(String s) {
        System.out.println(anInt +" : "+s);
    }
}
