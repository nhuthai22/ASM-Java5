package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "San_Pham")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "LSPID")
    @JsonIgnore
    private LoaiSanPham loaiSanPham;

    private String TenSP;
    private Double Gia;
    private Integer quantity;
    private String mo_ta;
    private String images;
}
