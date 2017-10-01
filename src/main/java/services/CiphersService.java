package services;

import ciphers.pr1.*;
import ciphers.pr2.*;
import entities.Cipher;
import entities.Lab;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CiphersService {
    public static Map<Integer, Lab> getAllLabs() {
        Map<Integer, Lab> allLabs = new HashMap<>();
        Map<Integer, Cipher> ciphers = new HashMap();
        ciphers.put(1, new Ceasar());
        ciphers.put(2, new Combined());
        ciphers.put(3, new Hill());
        ciphers.put(4, new Homophonic());
        ciphers.put(5, new Lozung());
        ciphers.put(6, new PlayFair());
        ciphers.put(7, new PolybiusSquare());
        ciphers.put(8, new Porta());
        ciphers.put(9, new TrisemusSystem());
        ciphers.put(10, new Variant());
        ciphers.put(11, new Vizhiner());
        allLabs.put(1, new Lab("Lab 1", Collections.unmodifiableMap(ciphers)));
        ciphers = new HashMap<>();
        ciphers.put(1, new BlockShift());
        ciphers.put(2, new CardanGrille());
        ciphers.put(3, new DoubleShift());
        ciphers.put(4, new MagicSquare());
        ciphers.put(5, new RouteShift());
        ciphers.put(6, new SimpleShift());
        ciphers.put(7, new Triangle());
        ciphers.put(8, new VerticalShift());
        ciphers.put(9, new RoadCrossing());
        ciphers.put(10, new VerticalShift());
        allLabs.put(2, new Lab("Lab2", Collections.unmodifiableMap(ciphers)));
        return allLabs;
    }
}
