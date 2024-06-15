//package com.example.demo.ServiceImpl;
//
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import com.example.demo.Entity.Banh;
//import com.example.demo.Repository.BanhRepo;
//import com.example.demo.Service.BanhService;
//
//@Service
//public class BanhServiceImpl implements BanhService {
//
//    @Autowired
//    private BanhRepo banhRepo;
//
//    @Override
//    public List<Banh> findBanhAll() {
//        return banhRepo.findAll();
//    }
//
//    @Override
//    public Banh findBanhById(int id) {
//        return banhRepo.findById(id);
//    }
//
//}
