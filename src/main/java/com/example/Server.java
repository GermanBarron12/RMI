package com.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.InetAddress;

/**
 * Servidor RMI que registra el objeto remoto
 */
public class Server {
    public static void main(String[] args) {
        try {
            // Crear instancia del objeto remoto
            CalculatorImpl calculator = new CalculatorImpl();
            
            // Crear registro RMI en el puerto 1099 (puerto por defecto)
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Registrar el objeto remoto con un nombre
            registry.rebind("CalculatorService", calculator);
            
            // Obtener la IP del servidor
            String serverIP = InetAddress.getLocalHost().getHostAddress();
            
            System.out.println("========================================");
            System.out.println("Servidor RMI iniciado correctamente");
            System.out.println("IP del servidor: " + serverIP);
            System.out.println("Puerto: 1099");
            System.out.println("Servicio: CalculatorService");
            System.out.println("========================================");
            System.out.println("Esperando conexiones de clientes...\n");
            
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}