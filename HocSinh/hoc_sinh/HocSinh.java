package hoc_sinh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HocSinh {
    String hoTen;
    String lop;
    double diemToan;
    double diemLy;
    double diemHoa;
    double diemTB;

    public HocSinh() {
    }

    public void nhapDL() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ tên học sinh: ");
        hoTen = input.nextLine();
        System.out.print("Nhập lớp: ");
        lop = input.nextLine();
        diem();
    }

    public void nhapDL_FromFile(BufferedReader br) throws IOException {
        String st = br.readLine();
        String[] gta = st.split("\t");
        if (gta.length >= 5) {
            hoTen = gta[0];
            lop = gta[1];
            diemToan = Double.parseDouble(gta[2]);
            diemLy = Double.parseDouble(gta[3]);
            diemHoa = Double.parseDouble(gta[4]);
            tinhTB();
        } else {
            System.err.println("Dữ liệu không hợp lệ.");
        }
    }

    public void diem() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Nhập điểm toán: ");
            diemToan = input.nextDouble();
            System.out.print("Nhập điểm lý: ");
            diemLy = input.nextDouble();
            System.out.print("Nhập điểm hóa: ");
            diemHoa = input.nextDouble();
        } catch (Exception e) {
            System.out.println("Nhập lại điểm các môn: ");
            diem();
        }
    }

    public double tinhTB() {
        diemTB = (3 * diemToan + 2 * diemLy + diemHoa) / 6;
        return diemTB;
    }

    public void show() {
        System.out.println("Thông tin học sinh:");
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Lớp: " + lop);
        System.out.println("Điểm trung bình: " + diemTB);
    }

    public static int demHocSinhTrungTen(List<HocSinh> danhSach, String tenCanKiemTra) {
        int dem = 0;
        for (HocSinh hs : danhSach) {
            if (hs.hoTen.equalsIgnoreCase(tenCanKiemTra)) {
                dem++;
            }
        }
        return dem;
    }

    public static void ui(List<HocSinh> hs) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Show list ");
            System.out.print("\n2. Sắp xếp và show ");
            System.out.print("\n3. Đếm số lượng học sinh trùng tên ");
            System.out.print("\n0. Thoát ");
            System.out.print("\nMời lựa chọn: ");
            int choose = input.nextInt();

            switch (choose) {
                case 1:
                    if (!hs.isEmpty()) {
                        for (HocSinh hocSinh : hs) {
                            hocSinh.show();
                        }
                    } else {
                        System.out.println("Danh sách học sinh trống.");
                    }
                    break;

                case 2:
                    // Sắp xếp theo điểm trung bình
                    hs.sort((a, b) -> Double.compare(b.diemTB, a.diemTB));
                    System.out.println("\n====== Danh sách học sinh sau khi sắp xếp =====");
                    for (int i = 0; i < hs.size(); i++) {
                        System.out.print("~~~~~~~~~~~~~~~~~~~");
                        System.out.print("Sinh viên thứ: " + i);
                        hs.get(i).show();
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên học sinh cần kiểm tra: ");
                    input.nextLine(); // Consume the newline
                    String tenCanKiemTra = input.nextLine();
                    int soLuongTrungTen = demHocSinhTrungTen(hs, tenCanKiemTra);
                    System.out.println("Số lượng học sinh trùng tên: " + soLuongTrungTen);
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<HocSinh> hs = new ArrayList<>();

        String inFile = "C:\\Users\\ASUS\\eclipse-workspace\\hoc_sinh\\src\\hoc_sinh\\hocsinh";
        try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
            int m = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < m; i++) {
                HocSinh hocSinh = new HocSinh();
                hocSinh.nhapDL_FromFile(br);
                hs.add(hocSinh);
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Lỗi định dạng số: " + e.getMessage());
        }

        ui(hs);
    }
}
