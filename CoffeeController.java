import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.util.ArrayList;

import javax.swing.JButton;

public class CoffeeController {
	private CoffeeModel model;
	private CoffeeView view;
	
	public CoffeeController(CoffeeModel model, CoffeeView view) {
		 this.model = model;
		 this.view = view;
	}
	
	public void setCoffeeName(String Name) {
		model.setName(Name);
	}
	
	public String getCoffeeName() {
		return model.getName();
	}
	
	public void setSize(String Size) {
		model.setSize(Size);
	}
	
	public String getSize() {
		return model.getSize();
	}
	
	public void setMl_Milk(String ml_Milk) {
		model.setMl_Milk(ml_Milk);
	}
	
	public String getMl_Milk() {
		return model.getMl_Milk();
	}
	
	public void setMl_Espresso(String Ml_Espresso) {
		model.setMl_Espresso(Ml_Espresso);
	}
	
	public String getMl_Espresso() {
		return model.getMl_Espresso();
	}
	public void setExtra(String Extra) {
		model.setExtra(Extra);
	}
	
	public String getExtra() {
		return model.getExtra();
	}
	
	public double getPrice() {
		return model.getPrice();
	}
	
	public void setPrice(double Price) {
		model.setPrice(Price);
	}
	
	
	
	  public void updateView() {
		    view.viewCoffeeMenu(model.getName(),model.getSize(), model.getMl_Milk(), model.getMl_Espresso(), model.getExtra(), model.getPrice());
		  }
	  public void ViewMenu(){
		  view.viewCoffeeMenu(model.getName(),model.getSize(), model.getMl_Milk(), model.getMl_Espresso(), model.getExtra(), model.getPrice());
	  }
	
	  
	  //the server
	  public static void main (String []args) throws IOException{
		  CoffeeModel coffee_Cappucino = new CoffeeModel("Cappucino","Small","220 ml","7 ml","No Extra Products",3.45);
		  System.out.println("....Server started....");
		  
		  try {
			  //deserialize
			  FileInputStream fileIn = new FileInputStream("coffees.ser");
			  ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			  CoffeeListInterface model = (CoffeeListInterface) objectIn.readObject();
			  ArrayList <CoffeeModel> c = model.getList();
			  for (CoffeeModel cm: c) {
				  System.out.println(cm.getName() + cm.getSize() + cm.getMl_Milk()+ cm.getMl_Espresso() + cm.getExtra() + cm.getPrice());			  
			  }
			  objectIn.close();
		  }catch(Exception e) {
			  //serialize if  it doesnt exist already
			  System.out.println("File not available...creating new one");
			  FileOutputStream fileOut = new FileOutputStream("coffees.ser");
			  ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			  
			  CoffeeModel coffeeTest = new CoffeeModel ("test", "test","testy","testtest", "stillTeST", 3);
			  System.out.println("Created test coffee");
			  CoffeeList cloutput = new CoffeeList();
			  cloutput.addToList(coffeeTest);
			  
			  objectOut.writeObject(cloutput);
			  objectOut.close();
			  Naming.rebind("clist", cloutput);
			  
		  }
	  
	  
	  }
	
	
	
	
}
