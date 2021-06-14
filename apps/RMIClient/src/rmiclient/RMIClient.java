package rmiclient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiinterface.AdderInterface;

public class RMIClient {

    public double Add(double numberOne, double numberTwo) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("Localhost", 5000);
        AdderInterface stub = (AdderInterface) reg.lookup("calc");

        return stub.add(numberOne, numberTwo);
    }

    public double Subtract(double numberOne, double numberTwo) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("Localhost", 5000);
        AdderInterface stub = (AdderInterface) reg.lookup("calc");

        return stub.subtract(numberOne, numberTwo);
    }

    public double Multiply(double numberOne, double numberTwo) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("Localhost", 5000);
        AdderInterface stub = (AdderInterface) reg.lookup("calc");

        return stub.multiply(numberOne, numberTwo);
    }

    public double Divide(double numberOne, double numberTwo) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("Localhost", 5000);
        AdderInterface stub = (AdderInterface) reg.lookup("calc");

        return stub.divide(numberOne, numberTwo);
    }
}
