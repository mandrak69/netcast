package com.example.dto;

public class ClanovaDTO {
String ime;
int kolicina;
public ClanovaDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public int getKolicina() {
	return kolicina;
}
public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}
@Override
public String toString() {
	return "ClanovaDTO [ime=" + ime + ", kolicina=" + kolicina + "]";
}

}
