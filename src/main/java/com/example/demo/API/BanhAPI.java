package com.example.demo.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Banh;
import com.example.demo.Service.BanhService;

@RestController
public class BanhAPI {
    @Autowired
    private BanhService banhService;
   
    @PostMapping("/get_banh")
    public ResponseEntity<?> getBanh() {
        //lưu trữ các cặp khóa-giá trị trong bản đồ
        Map<String, Object> result = new HashMap<>();
        try {
            List<Banh> listBanh = banhService.findBanhAll();
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
            Banh product = banhService.findBanhById(idBanh);
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
