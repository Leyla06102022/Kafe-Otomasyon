/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaKodları;
public class Hesap {

    private double kdv;
    private double araToplam;

    public double getKdv() {
        return kdvHesap(araToplam);
    }

    public void setKdv(double kdv) {
        this.kdv = kdv;
    }

    public double getToplam(){
        return araToplam + getKdv();
    }
    public double getAraToplam() {
        return araToplam;
    }

    public void setAraToplam(double araToplam) {
        this.araToplam = araToplam;
    }

    private double kdvHesap(double vergi) {
        if (vergi >= 10.0 && vergi <= 20.0) {
            kdv = 0.5;
        } else if (vergi > 20.0 && vergi <= 40.0) {
            kdv = 1.0;
        } else if (vergi > 40.0 && vergi <= 60.0) {
            kdv = 2.0;
        } else if (vergi > 60.0 && vergi <= 80.0) {
            kdv = 3.0;
        } else if (vergi > 80.0 && vergi <= 100.0) {
            kdv = 4.0;
        } else if (vergi > 100.0 && vergi <= 150.0) {
            kdv = 8.0;
        } else if (vergi > 150.0 && vergi <= 200.0) {
            kdv = 10.0;
        } else if (vergi > 200.0){
            kdv = 15.0;
        }
        return kdv;
    }
    }
