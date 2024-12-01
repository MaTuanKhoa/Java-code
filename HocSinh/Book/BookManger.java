package Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book{
	
}
public class BookManger {
    String name;
    String author;
    int year;

    public BookManger() {
    }

    public void nhapDL() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tên sách: ");
        name = input.nextLine();
        System.out.print("Nhập tác giả: ");
        author = input.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        year = input.nextInt();
    }

    public void nhapDL_FromFile(BufferedReader br) throws IOException {
        String st = br.readLine();
        String[] gta = st.split("\t");
        if (gta.length >= 3) {
            name = gta[0];
            author = gta[1];
            year = Integer.parseInt(gta[2]);
        } else {
            System.err.println("Dữ liệu không hợp lệ.");
        }
    }

    public void show() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Thông tin sách:");
        System.out.println("Tên sách: " + name);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + year);
    }

    public static int demBookTrungTen(List<BookManger> danhSach, String tenCanKiemTra) {
        int dem = 0;
        for (BookManger bk : danhSach) {
            if (bk.name.equalsIgnoreCase(tenCanKiemTra)) {
                dem++;
            }
        }
        return dem;
    }

    public static void ui(List<BookManger> danhSach) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\n1. Hiện danh sách ");
            System.out.print("\n2. Sắp xếp theo năm và hiện ");
            System.out.print("\n3. Đếm số lượng sách trùng tên ");
            System.out.print("\n4. Hiện sách theo tác giả ");
            System.out.print("\n0. Thoát ");
            System.out.print("\nMời lựa chọn: ");
            int choose = input.nextInt();

            switch (choose) {
                case 1:
                    if (!danhSach.isEmpty()) {
                        for (BookManger book : danhSach) {
                            book.show();
                        }
                    } else {
                        System.out.println("Danh sách sách trống.");
                    }
                    break;

                case 2:
                    // Sắp xếp theo năm xuất bản
                    danhSach.sort((a, b) -> Integer.compare(b.year, a.year));
                    System.out.println("\n====== Danh sách sách sau khi sắp xếp =====");
                    for (int i = 0; i < danhSach.size(); i++) {
                        System.out.print("~~~~~~~~~~~~~~~~~~~");
                        System.out.print("Sách thứ: " + i);
                        danhSach.get(i).show();
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên sách cần kiểm tra: ");
                    input.nextLine(); // Consume the newline
                    String tenCanKiemTra = input.nextLine();
                    int soLuongTrungTen = demBookTrungTen(danhSach, tenCanKiemTra);
                    System.out.println("Số lượng sách trùng tên: " + soLuongTrungTen);
                    break;

                case 4:
                    System.out.print("Nhập tên tác giả cần kiểm tra: ");
                    input.nextLine(); // Consume the newline
                    String tenTacGia = input.nextLine();
                    boolean found = false;
                    for (BookManger book : danhSach) {
                        if (book.author.equalsIgnoreCase(tenTacGia)) {
                            book.show();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sách nào của tác giả: " + tenTacGia);
                    }
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
        List<BookManger> danhSach = new ArrayList<>();

        String inFile = "C:\\Users\\ASUS\\eclipse-workspace\\hoc_sinh\\src\\Book\\book";
        try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
            int m = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < m; i++) {
                BookManger book = new BookManger();
                book.nhapDL_FromFile(br);
                danhSach.add(book);
            }
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Lỗi định dạng số: " + e.getMessage());
        }

        ui(danhSach);
    }
}
