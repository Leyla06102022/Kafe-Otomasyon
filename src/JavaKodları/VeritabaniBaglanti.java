/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaKodları;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author T470
 */
public class VeritabaniBaglanti {
    public static final String kullaniciadi = "root"; // Veritabanı kullanıcı adı, sabittir
    public static final String sifre = "123456";
    public static final String url = "jdbc:mysql://localhost:3306/cafeotomasyon";
    public static Connection baglanti = null;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            baglanti = DriverManager.getConnection(url,kullaniciadi,sifre);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,""+ex,"Bağlantı Hatası", JOptionPane.WARNING_MESSAGE);
        } 
      return baglanti; 
    }
    
   
    
}
