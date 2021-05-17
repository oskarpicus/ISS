package services;

import domain.Bug;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {

    /**
     * Method for notifying when a bug gets added
     * @param bug: Bug, the bug that was added
     * @throws RemoteException, if there is a problem
     */
    void addedBug(Bug bug) throws RemoteException;
}
