import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CoffeeList extends UnicastRemoteObject implements CoffeeListInterface {
	private ArrayList<CoffeeModel> coffeeList;

	public CoffeeList() throws RemoteException {
		coffeeList = new ArrayList<CoffeeModel>();
	}
	
	public ArrayList<CoffeeModel> getList(){
		return coffeeList;
	}

		public void addToList(CoffeeModel c ) {
			coffeeList.add(c);
		}
}
