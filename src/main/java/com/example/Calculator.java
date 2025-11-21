package com.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz remota para la calculadora
 * Debe extender Remote y todos los métodos deben lanzar RemoteException
 */
public interface Calculator extends Remote {
    double add(double a, double b) throws RemoteException;
    double subtract(double a, double b) throws RemoteException;
    double multiply(double a, double b) throws RemoteException;
    double divide(double a, double b) throws RemoteException;
    String getMessage() throws RemoteException;
}