package net.mgorski.java8.helpers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ApartmentDto implements Serializable {

	private Long id;

	private String street;
	private String city;

	private Integer beds;
	private Integer baths;

	private LocalDate saleDate;

	private BigDecimal price;

	private Double latitude;
	private Double longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public Integer getBaths() {
		return baths;
	}

	public void setBaths(Integer baths) {
		this.baths = baths;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ApartmentDto{" +
				"id=" + id +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", beds=" + beds +
				", baths=" + baths +
				", saleDate=" + saleDate +
				", price=" + price +
				", latitude=" + latitude +
				", longitude=" + longitude +
				'}';
	}
}
