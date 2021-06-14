/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmiinterface.AdderInterface;

/**
 *
 * @author User
 */
public class RMIClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{

    Registry reg=LocateRegistry.getRegistry("Localhost", 5000);
    AdderInterface stub=(AdderInterface)reg.lookup("calc");
    System.out.println(stub.add(34,4));

}catch(Exception e){System.out.println(e);}
}
    }
    

