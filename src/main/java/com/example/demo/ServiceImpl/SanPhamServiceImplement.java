package com.example.demo.ServiceImpl;

import com.example.demo.Entity.SanPham;
import com.example.demo.Repository.SanPhamRepo;
import com.example.demo.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SanPhamServiceImplement implements SanPhamService {

    @Autowired
    SanPhamRepo repo;
    @Override
    public List<SanPham> findBanh() {
        return repo.findBanh();
    }

    @Override
    public List<SanPham> findTraSua() {
        return repo.findTraSua();
    }
    @Override
    public SanPham findById(int id) {
        return repo.findById(id);
    }
}
