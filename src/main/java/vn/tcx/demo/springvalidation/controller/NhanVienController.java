package vn.tcx.demo.springvalidation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.tcx.demo.springvalidation.domain.NhanVien;
import vn.tcx.demo.springvalidation.exception.NotFoundException;
import vn.tcx.demo.springvalidation.service.NhanVienService;

@RestController
@RequestMapping("/api")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping(value = "/nhan-vien")
    public ResponseEntity<?> findAllNhanVien() {
       List<NhanVien> dsNdhanVien = nhanVienService.findAllNhanVien();
        return new ResponseEntity<>(dsNdhanVien, HttpStatus.OK);
    }

    @GetMapping(value = "/nhan-vien/{id}")
    public ResponseEntity<?> findNhanVienById(@PathVariable Long id) {
        NhanVien nhanVien = nhanVienService.findNhanVienById(id).get();
        if (nhanVien == null) {
            throw new NotFoundException("Not found Nhan Vien Id: " + id);
        }
        return new ResponseEntity<>(nhanVien, HttpStatus.OK);
    }

    @PostMapping(value = "/nhan-vien")
    public ResponseEntity<?> createNhanVien(@Valid @RequestBody NhanVien nhanVien) {
        nhanVien = nhanVienService.createNhanVien(nhanVien);

        return new ResponseEntity<>(nhanVien, HttpStatus.CREATED);
    }

    @PutMapping(value = "/nhan-vien/{id}")
    public ResponseEntity<?> updateNhanVien(@Valid @RequestBody NhanVien nhanVien, @PathVariable Long id) {
        nhanVien = nhanVienService.updateNhanVien(nhanVien, id);

        return new ResponseEntity<>(nhanVien, HttpStatus.OK);
    }

    @DeleteMapping(value = "/nhan-vien/{id}")
    public ResponseEntity<?> deleteNhanVien(@PathVariable Long id) {
        nhanVienService.deleteNhanVien(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
