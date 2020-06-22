package vn.tcx.demo.springvalidation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.tcx.demo.springvalidation.domain.NhanVien;
import vn.tcx.demo.springvalidation.repository.NhanVienRepository;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> findAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public Optional<NhanVien> findNhanVienById(Long id) {
        return nhanVienRepository.findById(id);
    }

    public NhanVien createNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(NhanVien nhanVien, Long id) {
        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findById(id);

        nhanVien = optionalNhanVien.get();

        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(Long id) {
        nhanVienRepository.deleteById(id);
    }
}
