package com.example.demo.API;

import com.example.demo.Entity.SanPham;
import com.example.demo.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SanPhamAPI {
    @Autowired
    private SanPhamService repo;

    @PostMapping("/get_trasua")
    public ResponseEntity<?> getTraSua() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<SanPham> listTS = repo.findTraSua();
            result.put("status", true);
            result.put("message", "Call API success");
            result.put("data", listTS);
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Call API Fails");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/get_trasua_byId")
    public ResponseEntity<Map<String, Object>> getTraSuaById(@RequestParam("id") int idTraSua) {
        Map<String, Object> result = new HashMap<>();
        try {
            SanPham product = repo.findById(idTraSua);
            if (product != null) {
                result.put("status", true);
                result.put("message", "Call API success");
                result.put("data", product);
            } else {
                result.put("status", false);
                result.put("message", "Product not found");
                result.put("data", null);
            }
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Call API fails");
            result.put("data", null);
            // Optionally log the exception
            e.printStackTrace(); // Or use a logging framework
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/get_banh")
    public ResponseEntity<?> getBanh() {
        //lưu trữ các cặp khóa-giá trị trong bản đồ
        Map<String, Object> result = new HashMap<>();
        try {
            List<SanPham> listBanh = repo.findBanh();
            result.put("status", true);
            result.put("message", "Call API success");
            result.put("data", listBanh);
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Call API Fails");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/get_banh_byId")
    //  RequestParam lấy dữ liệu từ các yêu cầu GET hoặc POST từ bánh
    public ResponseEntity<Map<String, Object>> getBanhById(@RequestParam("id") int idBanh) {
        Map<String, Object> result = new HashMap<>();
        try {
            SanPham product = repo.findById(idBanh);
            if (product != null) {
                result.put("status", true);
                result.put("message", "Call API success");
                result.put("data", product);
            } else {
                result.put("status", false);
                result.put("message", "Product not found");
                result.put("data", null);
            }
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Call API fails");
            result.put("data", null);
            // Optionally log the exception
            e.printStackTrace(); // Or use a logging framework
        }
        return ResponseEntity.ok(result);
    }
}
