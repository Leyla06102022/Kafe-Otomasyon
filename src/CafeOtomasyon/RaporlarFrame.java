/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CafeOtomasyon;

import JavaKodları.AdminVeri;
import JavaKodları.Veritabani;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author T470
 */
public class RaporlarFrame extends javax.swing.JFrame {

    /**
     * Creates new form RaporlarFrame
     */
    int yatay, dikey;
    LocalDate tarih = LocalDate.now(); // Şimdiki tarihi almak için
    DateTimeFormatter tarihBiçimi = DateTimeFormatter.ofPattern("yyyy-M-dd");
    Veritabani veritabani = new Veritabani();
    AdminVeri veri = new AdminVeri();

    String tarih1 = tarih.format(tarihBiçimi);

    public RaporlarFrame() {
        initComponents();
        baslat();
    }

    public void baslat() {
        int toplamUrunler = veritabani.toplamUrunler();
        toplamurunler.setText(String.valueOf(toplamUrunler));
        Miktar.setText(String.valueOf(veritabani.gununKazancı(tarih1)));
        kazancMiktari.setText(String.valueOf(veritabani.toplamKazanc()));
        elemanSayisi.setText(String.valueOf(veri.AdminTablosuMaxSatir() - 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DısPanel = new javax.swing.JPanel();
        cikis = new javax.swing.JLabel();
        baslik = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kazanc = new javax.swing.JLabel();
        Miktar = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        urun = new javax.swing.JLabel();
        toplamurunler = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        toplamKazanc = new javax.swing.JLabel();
        kazancMiktari = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        eleman = new javax.swing.JLabel();
        elemanSayisi = new javax.swing.JLabel();
        arkaPLan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        DısPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                DısPanelMouseDragged(evt);
            }
        });
        DısPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cikis.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        cikis.setForeground(new java.awt.Color(255, 255, 255));
        cikis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cikis.setText("X");
        cikis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cikisMouseClicked(evt);
            }
        });
        DısPanel.add(cikis, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 35, 34));

        baslik.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        baslik.setForeground(new java.awt.Color(255, 255, 255));
        baslik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        baslik.setText("Sweet Cup Raporları");
        DısPanel.add(baslik, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 900, 50));

        jPanel2.setBackground(new java.awt.Color(153, 77, 28));

        kazanc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        kazanc.setForeground(new java.awt.Color(255, 255, 255));
        kazanc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kazanc.setText("Günün Kazancı");

        Miktar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Miktar.setForeground(new java.awt.Color(0, 0, 0));
        Miktar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Miktar.setText("5000 ₺");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kazanc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(Miktar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kazanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(Miktar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DısPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 180, 160, 100));

        jPanel1.setBackground(new java.awt.Color(153, 77, 28));

        urun.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        urun.setForeground(new java.awt.Color(255, 255, 255));
        urun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        urun.setText("Toplam Ürünler");

        toplamurunler.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        toplamurunler.setForeground(new java.awt.Color(0, 0, 0));
        toplamurunler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toplamurunler.setText("50");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(urun, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(toplamurunler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(urun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(toplamurunler, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DısPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 180, 160, 100));

        jPanel3.setBackground(new java.awt.Color(153, 77, 28));

        toplamKazanc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        toplamKazanc.setForeground(new java.awt.Color(255, 255, 255));
        toplamKazanc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toplamKazanc.setText("Toplam Kazanç");

        kazancMiktari.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        kazancMiktari.setForeground(new java.awt.Color(0, 0, 0));
        kazancMiktari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kazancMiktari.setText("10000 ₺");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toplamKazanc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(kazancMiktari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toplamKazanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(kazancMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DısPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 180, 160, 100));

        jPanel4.setBackground(new java.awt.Color(153, 77, 28));

        eleman.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        eleman.setForeground(new java.awt.Color(255, 255, 255));
        eleman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eleman.setText("Eleman Sayısı");

        elemanSayisi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        elemanSayisi.setForeground(new java.awt.Color(0, 0, 0));
        elemanSayisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        elemanSayisi.setText("5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(eleman, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(elemanSayisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eleman)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(elemanSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DısPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 180, 160, 100));

        arkaPLan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arkaPLan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resimler/Raporlar.png"))); // NOI18N
        DısPanel.add(arkaPLan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DısPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DısPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cikisMouseClicked
        setVisible(false);
    }//GEN-LAST:event_cikisMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        yatay = evt.getX();
        dikey = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void DısPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DısPanelMouseDragged
        int x = evt.getXOnScreen(); // ekrandaki yeri 
        int y = evt.getYOnScreen();
        this.setLocation(x - yatay, y - dikey); // yeni konum için
    }//GEN-LAST:event_DısPanelMouseDragged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DısPanel;
    private javax.swing.JLabel Miktar;
    private javax.swing.JLabel arkaPLan;
    private javax.swing.JLabel baslik;
    private javax.swing.JLabel cikis;
    private javax.swing.JLabel eleman;
    private javax.swing.JLabel elemanSayisi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel kazanc;
    private javax.swing.JLabel kazancMiktari;
    private javax.swing.JLabel toplamKazanc;
    private javax.swing.JLabel toplamurunler;
    private javax.swing.JLabel urun;
    // End of variables declaration//GEN-END:variables
}
