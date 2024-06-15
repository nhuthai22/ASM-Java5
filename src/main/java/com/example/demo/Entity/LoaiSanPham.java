package com.example.demo.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Loai_San_Pham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer LSPID;

    private String TenLoaiSanPham;

    @JsonIgnore
    @OneToMany(mappedBy = "loaiSanPham")
    private List<SanPham> sanPhams;

}
