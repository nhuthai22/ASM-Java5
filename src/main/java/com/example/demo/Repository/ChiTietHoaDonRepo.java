package com.example.demo.Repository;

import com.example.demo.Entity.ChiTietHoaDon;
import com.example.demo.Entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietHoaDonRepo extends JpaRepository<ChiTietHoaDon,Integer> {


}