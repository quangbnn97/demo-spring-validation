package vn.tcx.demo.springvalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.tcx.demo.springvalidation.domain.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long>{

}
