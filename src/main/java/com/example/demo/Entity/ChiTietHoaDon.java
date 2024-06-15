package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "chi_tiet_hoa_don")
public class ChiTietHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MaHDCT;

    @ManyToOne
    @JoinColumn(name = "MaHD", nullable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SanPham sanPham;

    private Integer SoLuong;
    private Double Gia;





}
