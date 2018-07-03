package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "country")
	private String country;

	@Column(name = "city")
	private String city;

	@Column(name = "address")
	private String address;

	public Address() {
	}

	public Address(String country, String city, String address) {
		this.country = country;
		this.city = city;
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", address=" + address + "]";
	}

}