package com.example.demo.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Hoa_Don")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHD;

    @Column(name = "ngay")
    private LocalDateTime ngay;

    @Column(name = "tong_tien")
    private Float tongTien;

    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDons;

    // Getters và Setters
    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public LocalDateTime getNgay() {
        return ngay;
    }

    public void setNgay(LocalDateTime ngay) {
        this.ngay = ngay;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public List<ChiTietHoaDon> getChiTietHoaDons() {
        return chiTietHoaDons;
    }

    public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
        this.chiTietHoaDons = chiTietHoaDons;
    }
}
