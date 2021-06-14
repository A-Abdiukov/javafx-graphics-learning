package rmiclient;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiinterface.AdderInterface;

public class RMIClient {

    static AdderInterface stub;

    public static void main(String[] args) {

        try {
            Registry reg = LocateRegistry.getRegistry("Localhost", 5000);
            stub = (AdderInterface) reg.lookup("calc");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int Add(int numberOne, int numberTwo) throws RemoteException {
        return stub.add(numberOne, numberTwo);
    }

    public static int Subtract(int numberOne, int numberTwo) throws RemoteException {
        return stub.subtract(numberOne, numberTwo);
    }

    public static int Multiply(int numberOne, int numberTwo) throws RemoteException {
        return stub.multiply(numberOne, numberTwo);
    }

    public static int Divide(int numberOne, int numberTwo) throws RemoteException {
        return stub.divide(numberOne, numberTwo);
    }
}
