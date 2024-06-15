package com.example.demo.Service;

import com.example.demo.Entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> findBanh();
    List<SanPham> findTraSua();
    SanPham findById(int id);
}
