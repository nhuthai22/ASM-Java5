package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "banh")
public class Banh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "Ten")
    private String ten;
    
    @Column(name = "Gia")
    private double gia;

    @Column(name = "images")
    private String img;
    
//    @Column(name = "quantity")
//    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



//	public int getQuantity() {
//		return quantity;
//	}

//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

	
    
}
