package sinh_vien;
import java.io.File;//tạo đọc file
import java.io.FileNotFoundException;//ngoại lệ file
import java.io.PrintWriter;//ghi file
import java.util.ArrayList;//tạo arrayList
import java.util.Scanner;

class Nguoi {
    protected String hoTen;
    protected int namSinh;

    public Nguoi(String hoTen, int namSinh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public void nhapTT() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        hoTen = scanner.nextLine();
        System.out.print("Nhập năm sinh: ");
        namSinh = scanner.nextInt();
    }

    public void hienThiTT() {
        System.out.println("Họ và tên: " + hoTen);
        System.out.println("Năm sinh: " + namSinh);
    }
}

class SinhVien extends Nguoi {
    public String lop;
    public double diemTrungBinh;

    public SinhVien(String hoTen, int namSinh, String lop, double diemTrungBinh) {
        super(hoTen, namSinh);
        this.lop = lop;
        this.diemTrungBinh = diemTrungBinh;
    }

    
    public void nhapTT() {
        super.nhapTT();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập lớp: ");
        lop = scanner.nextLine();

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Nhập điểm trung bình: ");
            if (scanner.hasNextDouble()) {
                diemTrungBinh = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Vui lòng nhập một số thực làm điểm trung bình: ");
                scanner.nextLine();
            }
        }
    }


    public void hienThiTT() {
        super.hienThiTT();
        System.out.println("Lớp: " + lop);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
    }
}


