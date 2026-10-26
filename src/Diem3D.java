public class Diem3D extends Diem2D {
    private double z;

    public Diem3D() {
        super();
        this.z = 0;
    }

    public Diem3D(double x, double y, double z) {
        super(x, y); // Gọi hàm tạo của lớp cha Diem2D
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double tinhKhoangCach(Diem3D p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2) + Math.pow(this.z - p.z, 2));
    }

    @Override
    public double tinhKhoangCachGocToaDo() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    @Override
    public Diem3D timDiemDoiXung() {
        return new Diem3D(-this.x, -this.y, -this.z);
    }

    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy); // Tịnh tiến x, y ở lớp cha
        this.z += dz;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}