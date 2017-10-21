package application.services;

import ciphers.pr1.*;
import ciphers.pr2.*;
import ciphers.pr3.GammaModule2;
import ciphers.pr3.GammaModuleN;
import ciphers.pr4.ADFGX;
import ciphers.pr5.RSA;
import ciphers.pr5.Elgamal;
import ciphers.pr5.Knapsack;
import entities.Cipher;
import entities.Lab;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CiphersService {


    public Map<Integer, Lab> getAllLabs() {
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
        ciphers.put(12, new BlockShift());
        ciphers.put(13, new CardanGrille());
        ciphers.put(14, new DoubleShift());
        ciphers.put(15, new MagicSquare());
        ciphers.put(16, new RouteShift());
        ciphers.put(17, new SimpleShift());
        ciphers.put(18, new Triangle());
        ciphers.put(19, new VerticalShift());
        ciphers.put(20, new RoadCrossing());
        ciphers.put(21, new VerticalShift());
        allLabs.put(2, new Lab("Lab2", Collections.unmodifiableMap(ciphers)));
        ciphers = new HashMap<>();
        ciphers.put(22, new GammaModule2());
        ciphers.put(23, new GammaModuleN());
        allLabs.put(3, new Lab("Lab3", Collections.unmodifiableMap(ciphers)));
        ciphers = new HashMap<>();
        ciphers.put(24, new ADFGX());
        allLabs.put(4, new Lab("Lab4", Collections.unmodifiableMap(ciphers)));
        ciphers = new HashMap<>();
        ciphers.put(25, new RSA());
        ciphers.put(26, new Knapsack());
        ciphers.put(27, new Elgamal());
        allLabs.put(5, new Lab("Lab5", Collections.unmodifiableMap(ciphers)));
        return allLabs;
    }

    public Map<Integer, Cipher> getAllCiphers() {
        Map<Integer, Cipher> allCiphers = new HashMap<>();
        for (Map.Entry<Integer, Lab> entry : getAllLabs().entrySet()) {
            allCiphers.putAll(entry.getValue().getCiphers());
        }
        return allCiphers;
    }
}
