/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

/**
 *
 * @author ASUS
 */
import java.util.*;

public class QuanLyNhanVien {
    private final ArrayList<NhanVien> ds = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    // Y1: Nhập danh sách nhân viên
    public void nhap() {
        while (true) {
            System.out.print("Chon loai nhan vien (1-Hanh chinh, 2-Tiep thi, 3-Truong phong, 0-Thoat): ");
            int loai = Integer.parseInt(sc.nextLine());
            if (loai == 0) break;

            System.out.print("Ma NV: ");
            String ma = sc.nextLine();
            System.out.print("Ho ten: ");
            String ten = sc.nextLine();
            System.out.print("Luong: ");
            double luong = Double.parseDouble(sc.nextLine());

            switch (loai) {
                case 1 -> ds.add(new NhanVien(ma, ten, luong));
                case 2 -> {
                    System.out.print("Doanh so: ");
                    double doanhso = Double.parseDouble(sc.nextLine());
                    System.out.print("Hue hong: ");
                    double huehong = Double.parseDouble(sc.nextLine());
                    ds.add(new TiepThi(ma, ten, luong, doanhso, huehong));
                }
                case 3 -> {
                    System.out.print("Luong trach nhiem: ");
                    double trachnhiem = Double.parseDouble(sc.nextLine());
                    ds.add(new TruongPhong(ma, ten, luong, trachnhiem));
                }
                default -> System.out.println("Loai khong hop le!");
            }
        }
    }

    // Y2: Xuất danh sách
    public void xuat() {
        for (NhanVien nv : ds) nv.xuatThongTin();
    }

    // Y3: Tìm theo mã
    public void timTheoMa() {
        System.out.print("Nhap ma NV can tim: ");
        String ma = sc.nextLine();
        for (NhanVien nv : ds)
            if (nv.manv.equalsIgnoreCase(ma))
                nv.xuatThongTin();
    }

    // Y4: Xóa theo mã
    public void xoaTheoMa() {
        System.out.print("Nhap ma NV can xoa: ");
        String ma = sc.nextLine();
        ds.removeIf(nv -> nv.manv.equalsIgnoreCase(ma));
    }

    // Y5: Cập nhật thông tin
    public void capNhatTheoMa() {
        System.out.print("Nhap ma NV can cap nhat: ");
        String ma = sc.nextLine();
        for (NhanVien nv : ds) {
            if (nv.manv.equalsIgnoreCase(ma)) {
                System.out.print("Nhap ho ten moi: ");
                nv.hoten = sc.nextLine();
                System.out.print("Nhap luong moi: ");
                nv.luong = Double.parseDouble(sc.nextLine());
                break;
            }
        }
    }

    // Y6: Tìm theo khoảng lương
    public void timTheoLuong() {
        System.out.print("Nhap luong thap nhat: ");
        double min = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap luong cao nhat: ");
        double max = Double.parseDouble(sc.nextLine());
        for (NhanVien nv : ds)
            if (nv.getThuNhap() >= min && nv.getThuNhap() <= max)
                nv.xuatThongTin();
    }

    // Y7: Sắp xếp theo họ tên
    public void sapXepTheoTen() {
        ds.sort(Comparator.comparing(nv -> nv.hoten));
    }

    // Y8: Sắp xếp theo thu nhập
    public void sapXepTheoThuNhap() {
        ds.sort(Comparator.comparingDouble(NhanVien::getThuNhap).reversed());
    }

    // Y9: Xuất 5 NV có thu nhập cao nhất
    public void top5ThuNhap() {
        sapXepTheoThuNhap();
        for (int i = 0; i < Math.min(5, ds.size()); i++)
            ds.get(i).xuatThongTin();
    }
}