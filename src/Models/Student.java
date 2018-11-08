/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author christoftobias.weick
 */
public class Student {
    private String name;
    private String vorname;
    private String benutzername;
    private String klasse1;
    private String klasse2 = "";

    public Student(String name, String vorname, String benutzername, String klasse1) {
        this.name = name;
        this.vorname = vorname;
        this.benutzername = benutzername;
        this.klasse1 = klasse1;
    }

    public Student() {}

    public String getBenutzername() {
        return benutzername;
    }

    public String getKlasse1() {
        return klasse1;
    }

    public String getKlasse2() {
        return klasse2;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public void setKlasse1(String klasse1) {
        this.klasse1 = klasse1;
    }

    public void setKlasse2(String klasse2) {
        this.klasse2 = klasse2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String[] toArray(){
        String[] array = new String[5];
        array[0] = benutzername;
        array[1] = name;
        array[2] = vorname;
        array[3] = klasse1;
        array[4] = klasse2;
        return array;
    }
}
