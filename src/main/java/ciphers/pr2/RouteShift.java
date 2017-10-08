package ciphers.pr2;

import entities.Cipher;
import javafx.util.Pair;

public class RouteShift extends Cipher {
    int m = 5;
    char[][] table;

    public RouteShift() {

        name = "Route Shift";
        key = m+"";
    }

    private  void add(StringBuffer sb){
        int n = (int)Math.ceil((double) sb.length()/(double)m);
        table = new char[n][m];
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                if(sb.length()==0)
                    table[i][j] = '_';
                else{
                    table[i][j] = sb.charAt(0);
                    sb.deleteCharAt(0);
                }
            }
        }
    }
    private  String modify(StringBuffer sb){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[0].length; j++){
                sb.append(table[i][j]);
            }
        }
        return sb.toString();
    }
    public String encrypt(String word) {
        StringBuffer sb = new StringBuffer(word);
        add(sb);
        String modified = modify(sb);
        sb.delete(0, sb.length());
        for (int i = 0; i < table[0].length; i++){
            for (int j = 0; j < table.length; j++){
                sb.append(table[j][i]);
            }
        }
        for (int i = 0; i < modified.length(); i++){
                tableOfChange.add(new Pair<String, String>(String.valueOf(modified.charAt(i)), String.valueOf(sb.charAt(i))));
        }
        return sb.toString();
    }
}
