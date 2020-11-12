package api;

public class Hotel {
	private String city;
	private String description;
	private String Name;
	private int rating;

	public Hotel(String city, String description, String name, int rating) {
		super();
		this.city = city;
		this.description = description;
		Name = name;
		this.rating = rating;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
