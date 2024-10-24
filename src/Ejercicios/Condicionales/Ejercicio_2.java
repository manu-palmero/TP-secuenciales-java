package Ejercicios.Condicionales;

/*
Ejercicio 2: Calculadora de Descuentos
Escribe un programa que pida al usuario el precio de un producto y la categoría del cliente
(estudiante, adulto, jubilado). Aplica un descuento del 10% para estudiantes, 5% para adultos y
15% para jubilados. Imprime el precio final después del descuento.
*/

import javax.swing.*;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Ejercicio_2 {
    public static void main(String[] args) {
        ej2();
    }

    public static void ej2() {
        System.out.println("Ejercicio 2");

        Random rand = new Random();
        double precio, descuentoEstudiantes = 0.1, descuentoAdultos = 0.05, descuentoJubilados = 0.15, descuento = 0, precioFinal;

        String[] tipoDescuento = new String[3];
        tipoDescuento[0] = "Estudiantes";
        tipoDescuento[1] = "Adultos";
        tipoDescuento[2] = "Jubilados";

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JComboBox<String> descuentoLista = new JComboBox<>(tipoDescuento);
        panel.add(descuentoLista);

        String[] si = {
                "Si es gratis, para qué le vas a meter descuento?",
                "nO",
                "No",
                "NO"
        };

        do {
            precio = solicitarPrecio();
            if (precio == 0){
                JOptionPane.showMessageDialog(
                        null,
                        si[rand.nextInt(4)]
                );
            }
        } while (precio <= 0);

        int seleccionDescuento = JOptionPane.showConfirmDialog(
                null,
                descuentoLista,
                "Tipo de descuento",
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (seleccionDescuento == JOptionPane.OK_OPTION) {
            String descuentoSeleccionado = descuentoLista.getSelectedItem().toString();
            switch (descuentoSeleccionado) {
                case "Estudiantes":
                    descuento = descuentoEstudiantes;
                    break;
                case "Adultos":
                    descuento = descuentoAdultos;
                    break;
                case "Jubilados":
                    descuento = descuentoJubilados;
                    break;
            }
            precioFinal = precio * descuento;
            JOptionPane.showMessageDialog(
                    null,
                    "El precio final del producto con " + descuento * 100 + "% de descuento es: $" + precioFinal,
                    "Precio final",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private static double solicitarPrecio() {
        double precio;
        try {
            precio = Double.parseDouble(JOptionPane.showInputDialog(
                    null,
                    "Ingrese el precio del producto",
                    null,
                    JOptionPane.QUESTION_MESSAGE
            ));
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "No ingresó el precio del producto",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return -1;
        }
        return precio;

    }
}
