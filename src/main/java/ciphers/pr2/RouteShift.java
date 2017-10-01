package ciphers.pr2;

import entities.Cipher;
import javafx.util.Pair;

public class RouteShift extends Cipher {
    int n = 4;
    int m = 5;
    char[][] table = new char[n][m];

    public RouteShift() {

        name = "Route Shift";
        key = n+", "+m;
    }

    private  void add(StringBuffer sb){
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
    public String encrypt(String word) {
        StringBuffer sb = new StringBuffer(word);
        add(sb);
        for (int i = 0; i < table[0].length; i++){
            for (int j = 0; j < table.length; j++){
                sb.append(table[j][i]);
                tableOfChange.add(new Pair<String, String>(String.valueOf(table[i][j]), String.valueOf(table[j][i])));
            }
        }
        return sb.toString();
    }
}
