package net.mgorski.java8.helpers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto implements Serializable {

	private LocalDate date;
	private String title;
	private BigDecimal price;
	private Double latitude;
	private Double longitude;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "TransactionDto [date=" + date + ", title=" + title + ", price=" + price + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
}
