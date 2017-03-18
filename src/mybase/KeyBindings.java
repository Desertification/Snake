package mybase;

/**
 * Created by thoma on 12-Mar-17.
 */
// todo load from ini file
public final class KeyBindings {
    public static Integer[] up = {119, 57416, 122}; // w, up_arrow_win, z
    public static Integer[] down = {115, 57424}; // s, down_arrow_win
    public static Integer[] left = {97, 57419, 113}; // a, left_arrow_win, q
    public static Integer[] right = {100, 57421}; // d, right_arrow_win
    public static Integer[] esc = {27}; // esc
    public static Integer[] enter = {13}; // enter

    private KeyBindings() {
    }
}
