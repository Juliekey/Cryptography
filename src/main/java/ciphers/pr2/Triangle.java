package ciphers.pr2;

import com.sun.jmx.remote.internal.ArrayQueue;

import javax.crypto.Cipher;
import javax.crypto.CipherSpi;
import java.security.Provider;
import java.util.TreeMap;
import java.util.Map;

public class Triangle extends ciphers.Cipher{
    /*   char[][] arr = {  {'h'},
                      {'y', 'd'},
                     {'r','o','g'},
                  {'e','n',' ','p'},
                 {'e','r','o','x','i'},
               {'d','e','_','_','_','_',}};
   */
    char[][] arr;
    String key = "cipher";
    StringBuffer sb;
    ArrayQueue<Character> keyqueue;
    Map<Character , String> columns;
    StringBuffer column;


    public void createTriangle(String word){
        sb = new StringBuffer(word);
        int size = 1;
        int addition = word.length();
        while (addition>size){
            addition = addition - size;
            size++;
        }
        for (int i =0; i < size-addition; i++){
            sb.append('_');
        }
        arr = new char[size][];
        int x = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = new char[i+1];
            for (int j = 0; j <= i; j++){
                arr[i][j] = sb.charAt(x);
                x++;
            }
        }
        sb.delete(0, sb.length());
    }

    public void createQueue(){
        int keysize = arr[arr.length-1].length*2-1;
        keyqueue = new ArrayQueue<>(keysize);
        int count = 0;
        while(count<keysize) {
            for (int i = 0; i < key.length() && count<keysize; i++) {
                keyqueue.add(key.charAt(i));
                count++;
            }
        }
    }
    public void createMap(){
        columns = new TreeMap<>();
        column = new StringBuffer();
        for (int i = arr.length-1; i >= 0; i--){
            for (int k = i, j = 0; k < arr.length; k=k+2, j++){
                column.append(arr[k][j]);
            }
            if(columns.containsKey(keyqueue.get(0))) {
                columns.put(keyqueue.get(0), columns.get(keyqueue.get(0))+column.toString());
            }
            else {
                columns.put(keyqueue.get(0), column.toString());
            }

            keyqueue.remove(0);
            column.delete(0, column.length());
        }
        for (int i = 1, j = 1; i < arr.length; i++, j++){
            for (int k = i, z = j; k < arr.length; k=k+2, z++){
                column.append(arr[k][z]);
            }
            if(columns.containsKey(keyqueue.get(0))) {
                columns.put(keyqueue.get(0), columns.get(keyqueue.get(0))+column.toString());
            }
            else {
                columns.put(keyqueue.get(0), column.toString());
            }

            keyqueue.remove(0);
            column.delete(0, column.length());
        }
    }
    public String encrypt(String word) {
        createTriangle(word);
        createQueue();
        createMap();
        for (Map.Entry<Character , String> entry : columns.entrySet()) {
            sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
