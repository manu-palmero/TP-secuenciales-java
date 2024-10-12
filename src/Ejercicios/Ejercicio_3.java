package Ejercicios;

import javax.swing.*;

/*
Ejercicio 3: Generador de Rutinas de Ejercicio
Escribe un programa que pida al usuario su nivel de condición física (principiante, intermedio, avanzado)
y luego genere una rutina de ejercicio semanal con diferentes tipos de ejercicios y
duraciones.
*/


public class Ejercicio_3 {
    public static void main(String[] args) {
        ej3();
    }

    public static void ej3() {
        System.out.println("Ejercicio 3");
        String[] condiciones = {
                "Principiante",
                "Intermedio",
                "Avanzado"
        };
        String condicion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el nivel de condición física que tiene:",
                "Condición Física",
                JOptionPane.QUESTION_MESSAGE,
                null,
                condiciones,
                null
        );

    }
}
