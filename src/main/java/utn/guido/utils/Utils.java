package utn.guido.utils;

public class Utils {


    public static String removeChar(String s, int pos) {
        StringBuilder buf = new StringBuilder( s.length() - 1 );
        buf.append( s.substring(0,pos) ).append( s.substring(pos+1) );
        return buf.toString();
    }

    public static String addChar(String s, int pos, Character letter) {
        StringBuilder buf = new StringBuilder( s.length() - 1 );
        buf.append( s.substring(0,pos) ).append(letter).append( s.substring(pos+1) );
        return buf.toString();
    }
}
