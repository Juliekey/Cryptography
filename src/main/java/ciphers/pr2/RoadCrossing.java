package ciphers.pr2;

import com.sun.jmx.remote.internal.ArrayQueue;
import entities.Cipher;


public class RoadCrossing extends Cipher {
    ArrayQueue<Character> top;
    ArrayQueue<Character> middle;
    ArrayQueue<Character> bottom;
    StringBuffer sb;
    int step = 2;
    int size;

    public RoadCrossing() {

        name = "Road Crossing";
    }

    private void create(String word) {
        size = (int) (Math.ceil((double) word.length() / (double) 4));
        top = new ArrayQueue<>(size);
        middle = new ArrayQueue<>(size * 2);
        bottom = new ArrayQueue<>(size);

        sb = new StringBuffer(word);
        for (int i = 0; i < size * 4 - word.length(); i++) {
            sb.append('-');
        }
        for (int i = 0; i < size * 4; i++) {

            if (i % 2 == 0) {
                middle.add(sb.charAt(0));
            } else {
                if ((i + 1) % 4 == 0)
                    bottom.add(sb.charAt(0));
                else
                    top.add(sb.charAt(0));
            }
            sb.deleteCharAt(0);
        }
    }

    public String encrypt(String word) {
        create(word);
        int first_iteration = (int) Math.floor(size / step);
        for (int i = 0; i < first_iteration; i++) {
            for (int j = 0; j < step; j++) {
                sb.append(top.get(0));
                top.remove(0);
            }
            for (int j = 0; j < step * 2; j++) {
                sb.append(middle.get(0));
                middle.remove(0);
            }
            for (int j = 0; j < step; j++) {
                sb.append(bottom.get(0));
                bottom.remove(0);
            }
        }
        int second_iteration = size - first_iteration * step;
        for (int i = 0; i < second_iteration; i++) {
            sb.append(top.get(0));
            top.remove(0);
        }
        for (int i = 0; i < second_iteration * 2; i++) {
            sb.append(middle.get(0));
            middle.remove(0);
        }
        for (int i = 0; i < second_iteration; i++) {
            sb.append(bottom.get(0));
            bottom.remove(0);
        }
        return sb.toString();
    }
}
