package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Hoa_Don")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MaHD;

    @Temporal(TemporalType.TIMESTAMP)
    private Date Ngay;

    private Float TongTien;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDons;

	public Object getChiTietHoaDons() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChiTietHoaDons(ArrayList arrayList) {
		// TODO Auto-generated method stub
		
	}

    }

