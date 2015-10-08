package de.hhbk.de.cb.other;

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
        anInt += 1;
        String no ="";
        if(anInt < 10) {
            no = "00";
        } else if (anInt < 100) {
            no = "0";
        }
        System.out.println(no+anInt+" : "+s);
    }
}
