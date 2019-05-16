package parque;

import atracciones.*;
import entradas.Entrada;
import personas.Persona;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class parque {

    public static void main(String[] args) {
        System.out.println("Initializing...");

        System.out.println("Creating dummy people...");
        ArrayList<Persona> people = new ArrayList<Persona>();
        for (int i = 0; i < 10; i++) {
            int age = getRandomNumberInRange(1, 85);
            float height = 1f + ((float) getRandomNumberInRange(1, 99) / 100);
            Persona p = new Persona("Persona " + i, age, height);
            people.add(p);
        }

        AtraccionA atrA = new AtraccionA();
        AtraccionB atrB = new AtraccionB();
        AtraccionC atrC = new AtraccionC();
        AtraccionD atrD = new AtraccionD();
        AtraccionE atrE = new AtraccionE();


        for (Persona p : people) {
            System.out.println("\n" + p.toString() + "\n");
            System.out.println(p.getNombre() + " en atracción A -> " + atrA.personaPermitida(p));
            System.out.println(p.getNombre() + " en atracción B -> " + atrB.personaPermitida(p));
            System.out.println(p.getNombre() + " en atracción C -> " + atrC.personaPermitida(p));
            System.out.println(p.getNombre() + " en atracción D -> " + atrD.personaPermitida(p));
            System.out.println(p.getNombre() + " en atracción E -> " + atrE.personaPermitida(p));
        }
        System.out.println();
        System.out.println();

        Date today = new Date(119, 2, 1);
        System.out.println(today.toString());

        Entrada e = new Entrada(today, false) {
            @Override
            public boolean ventaValida(Persona p) {
                return false;
            }

            @Override
            public float calcPrecio() {
                return 0;
            }
        };

        System.out.println(e.getTemporada());
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
