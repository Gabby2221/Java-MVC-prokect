import java.io.Serializable;

public class CoffeeModel implements Serializable {
	private String Name;
	private String Size;
	private String Ml_Milk;
	private String Ml_Espresso;
	private String Extra;
	private double Price;

	public CoffeeModel(String Name, String Size, String Ml_Milk, String Ml_Espresso, String Extra, double Price) {
		this.Name = Name;
		this.Size = Size;
		this.Ml_Milk = Ml_Milk;
		this.Ml_Espresso = Ml_Espresso;
		this.Extra = Extra;
		this.Price = Price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getMl_Milk() {
		return Ml_Milk;
	}

	public void setMl_Milk(String ml_Milk) {
		Ml_Milk = ml_Milk;
	}

	public String getMl_Espresso() {
		return Ml_Espresso;
	}

	public void setMl_Espresso(String ml_Espresso) {
		Ml_Espresso = ml_Espresso;
	}

	public String getExtra() {
		return Extra;
	}

	public void setExtra(String extra) {
		Extra = extra;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	
}
