import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CoffeeMenuInterface extends Remote {
public String getName() throws RemoteException;
public String getSize() throws RemoteException;
public String getMl_Milk() throws RemoteException;
public String getMl_Espresso() throws RemoteException;
public String geExtra() throws RemoteException;
public String getPrice() throws RemoteException;
}
