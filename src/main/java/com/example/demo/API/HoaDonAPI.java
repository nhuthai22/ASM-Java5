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

            // Cập nhật hoaDon cho mỗi chiTietHoaDon
            for (ChiTietHoaDon chiTiet : hoaDon.getChiTietHoaDons()) {
                chiTiet.setHoaDon(hoaDon);
            }

            // Lưu hoaDon
            HoaDon savedHoaDon = repo.save(hoaDon);

            rs.put("Status", true);
            rs.put("Message", "Successfully");
            rs.put("data", savedHoaDon);
        } catch (Exception ex) {
            ex.printStackTrace(); // In ra lỗi để kiểm tra
            rs.put("Status", false);
            rs.put("Message", "Failed");
            rs.put("data", null);
        }
        return ResponseEntity.ok(rs);
    }
}
