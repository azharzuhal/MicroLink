package Evaluasi_Risiko_Kredit;

import javafx.beans.property.SimpleStringProperty;

public class FormulirData {
    private final SimpleStringProperty namaPengajuan;
    private final SimpleStringProperty pendapatanBulanan;
    private final SimpleStringProperty pengeluaranBulanan;
    private final SimpleStringProperty jumlahPinjaman;
    private final SimpleStringProperty jangkaWaktuPinjaman;

    public FormulirData(String namaPengajuan, String pendapatanBulanan, String pengeluaranBulanan, String jumlahPinjaman, String jangkaWaktuPinjaman) {
        this.namaPengajuan = new SimpleStringProperty(namaPengajuan);
        this.pendapatanBulanan = new SimpleStringProperty(pendapatanBulanan);
        this.pengeluaranBulanan = new SimpleStringProperty(pengeluaranBulanan);
        this.jumlahPinjaman = new SimpleStringProperty(jumlahPinjaman);
        this.jangkaWaktuPinjaman = new SimpleStringProperty(jangkaWaktuPinjaman);
    }

    public String getNamaPengajuan() {
        return namaPengajuan.get();
    }

    public void setNamaPengajuan(String namaPengajuan) {
        this.namaPengajuan.set(namaPengajuan);
    }

    public String getPendapatanBulanan() {
        return pendapatanBulanan.get();
    }

    public void setPendapatanBulanan(String pendapatanBulanan) {
        this.pendapatanBulanan.set(pendapatanBulanan);
    }

    public String getPengeluaranBulanan() {
        return pengeluaranBulanan.get();
    }

    public void setPengeluaranBulanan(String pengeluaranBulanan) {
        this.pengeluaranBulanan.set(pengeluaranBulanan);
    }

    public String getJumlahPinjaman() {
        return jumlahPinjaman.get();
    }

    public void setJumlahPinjaman(String jumlahPinjaman) {
        this.jumlahPinjaman.set(jumlahPinjaman);
    }

    public String getJangkaWaktuPinjaman() {
        return jangkaWaktuPinjaman.get();
    }

    public void setJangkaWaktuPinjaman(String jangkaWaktuPinjaman) {
        this.jangkaWaktuPinjaman.set(jangkaWaktuPinjaman);
    }
}
