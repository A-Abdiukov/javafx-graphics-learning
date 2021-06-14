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
import rmiinterface.ImplementAdder;



/**
 *
 * @author User
 */
public class RMIServer extends UnicastRemoteObject implements AdderInterface{

RMIServer()throws RemoteException{
super();
}
public int add(int x,int y){return x+y;}
    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        // TODO code application logic here
        try{

        AdderInterface stub = new RMIServer();
    //Naming.rebind("rmi://localhost:5000/sonoo",stub);
        Registry reg=LocateRegistry.createRegistry(5000);
        reg.rebind("calc",stub );
        System.out.println("Server is ready........");

        }
        catch(Exception e){System.out.println(e);}
        }
    }
    