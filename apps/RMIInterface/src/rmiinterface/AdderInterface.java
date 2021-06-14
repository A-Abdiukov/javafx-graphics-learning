package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdderInterface extends Remote {

    public double add(double x, double y) throws RemoteException;

    public double subtract(double x, double y) throws RemoteException;

    public double multiply(double x, double y) throws RemoteException;

    public double divide(double x, double y) throws RemoteException;
}
