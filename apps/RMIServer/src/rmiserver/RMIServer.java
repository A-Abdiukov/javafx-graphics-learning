package rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmiinterface.AdderInterface;

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

    public static void main(String[] args) {
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
