/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiinterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author User
 */
public class ImplementAdder extends UnicastRemoteObject implements AdderInterface{

ImplementAdder()throws RemoteException{
super();
}
public int add(int x,int y){return x+y;}

}
