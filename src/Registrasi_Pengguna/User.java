package Registrasi_Pengguna;

public class User {
    private String username;
    private String password;
    private String date;
    private String time;
    private String daftarSebagai;

    public User(String username, String password, String date, String time, String daftarSebagai) {
        this.username = username;
        this.password = password;
        this.date = date;
        this.time = time;
        this.daftarSebagai = daftarSebagai;
    }

    // Getter and Setter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDaftarSebagai() {
        return daftarSebagai;
    }

    public void setDaftarSebagai(String daftarSebagai) {
        this.daftarSebagai = daftarSebagai;
    }
}
