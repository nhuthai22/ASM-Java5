package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="ChiTietHoaDon")
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHD;

    @Column(name="Ngay")
    private LocalDateTime Ngay;

    @Column(name="TongTien")
    private float TongTien;

    @ManyToOne
    private HoaDon hoaDon;

    @ManyToOne
    private Banh Banh;

    @ManyToOne
    private TraSua traSua;
}