import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.*;

public class CoffeeView extends JFrame implements ActionListener{
	JFrame window = new JFrame("CoffeeMenu");
	JPanel infoPanel = new JPanel();
	JTextArea coffees = new JTextArea();
	JButton add_new_coffee = new JButton("Add a New Coffee to Menu");
	JButton delete_coffee = new JButton("Delete a Coffee from Menu");

	public CoffeeView(CoffeeListInterface c) {
		getContentPane().setLayout(new GridLayout());
		getContentPane().add(add_new_coffee);
		getContentPane().add(coffees);
		getContentPane().add(infoPanel);
		getContentPane().add(delete_coffee);
		pack();
		setSize(450,450);
		setVisible(true);
		
		try {
			ArrayList<CoffeeModel> coffeeName = c.getList();
			System.out.println(coffeeName);
			
			ArrayList<CoffeeModel> a = c.getList();
			String coffees = "";
			
			for(CoffeeModel cl: a ) {
				coffees += cl.getName();
				System.out.println(coffees);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void viewCoffeeMenu(String Name, String Size, String Ml_Milk, String Ml_Espresso, String Extra, double Price) {
		System.out.println("Name of Coffee: " +Name);
		System.out.println("Size of Coffee: " +Size);
		System.out.println("The Amount of Milk in Coffee: " +Ml_Milk);
		System.out.println("The Amount of Espresso in Coffee: " +Ml_Espresso);
		System.out.println("Extra Products in Coffee: " +Extra);
		System.out.println("The Price of Coffee: " +Price);
	}
	
	public static void main (String[] args) throws MalformedURLException, RemoteException,NotBoundException{
		String url ="rmi:///";
		System.out.println("....Client has started....");
		CoffeeListInterface coffee2 = (CoffeeListInterface) Naming.lookup("clist");
		new CoffeeView(coffee2);
		
	}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}



