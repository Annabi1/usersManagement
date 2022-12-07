package com.fithnitek.UserManagement.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 4096, nullable = false, name = "description")
	private String description;
	@Column(name = "created_time")
	private Date createdTime;
	@Column(name = "destination")
	private String destination;
	@Column(name = "source")
	private String source;
	@Column(name = "updated_time")
	private Date updatedTime;
	private boolean enabled;
	private float price;
	private float length;
	private float width;
	private float height;
	private float weight;
	
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL ,orphanRemoval = true)
	private Set<ProductImage> images = new HashSet<>();

	
	
	
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Product(Integer id, String fullDescription, Date createdTime, String destination, String source,
			Date updatedTime, boolean enabled, float price, float length, float width, float height, float weight,
			Set<ProductImage> images) {
		super();
		this.id = id;
		this.description = fullDescription;
		this.createdTime = createdTime;
		this.destination = destination;
		this.source = source;
		this.updatedTime = updatedTime;
		this.enabled = enabled;
		this.price = price;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.images = images;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullDescription() {
		return description;
	}

	public void setFullDescription(String fullDescription) {
		this.description = fullDescription;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Set<ProductImage> getImages() {
		return images;
	}

	public void setImages(Set<ProductImage> images) {
		this.images = images;
	}



	
	
	
	
	
	
}