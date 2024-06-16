package com.example.demo.API;

import com.example.demo.Entity.ChiTietHoaDon;
import com.example.demo.Entity.HoaDon;
import com.example.demo.Repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api-hoaDon")
public class HoaDonAPI {

    @Autowired
    private HoaDonRepo repo;

    @PostMapping("/Post-hoaDon")
    public ResponseEntity<?> doPostHD(@RequestBody HoaDon hoaDon) {
        Map<String, Object> rs = new HashMap<>();
        try {
            // Ensure the chiTietHoaDons list is initialized
            if (hoaDon.getChiTietHoaDons() == null) {
                hoaDon.setChiTietHoaDons(new ArrayList<>());
            }

            // Kiểm tra xem danh sách chi tiết hóa đơn có null không
            if (hoaDon.getChiTietHoaDons() != null) {
                // Lặp qua danh sách chi tiết hóa đơn nếu không null
                for (ChiTietHoaDon chiTiet : hoaDon.getChiTietHoaDons()) {
                    chiTiet.setHoaDon(hoaDon);
                }
                // Lưu hóa đơn
                HoaDon savedHoaDon = repo.save(hoaDon);

                rs.put("Status", true);
                rs.put("Message", "Successfully");
                rs.put("data", savedHoaDon);
            } else {
                rs.put("Status", false);
                rs.put("Message", "Không có chi tiết hóa đơn nào được cung cấp");
                rs.put("data", null);
            }
        } catch (Exception ex) {
            // ... xử lý ngoại lệ khác
        }
        return ResponseEntity.ok(rs);
    }
}