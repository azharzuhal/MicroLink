package Manajemen_Pinjaman;

public class ManajemenPinjaman {
    private String namaPengaju;
    private String jumlahPinjaman;
    private String statusPinjaman;
    private String tanggalPengajuan;

    // Konstruktor
    public ManajemenPinjaman(String namaPengaju, String jumlahPinjaman, String statusPinjaman, String tanggalPengajuan) {
        this.namaPengaju = namaPengaju;
        this.jumlahPinjaman = jumlahPinjaman;
        this.statusPinjaman = statusPinjaman;
        this.tanggalPengajuan = tanggalPengajuan;
    }

    // Getters and Setters
    public String getNamaPengaju() {
        return namaPengaju;
    }

    public void setNamaPengaju(String namaPengaju) {
        this.namaPengaju = namaPengaju;
    }

    public String getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void setJumlahPinjaman(String jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public String getStatusPinjaman() {
        return statusPinjaman;
    }

    public void setStatusPinjaman(String statusPinjaman) {
        this.statusPinjaman = statusPinjaman;
    }

    public String getTanggalPengajuan() {
        return tanggalPengajuan;
    }

    public void setTanggalPengajuan(String tanggalPengajuan) {
        this.tanggalPengajuan = tanggalPengajuan;
    }
}
