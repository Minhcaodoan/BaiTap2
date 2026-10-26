public class Main {
    public static void main(String[] args) {
        Diem2D[] Diem = new Diem2D[4];
        Diem[0] = new Diem2D(3, 4);
        Diem[1] = new Diem2D(1, 2);
        Diem[2] = new Diem3D(1, 2, 2);
        Diem[3] = new Diem3D(2, 3, 6);

        int n = 4;

        System.out.println("=== DANH SÁCH CÁC ĐIỂM BAN ĐẦU ===");
        for (int i = 0; i < n; i++) {
            //kiểm tra xem có phải điểm 3D hay không
            String loaiDiem = (Diem[i] instanceof Diem3D) ? " (Là điểm 3D)" : " (Là điểm 2D)";
            System.out.println(Diem[i] + loaiDiem);
        }

        //Tính tổng khoảng cách các điểm 2D và tổng khoảng cách các điểm 3D tới gốc tọa độ
        double tongKhoangCach2D = 0;
        double tongKhoangCach3D = 0;

        for (int i = 0; i < n; i++) {
            if (Diem[i] instanceof Diem3D) {
                tongKhoangCach3D += Diem[i].tinhKhoangCachGocToaDo();
            } else {
                tongKhoangCach2D += Diem[i].tinhKhoangCachGocToaDo();
            }
        }

        System.out.println("\n----------------------------------------");
        System.out.println("Tổng khoảng cách các điểm 2D đến gốc tọa độ: " + tongKhoangCach2D);
        System.out.println("Tổng khoảng cách các điểm 3D đến gốc tọa độ: " + tongKhoangCach3D);

        // 2. Đưa các điểm đối xứng vào danh sách[cite: 2]
        // Vì mảng tĩnh có sức chứa 10, ta có thể nhét các điểm đối xứng vào nửa sau của mảng
        int soLuongBanDau = n; // Lưu lại số lượng cũ
        for (int i = 0; i < soLuongBanDau; i++) {
            // Gọi hàm timDiemDoiXung() (đã được đa hình hóa tự động chạy bản của 2D hoặc 3D)
            Diem[n] = Diem[i].timDiemDoiXung();
            n++; // Tăng số lượng thực tế lên
        }

        // 3. Hiển thị toàn bộ danh sách (bao gồm cả điểm gốc và điểm đối xứng)[cite: 2]
        System.out.println("\n=== DANH SÁCH SAU KHI THÊM CÁC ĐIỂM ĐỐI XỨNG ===");
        for (int i = 0; i < n; i++) {
            String loaiDiem = (Diem[i] instanceof Diem3D) ? " (3D đối xứng)" : " (2D đối xứng)";
            if (i < soLuongBanDau) {
                loaiDiem = (Diem[i] instanceof Diem3D) ? " (3D gốc)" : " (2D gốc)";
            }
            System.out.println("Phần tử " + (i + 1) + ": " + Diem[i] + loaiDiem);
        }
    }
}