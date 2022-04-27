package models;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
    private String firstName,secondName,lastName1,lastName2,phone,country,city,email,userName,password, fVacaciones;

    public Persona(String firstName, String secondName, String lastName1, String lastName2, String phone, String fVacaciones) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.phone = phone;
        this.fVacaciones = fVacaciones;
    }

    public static ArrayList<String> sLista(String dire) throws Exception{
        String linea;
        ArrayList<String> lista = new ArrayList<>();
        File doc = new File(dire);
        Scanner scan = new Scanner(doc);
        while (scan.hasNextLine()) {
            linea = scan.nextLine();
            lista.add(linea);
        }
        return lista;
    }

    public static  ArrayList<Persona> listaPersonas(String direccion) throws Exception {
        String firstName, secondName, lastName1, lastName2, phone, fVacas;
        ArrayList<Persona> listaPersona = new ArrayList<>();
        String[] persona = new String[6];

        for (int i = 0; i < sLista(direccion).size(); i++) {
            persona = sLista(direccion).get(i).split("-");
            firstName=persona[0];
            secondName=persona[1];
            lastName1=persona[2];
            lastName2=persona[3];
            phone=persona[4];
            fVacas=persona[5];
            Persona personaAux = new Persona (firstName,secondName,lastName1,lastName2,phone,fVacas);
            listaPersona.add(personaAux);
        }
        return listaPersona;
    }

    public static void toStringLista(String direccion) throws Exception  {
        for (String linea: sLista(direccion)) {
            System.out.println(linea);
        }
    }

    public static void toStringListaPersonas(String direccion) throws Exception  {
        for (Persona personaAux: listaPersonas(direccion)) {
            System.out.println("\nPrimer nombre: "+personaAux.getFirstname()+".");
            System.out.println("Segundo nombre: "+personaAux.getSecondName()+".");
            System.out.println("primer Apellido: "+personaAux.getLastname1()+".");
            System.out.println("Segundo Apellido: "+personaAux.getLastname2()+".");
            System.out.println("teléfono: "+personaAux.getPhone()+".");
            System.out.println("Dia: "+personaAux.getfVacaciones().split("/")[0]+" Mes: "+personaAux.getfVacaciones().split("/")[1]+" Año: "+personaAux.getfVacaciones().split("/")[0]+" .");
        }
    }


    public String getFirstname() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastname1() {
        return lastName1;
    }

    public String getLastname2() {
        return lastName2;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() { return country; }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getfVacaciones() {return fVacaciones; }
}
