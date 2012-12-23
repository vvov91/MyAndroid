package rarus.vovchenko.restaurants;

public class Restaurant {
	private int id;								// id
	private String name;						// название
	private short rating;						// рейтинг
	private String phone;						// телефон
	private int image;							// фото
	
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
	
	public short getRating() {
		return rating;
	}
	public void setRating(short rating) {
		this.rating = rating;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
}