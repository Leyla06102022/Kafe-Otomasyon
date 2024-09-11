/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaKodları;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Veritabani {

    Connection baglanti = VeritabaniBaglanti.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public boolean urunEkle(Urun urun) {
        String sql = "insert into urun (ad, fiyat, resim) values (?,?,?)";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setString(1, urun.getAd());
            ps.setDouble(2, urun.getFiyat());
            ps.setBytes(3, urun.getResim());
            return ps.executeUpdate() > 0; // ürün eklenmişse
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void getTumUrunler(JTable Tablo) {
        String sql = "select * from urun order by id desc"; // idye göre azalan en yeniler önce gelsin diye
        try {
            ps = baglanti.prepareStatement(sql);
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel(); // tablo modeli
            Object[] satir;
            while (rs.next()) { // eğer bir sonraki satır varsa, döngüye girer. 
                satir = new Object[4];
                satir[0] = rs.getInt(1); // İlk sütuna karşılık gelen değeri alır ve satır dizisine ekler.
                satir[1] = rs.getString(2);
                satir[2] = rs.getDouble(3);
                satir[3] = rs.getBytes(4);
                model.addRow(satir); // her döngü adımında bir satır tabloya eklemek için
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean guncelle(Urun urun) {
        String sql = "update urun set ad = ?, fiyat = ? where id = ?";
        try {
            ps = baglanti.prepareStatement(sql); //SQL sorgusunu veritabanına göndermek için 
            ps.setString(1, urun.getAd());
            ps.setDouble(2, urun.getFiyat());
            ps.setInt(3, urun.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean sil(Urun urun) {
        String sql = "delete from urun where id = ?";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setInt(1, urun.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    public int SiparisTablosuMaxSatir() {
        int satir = 0;

        try {
            st = baglanti.createStatement();
            rs = st.executeQuery("select max(sipariskodu) from siparis");
            while (rs.next()) {
                satir = rs.getInt(1); // en büyük id
            }
        } catch (Exception ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return satir +1;
    }
    public boolean urunVarMi(int siparisKodu, int urunKodu) {
        String sql = "select * from siparis where siparisKodu = ? and urunKodu = ?";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setInt(1, siparisKodu);
            ps.setInt(2, urunKodu);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean siparisEkle(Siparis siparis) {
        String sql = "insert into siparis ( siparisKodu, urunKodu, urunAdi, miktar, fiyat, toplam) values (?,?,?,?,?,?)";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setInt(1, siparis.getSiparisKodu());
            ps.setInt(2, siparis.getUrunKodu());
            ps.setString(3, siparis.getUrunAdi());
            ps.setInt(4, siparis.getMiktar());
            ps.setDouble(5, siparis.getFiyat());
            ps.setDouble(6, siparis.getToplam());
            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int OdemeTablosuMaxSatir() {
        int satir = 0;

        try {
            st = baglanti.createStatement();
            rs = st.executeQuery("select max(siparisKodu) from odeme");
            while (rs.next()) {
                satir = rs.getInt(1); // en büyük id
            }
        } catch (Exception ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return satir + 1;
    }

    public int FaturaTablosuMaxSatir() {
        int satir = 0;
        try {
            st = baglanti.createStatement();
            rs = st.executeQuery("select max(urunKodu) from fatura");
            while (rs.next()) {
                satir = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return satir + 1;
    }

    public double araToplam() {
        double araToplam = 0.0;
        int siparisKodu = FaturaTablosuMaxSatir();
        try {
            st = baglanti.createStatement();
            rs = st.executeQuery("select sum(toplam) as 'toplam' from fatura where siparisKodu= '" + siparisKodu + "'");// toplam tutarı almak için 

            if (rs.next()) { // bir sonraki satır var mı
                araToplam = rs.getDouble(1); // ilk satırdaki değeri alır
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return araToplam;
    }

    public void getUrunler(JTable Tablo) {
        int siparisKodu = FaturaTablosuMaxSatir();
        String sql = "select * from fatura where siparisKodu = ?";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setInt(1, siparisKodu);
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) Tablo.getModel(); // tablo modeli
            Object[] satir;
            while (rs.next()) { // eğer bir sonraki satır varsa, döngüye girer. 
                satir = new Object[6];
                satir[0] = rs.getInt(2); // İlk sütuna karşılık gelen değeri alır ve satır dizisine ekler.
                satir[1] = rs.getInt(1);
                satir[2] = rs.getString(3);
                satir[3] = rs.getInt(4);
                satir[4] = rs.getDouble(5);
                satir[5] = rs.getDouble(6);
                model.addRow(satir); 

// her döngü adımında bir satır tabloya eklemek için
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean odemeEkle(Odeme odeme) {
        String sql = "insert into odeme (siparisKodu, musteriAdi, urunKodu, urunAdi, toplam, siparisTarihi) values (?,?,?,?,?,?)";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setInt(1, odeme.getSiparisKodu());
            ps.setString(2, odeme.getMusteriAdi());
            ps.setString(3, odeme.getUrunKodu());
            ps.setString(4, odeme.getUrunAdi());
            ps.setDouble(5, odeme.getToplam());
            ps.setString(6, odeme.getTarih());
            return ps.executeUpdate() > 0;
         

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("aaaa");
            return false;
        }
    }

    public boolean faturaSil(int siparisKodu) {
        String sql = "delete from fatura where siparisKodu = ?";
        try {
            ps = baglanti.prepareStatement(sql);
            ps.setInt(1, siparisKodu);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    public void getSiparisGoruntule(JTable Tablo) {
        String sql = "select * from odeme order by siparisKodu ";
        try {
            ps = baglanti.prepareStatement(sql);
            rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) Tablo.getModel(); // tablo modeli
            Object[] satir;
            while (rs.next()) { // eğer bir sonraki satır varsa, döngüye girer. 
                satir = new Object[6];
                satir[0] = rs.getInt(1); // İlk sütuna karşılık gelen değeri alır ve satır dizisine ekler.
                satir[1] = rs.getString(2);
                satir[2] = rs.getString(3);
                satir[3] = rs.getString(4);
                satir[4] = rs.getDouble(5);
                satir[5] = rs.getString(6);
                model.addRow(satir); // her döngü adımında bir satır tabloya eklemek için
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int toplamUrunler() {
        int toplam = 0;

        try {
            st = baglanti.createStatement();
            rs = st.executeQuery("select count(*) as 'toplam' from urun");
            if (rs.next()) {
                toplam = rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toplam;
    }

    public double gununKazancı(String tarih) {
        double toplam = 0.0;

        try {      
            st = baglanti.createStatement();
            rs = st.executeQuery("select sum(toplam) as 'toplam' from odeme where siparisTarihi ='" + tarih + "'");
            if (rs.next()) {
                toplam = rs.getDouble(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toplam;
    }

    public double toplamKazanc() {
        double toplam = 0.0;

        try {
            st = baglanti.createStatement();
            rs = st.executeQuery("select sum(toplam) as 'toplam' from odeme ");
            if (rs.next()) {
                toplam = rs.getDouble(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toplam;
    }

}
