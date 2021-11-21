import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CoffeeListInterface extends Remote {
	public ArrayList <CoffeeModel> getList() throws RemoteException;

}
