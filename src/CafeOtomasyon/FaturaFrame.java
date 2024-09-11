/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CafeOtomasyon;

import JavaKodları.Hesap;
import JavaKodları.Odeme;
import JavaKodları.Veritabani;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author T470
 */
public class FaturaFrame extends javax.swing.JFrame {

    /**
     * Creates new form FaturaFrame
     */
    int yatay, dikey, rowIndex;
    Veritabani veritabani = new Veritabani();
    DefaultTableModel model; //  tablo verilerini saklamak ve yönetmek için 
    Color renk = new Color(248, 152, 49);
    Color grid = new Color(153, 77, 28);
    Color kapali = new Color(204, 204, 204);
    private double toplam = 0.0;
    LocalDate tarih = LocalDate.now(); // Şimdiki tarihi almak için
    DateTimeFormatter tarihBiçimi = DateTimeFormatter.ofPattern("yyyy-M-dd");
    Hesap hesap = new Hesap();

    public FaturaFrame() {
        initComponents();
        KDV.setBackground(kapali);
        KDV.setEditable(false); // düzenlenemez
        AraToplam1.setBackground(kapali);
        AraToplam1.setEditable(false);
        Toplamm.setBackground(kapali);
        Toplamm.setEditable(false);
        ParaUstu.setBackground(kapali);
        ParaUstu.setEditable(false);
        baslat();
    }

    private void baslat() {
        Siparis.setText(String.valueOf(veritabani.SiparisTablosuMaxSatir() - 1));
        SiparisTarih.setText(tarih.format(tarihBiçimi));
        AraToplam1.setText(String.valueOf(veritabani.araToplam()));
        hesap.setAraToplam(Double.parseDouble(AraToplam1.getText()));
        KDV.setText(String.valueOf(hesap.getKdv()));
        Toplamm.setText(String.valueOf(hesap.getToplam()));
        urunTablosu();
    }

    private void urunTablosu() {
        model = (DefaultTableModel) jTable1.getModel(); //Tablonun mevcut modeli
        veritabani.getUrunler(jTable1);   
        model = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(80);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.black);
        jTable1.setBackground(grid);
        jTable1.setSelectionBackground(renk);
        jTable1.getTableHeader().setReorderingAllowed(false);//sütunların yeniden sıralanmasının devre dışı bırakmak için
        jTable1.setModel(model);

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
        Tablo = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        SiparişKodutext = new javax.swing.JTextField();
        Siparis = new javax.swing.JTextField();
        SiparisTarih = new javax.swing.JTextField();
        SiparişTarihitext1 = new javax.swing.JTextField();
        KDV = new javax.swing.JTextField();
        kdvText = new javax.swing.JTextField();
        araToplamText = new javax.swing.JTextField();
        AraToplam1 = new javax.swing.JTextField();
        ToplamText = new javax.swing.JTextField();
        Toplamm = new javax.swing.JTextField();
        MüşteriAdıText = new javax.swing.JTextField();
        MüşteriAdı = new javax.swing.JTextField();
        Odeme = new javax.swing.JTextField();
        odeme3 = new javax.swing.JTextField();
        ParaUstuText = new javax.swing.JTextField();
        ParaUstu = new javax.swing.JTextField();
        cikis = new javax.swing.JLabel();
        ödeme = new javax.swing.JButton();
        arkaPlan = new javax.swing.JLabel();

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

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ürün Kodu", "Sipariş Kodu", "Ürün Adı", "Miktar", "Fiyat", "Toplam"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionBackground(new java.awt.Color(153, 77, 28));
        jTable1.setSelectionForeground(new java.awt.Color(153, 77, 28));
        Tablo.setViewportView(jTable1);

        jPanel1.add(Tablo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 490, 370));

        SiparişKodutext.setEditable(false);
        SiparişKodutext.setBackground(new java.awt.Color(248, 152, 49));
        SiparişKodutext.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        SiparişKodutext.setForeground(new java.awt.Color(0, 0, 0));
        SiparişKodutext.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SiparişKodutext.setText("Sipariş Kodu");
        jPanel1.add(SiparişKodutext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 34));

        Siparis.setBackground(new java.awt.Color(255, 255, 255));
        Siparis.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        Siparis.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Siparis.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(Siparis, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 214, 34));

        SiparisTarih.setBackground(new java.awt.Color(255, 255, 255));
        SiparisTarih.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        SiparisTarih.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SiparisTarih.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(SiparisTarih, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 214, 34));

        SiparişTarihitext1.setEditable(false);
        SiparişTarihitext1.setBackground(new java.awt.Color(248, 152, 49));
        SiparişTarihitext1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        SiparişTarihitext1.setForeground(new java.awt.Color(0, 0, 0));
        SiparişTarihitext1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SiparişTarihitext1.setText("Sipariş Tarihi");
        jPanel1.add(SiparişTarihitext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 130, 34));

        KDV.setEditable(false);
        KDV.setBackground(new java.awt.Color(255, 255, 255));
        KDV.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        KDV.setForeground(new java.awt.Color(0, 0, 0));
        KDV.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        KDV.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(KDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 214, 34));

        kdvText.setEditable(false);
        kdvText.setBackground(new java.awt.Color(248, 152, 49));
        kdvText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        kdvText.setForeground(new java.awt.Color(0, 0, 0));
        kdvText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kdvText.setText("Kdv");
        jPanel1.add(kdvText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 130, 34));

        araToplamText.setEditable(false);
        araToplamText.setBackground(new java.awt.Color(248, 152, 49));
        araToplamText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        araToplamText.setForeground(new java.awt.Color(0, 0, 0));
        araToplamText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        araToplamText.setText("Ara Toplam");
        jPanel1.add(araToplamText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 130, 34));

        AraToplam1.setEditable(false);
        AraToplam1.setBackground(new java.awt.Color(255, 255, 255));
        AraToplam1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        AraToplam1.setForeground(new java.awt.Color(0, 0, 0));
        AraToplam1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AraToplam1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(AraToplam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 214, 34));

        ToplamText.setEditable(false);
        ToplamText.setBackground(new java.awt.Color(248, 152, 49));
        ToplamText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        ToplamText.setForeground(new java.awt.Color(0, 0, 0));
        ToplamText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ToplamText.setText("Toplam");
        jPanel1.add(ToplamText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, 34));

        Toplamm.setEditable(false);
        Toplamm.setBackground(new java.awt.Color(255, 255, 255));
        Toplamm.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        Toplamm.setForeground(new java.awt.Color(0, 0, 0));
        Toplamm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Toplamm.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(Toplamm, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 214, 34));

        MüşteriAdıText.setEditable(false);
        MüşteriAdıText.setBackground(new java.awt.Color(248, 152, 49));
        MüşteriAdıText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        MüşteriAdıText.setForeground(new java.awt.Color(0, 0, 0));
        MüşteriAdıText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MüşteriAdıText.setText("Müşteri Adı");
        jPanel1.add(MüşteriAdıText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 130, 34));

        MüşteriAdı.setBackground(new java.awt.Color(255, 255, 255));
        MüşteriAdı.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        MüşteriAdı.setForeground(new java.awt.Color(0, 0, 0));
        MüşteriAdı.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MüşteriAdı.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(MüşteriAdı, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 214, 34));

        Odeme.setEditable(false);
        Odeme.setBackground(new java.awt.Color(248, 152, 49));
        Odeme.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        Odeme.setForeground(new java.awt.Color(0, 0, 0));
        Odeme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Odeme.setText("Peşin Ödeme");
        jPanel1.add(Odeme, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 130, 34));

        odeme3.setBackground(new java.awt.Color(255, 255, 255));
        odeme3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        odeme3.setForeground(new java.awt.Color(0, 0, 0));
        odeme3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        odeme3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        odeme3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                odeme3KeyReleased(evt);
            }
        });
        jPanel1.add(odeme3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 214, 34));

        ParaUstuText.setEditable(false);
        ParaUstuText.setBackground(new java.awt.Color(248, 152, 49));
        ParaUstuText.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        ParaUstuText.setForeground(new java.awt.Color(0, 0, 0));
        ParaUstuText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ParaUstuText.setText("Para Üstü");
        jPanel1.add(ParaUstuText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 130, 34));

        ParaUstu.setEditable(false);
        ParaUstu.setBackground(new java.awt.Color(255, 255, 255));
        ParaUstu.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        ParaUstu.setForeground(new java.awt.Color(0, 0, 0));
        ParaUstu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ParaUstu.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(107, 74, 51), new java.awt.Color(248, 152, 49)));
        jPanel1.add(ParaUstu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 214, 34));

        cikis.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        cikis.setForeground(new java.awt.Color(255, 255, 255));
        cikis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cikis.setText("X");
        cikis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cikisMouseClicked(evt);
            }
        });
        jPanel1.add(cikis, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 35, 34));

        ödeme.setBackground(new java.awt.Color(153, 77, 28));
        ödeme.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        ödeme.setForeground(new java.awt.Color(0, 0, 0));
        ödeme.setText("ÖDEME");
        ödeme.setBorder(null);
        ödeme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ödemeActionPerformed(evt);
            }
        });
        jPanel1.add(ödeme, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, 490, 40));

        arkaPlan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/fatura.png"))); // NOI18N
        jPanel1.add(arkaPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 630));

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

    private void cikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cikisMouseClicked
        setVisible(false);
    }//GEN-LAST:event_cikisMouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        yatay = evt.getX();
        dikey = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen(); // ekrandaki yeri 
        int y = evt.getYOnScreen();
        this.setLocation(x - yatay, y - dikey); // yeni konum için
    }//GEN-LAST:event_jPanel1MouseDragged

    private void ödemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ödemeActionPerformed
        model = (DefaultTableModel) jTable1.getModel();
        String urunAdi = "";
        String urunKodu = "";
        for (int i = 0; i < model.getRowCount(); i++) {
            urunKodu += model.getValueAt(i, 1).toString() + ", ";
            urunAdi += model.getValueAt(i, 2).toString() + ", ";
        }
        int siparisKodu = veritabani.OdemeTablosuMaxSatir();
        String musteriAdi = MüşteriAdı.getText().trim();
        double vergi = Double.parseDouble(Toplamm.getText().trim());

        Odeme odeme = new Odeme();
        odeme.setSiparisKodu(siparisKodu);
        odeme.setMusteriAdi(musteriAdi);
        odeme.setUrunKodu(urunKodu);
        odeme.setUrunAdi(urunAdi);
        odeme.setToplam(vergi);
        odeme.setTarih(SiparisTarih.getText().trim());
        if (kontrolEt()) {
            if (veritabani.odemeEkle(odeme)) {
                JOptionPane.showMessageDialog(this, "Ödeme başarılı", "Mesaj", 1); 
                veritabani.faturaSil(siparisKodu); 

                int mesaj = JOptionPane.showConfirmDialog(this, "Fiş yazdırmak ister misin ?", "Yazdır", JOptionPane.YES_NO_OPTION, 0);
                 if (mesaj == JOptionPane.YES_OPTION) {
                try {
                        MessageFormat baslik = new MessageFormat("SWEET CUP " + "Müşteri Adı: " + musteriAdi + "  " + "Toplam(₺):" + vergi);
                        MessageFormat icerik = new MessageFormat("Sayfa{0, number,integer}");
                        jTable1.print(JTable.PrintMode.FIT_WIDTH, baslik, icerik);
                        setVisible(false);
                    } catch (PrinterException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
            }else {
            setVisible(false);}
        } else {
            JOptionPane.showMessageDialog(this, "Ödeme başarısız! ", "Uyarı", 0);

        }}
    }//GEN-LAST:event_ödemeActionPerformed

    private void odeme3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_odeme3KeyReleased
        nakit();
    }//GEN-LAST:event_odeme3KeyReleased

    public void nakit() {
        try {
            double pesin = Double.parseDouble(odeme3.getText().trim());
            double toplam = Double.parseDouble(Toplamm.getText().trim());
            double paraUstu = (pesin - toplam);
            ParaUstu.setText(String.valueOf(paraUstu));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nakit girişi yetersizdir.", "Uyarı", 2);
        }
    }

    public boolean kontrolEt() {
        if (MüşteriAdı.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Müşteri adı zorunludur.", "Uyarı", 2);
            return false;
        }
        if (odeme3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ödenecek tutar girilmelidir.", "Uyarı", 2);
            return false;
        }
        double paraUstu = Double.parseDouble(ParaUstu.getText().trim());
        if (paraUstu < 0.0) {
            JOptionPane.showMessageDialog(this, "Nakit girişi yetersizdir.", "Uyarı", 2);
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FaturaFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AraToplam1;
    private javax.swing.JTextField KDV;
    private javax.swing.JTextField MüşteriAdı;
    private javax.swing.JTextField MüşteriAdıText;
    private javax.swing.JTextField Odeme;
    private javax.swing.JTextField ParaUstu;
    private javax.swing.JTextField ParaUstuText;
    private javax.swing.JTextField Siparis;
    private javax.swing.JTextField SiparisTarih;
    private javax.swing.JTextField SiparişKodutext;
    private javax.swing.JTextField SiparişTarihitext1;
    private javax.swing.JScrollPane Tablo;
    private javax.swing.JTextField ToplamText;
    private javax.swing.JTextField Toplamm;
    private javax.swing.JTextField araToplamText;
    private javax.swing.JLabel arkaPlan;
    private javax.swing.JLabel cikis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField kdvText;
    private javax.swing.JTextField odeme3;
    private javax.swing.JButton ödeme;
    // End of variables declaration//GEN-END:variables
}
