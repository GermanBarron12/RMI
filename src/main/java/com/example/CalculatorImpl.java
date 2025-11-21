package com.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementación de la interfaz Calculator
 * Extiende UnicastRemoteObject para funcionalidad RMI
 */
public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    
    // Constructor debe lanzar RemoteException
    public CalculatorImpl() throws RemoteException {
        super();
        System.out.println("Calculadora remota creada");
    }
    
    @Override
    public double add(double a, double b) throws RemoteException {
        double result = a + b;
        System.out.println("Operación: " + a + " + " + b + " = " + result);
        return result;
    }
    
    @Override
    public double subtract(double a, double b) throws RemoteException {
        double result = a - b;
        System.out.println("Operación: " + a + " - " + b + " = " + result);
        return result;
    }
    
    @Override
    public double multiply(double a, double b) throws RemoteException {
        double result = a * b;
        System.out.println("Operación: " + a + " * " + b + " = " + result);
        return result;
    }
    
    @Override
    public double divide(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("División por cero no permitida");
        }
        double result = a / b;
        System.out.println("Operación: " + a + " / " + b + " = " + result);
        return result;
    }
    
    @Override
    public String getMessage() throws RemoteException {
        return "Conexión exitosa con el servidor RMI";
    }
}