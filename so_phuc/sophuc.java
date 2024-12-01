package so_phuc;

import java.util.Scanner;

class sophuc {
    private double phan_thuc;
    private double phan_ao;

    public sophuc(double phan_thuc, double phan_ao) {
        this.phan_thuc = phan_thuc;
        this.phan_ao = phan_ao;
    }

    public sophuc cong(sophuc sp) {
        double tongThuc = this.phan_thuc + sp.phan_thuc;
        double tongAo = this.phan_ao + sp.phan_ao;
        return new sophuc(tongThuc, tongAo);
    }

    public sophuc nhan(sophuc sp) {
        double tichThuc = this.phan_thuc * sp.phan_thuc - this.phan_ao * sp.phan_ao;
        double tichAo = this.phan_thuc * sp.phan_ao + this.phan_ao * sp.phan_thuc;
        return new sophuc(tichThuc, tichAo);
    }

    public String toString() {
        return phan_thuc + " + " + phan_ao + "i";
    }
    public class Main {
        public static void main(String[] args) {
            Scanner sp = new Scanner(System.in);

            System.out.println("Nhập số phức thứ nhất:");
            double a1 = sp.nextDouble();
            double b1 = sp.nextDouble();
            sophuc sp1 = new sophuc(a1, b1);

            System.out.println("Nhập số phức thứ hai:");
            double a2 = sp.nextDouble();
            double b2 = sp.nextDouble();
            sophuc sp2 = new sophuc(a2, b2);

            sophuc tong = sp1.cong(sp2);
            System.out.println("Sum: " + tong);

            sophuc tich = sp1.nhan(sp2);
            System.out.println("Product: " + tich);
        }
    }
}
