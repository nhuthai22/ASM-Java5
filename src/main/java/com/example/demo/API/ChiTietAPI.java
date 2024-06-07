package com.example.demo.API;

import com.example.demo.Entity.ChiTietHoaDon;
import com.example.demo.Entity.HoaDon;
import com.example.demo.Repository.ChiTietHoaDonRepo;
import com.example.demo.Repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
@RequestMapping("/api-ChiTietHoaDon")
public class ChiTietAPI {
    @Autowired
    private ChiTietHoaDonRepo repo;
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

    @PostMapping("/Post-ChiTiethoaDon")
    public ResponseEntity<?> doPostHD(@RequestBody ChiTietHoaDon ChiTietHoaDon){
        Map<String,Object> rs = new HashMap();
        try{
            rs.put("Status",true);
            rs.put("Message","succesfully");
            rs.put("data",repo.save(ChiTietHoaDon)) ;
        }catch (Exception ex){
            rs.put("Status",false);
            rs.put("Message","fail");
            rs.put("data",null);
        }
        return ResponseEntity.ok(rs);
    }
}
