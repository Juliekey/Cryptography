package ciphers;

public class RouteShift extends Cipher{
    char[][] table = new char[4][5];

    private  void add(StringBuffer sb){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                if(sb.length()==0)
                    table[i][j] = ' ';
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
            }
        }
        return sb.toString();
    }
}
