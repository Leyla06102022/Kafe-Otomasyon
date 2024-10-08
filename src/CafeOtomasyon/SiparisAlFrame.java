/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CafeOtomasyon;

import JavaKodları.Siparis;
import JavaKodları.Veritabani;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T470
 */
public class SiparisAlFrame extends javax.swing.JFrame {

    /**
     * Creates new form SiparisAlFrame
     */
    int yatay, dikey, rowIndex;
    Veritabani veritabani = new Veritabani();
    DefaultTableModel model; //  tablo verilerini saklamak ve yönetmek için 
    Color renk = new Color(248, 152, 49);
    Color grid = new Color(153, 77, 28);
    private double fiyat = 0.0, toplam = 0.0;
    private double ucret;

    public SiparisAlFrame() {
        initComponents();
        SiparisKodu.setText(String.valueOf(veritabani.SiparisTablosuMaxSatir()));
        urunTablosu();
    }

    private void urunTablosu() {
        veritabani.getTumUrunler(jTable1);
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(80);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.black);
        jTable1.setBackground(grid);
        jTable1.setSelectionBackground(renk);
        jTable1.setModel(model);
        jTable1.getTableHeader().setReorderingAllowed(false);//sütunların yeniden sıralanmasının devre dışı bırakmak için
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new SiparisAlFrame.ImageRenderer());
    }

    private class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable tablo, Object value, boolean isSelected, boolean hasFocus, int row, int column) {//farklı türlerde verileri göstermek için
            JLabel label = new JLabel();
            byte[] bytes = (byte[]) value;
            ImageIcon resimicon = new ImageIcon(new ImageIcon(bytes).getImage().getScaledInstance(200, 130, Image.SCALE_REPLICATE)); // byte içindeki resmi ImageIcon a dönüştürmek için
            label.setIcon(resimicon); // resim eklemek için
            return label;
        }
    }

    private void temizle() {
        UrunAd1.setText(null);
        Miktari.setText("0");
        jTable1.clearSelection();
        Toplamtext.setText("0.0");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Cikis = new javax.swing.JLabel();
        Tablo = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SiparişKodutext = new javax.swing.JTextField();
        SiparisKodu = new javax.swing.JTextField();
        MiktarText = new javax.swing.JTextField();
        Miktari = new javax.swing.JTextField();
        ÜrünAdıText = new javax.swing.JTextField();
        UrunAd1 = new javax.swing.JTextField();
        FaturaGoruntule = new javax.swing.JButton();
        SiparisEkle = new javax.swing.JButton();
        Toplamtext = new javax.swing.JTextField();
        ArkaPlan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cikis.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Cikis.setForeground(new java.awt.Color(255, 255, 255));
        Cikis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cikis.setText("X");
        Cikis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CikisMouseClicked(evt);
            }
        });
        jPanel1.add(Cikis, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 35, 34));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün Kodu", "Ürün Adı", "Fiyat", "Resim"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(153, 77, 28));
        jTable1.setSelectionForeground(new java.awt.Color(153, 77, 28));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        Tablo.setViewportView(jTable1);

        jPanel1.add(Tablo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 590, 480));

        SiparişKodutext.setEditable(false);
        SiparişKodutext.setBackground(new java.awt.Color(248, 152, 49));
        SiparişKodutext.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        SiparişKodutext.setForeground(new java.awt.Color(0, 0, 0));
        SiparişKodutext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SiparişKodutext.setText("Sipariş Kodu");
        jPanel1.add(SiparişKodutext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 40));

        SiparisKodu.setEditable(false);
        SiparisKodu.setBackground(new java.awt.Color(255, 255, 255));
        SiparisKodu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        SiparisKodu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SiparisKodu.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(SiparisKodu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 214, 40));

        MiktarText.setEditable(false);
        MiktarText.setBackground(new java.awt.Color(248, 152, 49));
        MiktarText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        MiktarText.setForeground(new java.awt.Color(0, 0, 0));
        MiktarText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MiktarText.setText("Miktar");
        jPanel1.add(MiktarText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 40));

        Miktari.setBackground(new java.awt.Color(255, 255, 255));
        Miktari.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        Miktari.setForeground(new java.awt.Color(0, 0, 0));
        Miktari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Miktari.setText("0");
        Miktari.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        Miktari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MiktariActionPerformed(evt);
            }
        });
        jPanel1.add(Miktari, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 214, 40));

        ÜrünAdıText.setEditable(false);
        ÜrünAdıText.setBackground(new java.awt.Color(248, 152, 49));
        ÜrünAdıText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        ÜrünAdıText.setForeground(new java.awt.Color(0, 0, 0));
        ÜrünAdıText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ÜrünAdıText.setText("Ürün Adı");
        jPanel1.add(ÜrünAdıText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 130, 40));

        UrunAd1.setBackground(new java.awt.Color(255, 255, 255));
        UrunAd1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        UrunAd1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        UrunAd1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(UrunAd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 214, 40));

        FaturaGoruntule.setBackground(new java.awt.Color(153, 77, 28));
        FaturaGoruntule.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        FaturaGoruntule.setForeground(new java.awt.Color(0, 0, 0));
        FaturaGoruntule.setText("Fatura Görüntüle");
        FaturaGoruntule.setBorder(null);
        FaturaGoruntule.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FaturaGoruntule.setPreferredSize(new java.awt.Dimension(105, 28));
        FaturaGoruntule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FaturaGoruntuleActionPerformed(evt);
            }
        });
        jPanel1.add(FaturaGoruntule, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 200, 50));

        SiparisEkle.setBackground(new java.awt.Color(153, 77, 28));
        SiparisEkle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        SiparisEkle.setForeground(new java.awt.Color(0, 0, 0));
        SiparisEkle.setText("Sipariş Ekle");
        SiparisEkle.setBorder(null);
        SiparisEkle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SiparisEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiparisEkleActionPerformed(evt);
            }
        });
        jPanel1.add(SiparisEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 190, 50));

        Toplamtext.setEditable(false);
        Toplamtext.setBackground(new java.awt.Color(248, 152, 49));
        Toplamtext.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        Toplamtext.setForeground(new java.awt.Color(0, 0, 0));
        Toplamtext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Toplamtext.setText("TOPLAM : 0.0");
        Toplamtext.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(Toplamtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 190, 30));

        ArkaPlan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ArkaPlan.setForeground(new java.awt.Color(0, 0, 0));
        ArkaPlan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArkaPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/SiparisAl.png"))); // NOI18N
        ArkaPlan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(ArkaPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CikisMouseClicked
        setVisible(false);
    }//GEN-LAST:event_CikisMouseClicked

    private void MiktariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiktariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MiktariActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        yatay = evt.getX();
        dikey = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen(); // ekrandaki yeri 
        int y = evt.getYOnScreen();
        this.setLocation(x - yatay, y - dikey); // yeni konum için
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        model = (DefaultTableModel) jTable1.getModel(); // tablo modeli
        rowIndex = jTable1.getSelectedRow(); // Seçilen satırın indeksi
        UrunAd1.setText(model.getValueAt(rowIndex, 1).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void SiparisEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiparisEkleActionPerformed
        if (UrunAd1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen bir ürün seçiniz!", "Uyarı", 2);
        } else if (Miktari.getText().isEmpty() || Miktari.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Lütfen ürün miktarını giriniz! ", "Uyarı", 2);
        } else {
            try {
                model = (DefaultTableModel) jTable1.getModel();
                int siparisKodu = Integer.parseInt(SiparisKodu.getText().trim());
                int miktar = Integer.parseInt(Miktari.getText().trim());
                int urunKodu = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
                String urunAdi = UrunAd1.getText().trim();

                fiyat = Double.parseDouble(model.getValueAt(rowIndex, 2).toString());

                if (!veritabani.urunVarMi(siparisKodu, urunKodu)) {
                    Siparis siparis = new Siparis();
                    siparis.setUrunKodu(urunKodu);
                    siparis.setSiparisKodu(siparisKodu);
                    siparis.setUrunAdi(urunAdi);
                    siparis.setMiktar(miktar);
                    siparis.setFiyat(fiyat);          
                    siparis.setToplam(fiyat * (double) miktar);
                    toplam += fiyat * (double) miktar;
                    Toplamtext.setText(String.format("Toplam (₺): " + "%.2f", toplam));//ondalık sayının yalnızca iki basamaklı kısmı
                    if (veritabani.siparisEkle(siparis)) {
                        JOptionPane.showMessageDialog(this, " Sipariş eklendi. ", "Mesaj", 1);
                        temizle();}
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "" + e, "Uyarı", 2);
            }

        }

    }//GEN-LAST:event_SiparisEkleActionPerformed

    private void FaturaGoruntuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FaturaGoruntuleActionPerformed
        if(toplam != 0.0) {
            new FaturaFrame().setVisible(true);
            setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Lütfen önce sipariş oluşturunuz. ", "Mesaj", 2);
        }
    }//GEN-LAST:event_FaturaGoruntuleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ArkaPlan;
    private javax.swing.JLabel Cikis;
    private javax.swing.JButton FaturaGoruntule;
    private javax.swing.JTextField MiktarText;
    private javax.swing.JTextField Miktari;
    private javax.swing.JButton SiparisEkle;
    private javax.swing.JTextField SiparisKodu;
    private javax.swing.JTextField SiparişKodutext;
    private javax.swing.JScrollPane Tablo;
    private javax.swing.JTextField Toplamtext;
    private javax.swing.JTextField UrunAd1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ÜrünAdıText;
    // End of variables declaration//GEN-END:variables
}
