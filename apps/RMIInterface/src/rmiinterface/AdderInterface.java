/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author User
 */
public interface AdderInterface extends Remote {

    public double add(double x, double y) throws RemoteException;

    public double subtract(double x, double y) throws RemoteException;

    public double multiply(double x, double y) throws RemoteException;

    public double divide(double x, double y) throws RemoteException;
}
