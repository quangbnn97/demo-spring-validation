package vn.tcx.demo.springvalidation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.tcx.demo.springvalidation.validator.annotation.Email;
import vn.tcx.demo.springvalidation.validator.annotation.Phone;

@Entity
@Table(name = "nhan_vien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class NhanVien{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Không được để trống mã nhân viên")
    @Column(name = "ma_nhan_vien")
    private String maNhanVien;

    @NotBlank(message = "Không được để trống tên nhân viên")
    @Column(name = "ten_nhan_vien")
    private String tenNhanVien;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;

    @Phone
    @NotBlank
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
}
