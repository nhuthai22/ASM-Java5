package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "HoaDon")
public class HoaDon {

    @Id
    @Column(name = "MaHD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maHD;

    @Column(name = "Ngay")
    private LocalDateTime ngay;

    @Column(name = "TongTien")
    private float tongTien;



    @OneToMany(mappedBy = "hoaDon")
    private List<ChiTietHoaDon> chiTietHoaDons;
}

