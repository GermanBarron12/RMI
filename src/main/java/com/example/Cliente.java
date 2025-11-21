package com.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * Cliente RMI que se conecta al servidor y usa el objeto remoto
 */
public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Solicitar IP del servidor
            System.out.print("Ingrese la IP del servidor (o 'localhost'): ");
            String serverIP = scanner.nextLine();
            
            if (serverIP.trim().isEmpty()) {
                serverIP = "localhost";
            }
            
            // Obtener el registro RMI del servidor
            System.out.println("\nConectando al servidor " + serverIP + "...");
            Registry registry = LocateRegistry.getRegistry(serverIP, 1099);
            
            // Buscar el objeto remoto
            Calculator calculator = (Calculator) registry.lookup("CalculatorService");
            
            // Probar la conexión
            String message = calculator.getMessage();
            System.out.println("✓ " + message);
            System.out.println("\n========================================");
            System.out.println("CALCULADORA REMOTA RMI");
            System.out.println("========================================\n");
            
            // Menú interactivo
            boolean running = true;
            while (running) {
                System.out.println("Seleccione una operación:");
                System.out.println("1. Sumar");
                System.out.println("2. Restar");
                System.out.println("3. Multiplicar");
                System.out.println("4. Dividir");
                System.out.println("5. Salir");
                System.out.print("\nOpción: ");
                
                int option = scanner.nextInt();
                
                if (option == 5) {
                    running = false;
                    System.out.println("\n¡Hasta luego!");
                    break;
                }
                
                if (option < 1 || option > 4) {
                    System.out.println("Opción inválida\n");
                    continue;
                }
                
                System.out.print("Ingrese el primer número: ");
                double num1 = scanner.nextDouble();
                
                System.out.print("Ingrese el segundo número: ");
                double num2 = scanner.nextDouble();
                
                double result = 0;
                
                switch (option) {
                    case 1:
                        result = calculator.add(num1, num2);
                        System.out.println("\nResultado: " + num1 + " + " + num2 + " = " + result);
                        break;
                    case 2:
                        result = calculator.subtract(num1, num2);
                        System.out.println("\nResultado: " + num1 + " - " + num2 + " = " + result);
                        break;
                    case 3:
                        result = calculator.multiply(num1, num2);
                        System.out.println("\nResultado: " + num1 + " * " + num2 + " = " + result);
                        break;
                    case 4:
                        result = calculator.divide(num1, num2);
                        System.out.println("\nResultado: " + num1 + " / " + num2 + " = " + result);
                        break;
                }
                
                System.out.println();
            }
            
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}