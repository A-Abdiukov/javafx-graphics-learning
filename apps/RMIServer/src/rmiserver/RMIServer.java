/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmiinterface.AdderInterface;

/**
 *
 * @author User
 */
public class RMIServer extends UnicastRemoteObject implements AdderInterface {

    RMIServer() throws RemoteException {
        super();
    }

    public double add(double x, double y) {
        return x + y;
    }

    public double subtract(double x, double y) {
        return x - y;
    }

    public double mulitply(double x, double y) {
        return x * y;
    }

    public double divide(double x, double y) {
        return x / y;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            AdderInterface stub = new RMIServer();
            //Naming.rebind("rmi://localhost:5000/sonoo",stub);
            Registry reg = LocateRegistry.createRegistry(5000);
            reg.rebind("calc", stub);
            System.out.println("Server is ready........");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public double multiply(double x, double y) throws RemoteException {
        return x * y;
    }

}
