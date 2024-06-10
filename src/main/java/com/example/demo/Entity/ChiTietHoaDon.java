package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chi_tiet_hoa_don")
public class ChiTietHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "don_gia")
    private Float donGia;

    @ManyToOne
    @JoinColumn(name = "maHD", nullable = false)
    private HoaDon hoaDon;

    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
}
