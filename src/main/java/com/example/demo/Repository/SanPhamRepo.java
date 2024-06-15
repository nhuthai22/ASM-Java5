package com.example.demo.Repository;

import com.example.demo.Entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {


    @Query(value = "SELECT sp.* FROM San_Pham sp INNER JOIN Loai_San_Pham LSP ON sp.LSPID = LSP.LSPID WHERE LSP.ten_loai_san_pham = N'Bánh'", nativeQuery = true)
    List<SanPham> findBanh();

    @Query(value = "SELECT sp.* FROM San_Pham sp INNER JOIN Loai_San_Pham LSP ON sp.LSPID = LSP.LSPID WHERE LSP.ten_loai_san_pham = N'Trà'", nativeQuery = true)
    List<SanPham> findTraSua();
    SanPham findById(int id);
}
