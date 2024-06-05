package com.example.demo.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entity.TraSua;
import com.example.demo.Service.TraSuaService;

@RestController
public class TraSuaAPI {
	@Autowired
    private  TraSuaService traSuaService;
	
    @PostMapping("/get_trasua")
    public ResponseEntity<?> getTraSua() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<TraSua> listBanh = traSuaService.findTraSuaAll();
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
    
    @PostMapping("/get_trasua_byId")
    public ResponseEntity<Map<String, Object>> getTraSuaById(@RequestParam("id") int idTraSua) {
        Map<String, Object> result = new HashMap<>();
        try {
            TraSua product = traSuaService.findTraSuaById(idTraSua);
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
