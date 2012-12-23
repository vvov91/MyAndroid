package rarus.vovchenko.restaurants;

public class Dish {											// блюдо
	private int id;											// id
	private String name;									// название
	private String price;									// цена
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}