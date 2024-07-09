package Daftar_Penawaran_Pinjaman;

public class PenawaranPinjaman {
    private String nama;
    private String usaha;
    private String tanggalInvestasi;
    private String jumlahInvestasi;
    private String bunga;
    private String bulan;
    private String pengembalianDiterima;
    private String pembayaranTerakhir;

    public PenawaranPinjaman(String nama, String usaha, String tanggalInvestasi, String jumlahInvestasi, String bunga, String bulan, String pengembalianDiterima, String pembayaranTerakhir) {
        this.nama = nama;
        this.usaha = usaha;
        this.tanggalInvestasi = tanggalInvestasi;
        this.jumlahInvestasi = jumlahInvestasi;
        this.bunga = bunga;
        this.bulan = bulan;
        this.pengembalianDiterima = pengembalianDiterima;
        this.pembayaranTerakhir = pembayaranTerakhir;
    }

    public PenawaranPinjaman() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsaha() {
        return usaha;
    }

    public void setUsaha(String usaha) {
        this.usaha = usaha;
    }

    public String getTanggalInvestasi() {
        return tanggalInvestasi;
    }

    public void setTanggalInvestasi(String tanggalInvestasi) {
        this.tanggalInvestasi = tanggalInvestasi;
    }

    public String getJumlahInvestasi() {
        return jumlahInvestasi;
    }

    public void setJumlahInvestasi(String jumlahInvestasi) {
        this.jumlahInvestasi = jumlahInvestasi;
    }

    public String getBunga() {
        return bunga;
    }

    public void setBunga(String bunga) {
        this.bunga = bunga;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public String getPengembalianDiterima() {
        return pengembalianDiterima;
    }

    public void setPengembalianDiterima(String pengembalianDiterima) {
        this.pengembalianDiterima = pengembalianDiterima;
    }

    public String getPembayaranTerakhir() {
        return pembayaranTerakhir;
    }

    public void setPembayaranTerakhir(String pembayaranTerakhir) {
        this.pembayaranTerakhir = pembayaranTerakhir;
    }
}
