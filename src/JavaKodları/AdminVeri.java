/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaKodları;

import CafeOtomasyon.SifremiUnuttumFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T470
 */
public class AdminVeri {

    Connection baglanti = VeritabaniBaglanti.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public int AdminTablosuMaxSatir() {
        int satir = 0;

        try {
            st = baglanti.createStatement();
            rs = st.executeQuery("select max(id) from admin"); // en büyük id al
            while (rs.next()) {
                satir = rs.getInt(1); // en büyük id
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminVeri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return satir + 1;
    }

    public boolean adminVarMi(String kullaniciadi) {
        try {
            ps = baglanti.prepareStatement("select * from admin where kullaniciadi = ?");
            ps.setString(1, kullaniciadi);
            rs = ps.executeQuery();
            if (rs.next());
            return false;
        } catch (Exception ex) {
            Logger.getLogger(AdminVeri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean ekle(Admin admin) {
        String sql = "insert into admin (id, kullaniciadi, sifre, guvenliksorusu, cevap) values(?,?,?,?,?)";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setInt(1, admin.getId());
            ps.setString(2, admin.getKullaniciadi());
            ps.setString(3, admin.getSifre());
            ps.setString(4, admin.getGuvenlikSorusu());
            ps.setString(5, admin.getCevap());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean giris(String kullaniciadi, String sifre) {
        try {
            ps = baglanti.prepareStatement("select * from admin where kullaniciadi = ? and sifre = ?");
            ps.setString(1, kullaniciadi);
            ps.setString(2, sifre);
            rs = ps.executeQuery(); // sorguyu veritabanına gönderdim
            if (rs.next()) { // bir sonraki satır varsa
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminVeri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getSifre(String kullaniciadi) {
        try {
            ps = baglanti.prepareStatement("select * from admin where kullaniciadi = ? ");//kayıt sorgu
            ps.setString(1, kullaniciadi);
            rs = ps.executeQuery(); // sorguyu veritabanına gönderdim
            if (rs.next()) { // bir sonraki satır varsa
                SifremiUnuttumFrame.GuvenlikS.setText(rs.getString(4));
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminVeri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean getCevap(String kullaniciadi, String yeniCevap) {
        try {
            ps = baglanti.prepareStatement("select * from admin where kullaniciadi = ? ");
            ps.setString(1, kullaniciadi);
            rs = ps.executeQuery(); // sorguyu veritabanına gönderdim
            if (rs.next()) { // bir sonraki satır varsa
                String eskiCevap = rs.getString(5);
                if (yeniCevap.equals(eskiCevap)) {
                    return true;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminVeri.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean setSifre(String kullaniciadi, String sifre) {
        String sql = "update admin set sifre=? where kullaniciadi = ?";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setString(1, sifre);
            ps.setString(2, kullaniciadi);
            return ps.executeUpdate() > 0; // sorgu başarılı oldu mu
        } catch (Exception ex) {
            return false;
        }
    }

}
