package com.example.demo.API;

import com.example.demo.Entity.ChiTietHoaDon;
import com.example.demo.Repository.ChiTietHoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api-ChiTietHoaDon")
public class ChiTietAPI {

    @Autowired
    private ChiTietHoaDonRepo repo;

    @PostMapping("/Post-ChiTiethoaDon")
    public ResponseEntity<?> doPostHD(@RequestBody ChiTietHoaDon chiTietHoaDon) {
        Map<String, Object> rs = new HashMap<>();
        try {
            rs.put("Status", true);
            rs.put("Message", "Successfully");
            rs.put("data", repo.save(chiTietHoaDon));
        } catch (Exception ex) {
            rs.put("Status", false);
            rs.put("Message", "Failed");
            rs.put("data", null);
        }
        return ResponseEntity.ok(rs);
    }
}
