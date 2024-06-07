package com.example.demo.API;

import com.example.demo.Entity.HoaDon;
import com.example.demo.Repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RequestMapping("/api-hoaDon")
@RestController
public class HoaDonAPI {
    @Autowired
    private HoaDonRepo repo;
    @GetMapping("/Get-all")
    public ResponseEntity<?> GetAllHD() {
        Map<String, Object> rs = new HashMap();
        try {
            rs.put("Status", true);
            rs.put("Message", "successfully");
            rs.put("data", repo.findAll());
        } catch (Exception ex) {
            rs.put("Status", false);
            rs.put("Message", "fail");
            rs.put("data", null);
        }
        return ResponseEntity.ok(rs);
  }

    @PostMapping("/Post-hoaDon")
    public ResponseEntity<?> doPostHD(@RequestBody HoaDon Hoadon){
        Map<String,Object> rs = new HashMap();
        try{
            rs.put("Status",true);
            rs.put("Message","succesfully");
            rs.put("data",repo.save(Hoadon)) ;
        }catch (Exception ex){
            rs.put("Status",false);
            rs.put("Message","fail");
            rs.put("data",null);
        }
        return ResponseEntity.ok(rs);
    }
}
