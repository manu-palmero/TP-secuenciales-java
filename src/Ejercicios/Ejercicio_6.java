package Ejercicios;

/*
Ejercicio 6: Generador de Planes de Estudio
Escribe un programa que pida al usuario cuántas horas al día puede estudiar y luego genere un
plan de estudio semanal distribuyendo esas horas en diferentes materias.
*/

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.*;

public class Ejercicio_6 {
    public static void main(String[] args) {
        ej6();
    }

    public static void ej6() {
        Random rand = new Random();
        String[] materias = {
                "Matemática",
                "Lengua",
                "Sistemas Operativos",
                "Filosofía",
                "Historia",
        };
        String[] dias = {
                "Lunes",
                "Martes",
                "Miércoles",
                "Jueves",
                "Viernes",
                "Sábado",
                "Domingo",
        };
        Map<String, String[][]> plan = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Generador de plan de estudios");
        System.out.print("Ingrese la cantidad de horas que puede estudar a la semana: ");
        double horas = sc.nextDouble();

        for (String dia : dias) {
            System.out.println("\n" + dia);
            double h = horas / materias.length / 5.6;
            if (dia.equals("Domingo")) {
                System.out.println("Descanso");
                continue;
            }
            if (dia.equals("Sábado")) {
                int[] l = {0, 0, 0};
                int a, b, c;
                do {
                    for (int i = 0; i < 3; i++) {
                        l[i] = rand.nextInt(materias.length);
                    }
                } while (l[0] == l[1] || l[1] == l[2] || l[2] == l[0]);

                for (int j : l) {
                    System.out.println(materias[j] + ": " + decimal_a_hora(h));
                }
                continue;
            }
            for (String materia : materias) {
                System.out.println(materia + ": " + decimal_a_hora(h));
            }
        }
    }

    public static String decimal_a_hora(double horas) {
        DecimalFormat df = new DecimalFormat("#");

        int h = (int) horas;
        double md = Math.round((horas - h) * 100.0) / 100.0;
        int m = (int) (md * 60);

        return h + " horas y " + m + " minutos.";
    }
}
