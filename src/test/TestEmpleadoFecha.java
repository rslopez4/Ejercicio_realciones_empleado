package test;

import dominio.Empleado;
import dominio.Fecha;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestEmpleadoFecha {

    static Scanner datos = new Scanner(System.in);
    static Fecha fechaNacimiento;
    static Fecha fechaIngreso;
    static Fecha fechaActual;

    public static void main(String[] args) {
        ingresarDatos();
    }

    public static void ingresarDatos() {
        System.out.println("¿Cuántos empleados  desea registrar?");
        int n = datos.nextInt();
        Empleado emp[] = new Empleado[n];
        llenaEmpresa(emp);
        for (int i = 0; i < emp.length; i++) {
            //edad = calcularEdad(emp[i].getDia(), emp[i].getMes(), emp[i].getAnio());
            System.out.println("Empleado No." + (i + 1));
            System.out.println("Nombre de empleado: " + emp[i].getNombre());
            System.out.println("Fecha de nacimiento: " + emp[i].getFechaN().toString());
            System.out.print("Su edad es: ");
            calcularEdad(emp[i].getFechaN());
            System.out.println("");
            System.out.println("Fecha de ingreso: " + emp[i].getFechaI().toString());
            System.out.print("Su tiempo en la empresa son: ");
            calcularTiempoEmpresa(emp[i].getFechaI());
            System.out.println("");
            System.out.println("");
            
        }
    }

    public static void llenaEmpresa(Empleado emp[]) {
        String nombre;
        int anio = 0;
        int mes = 0;
        int dia = 0;

        for (int i = 0; i < emp.length; i++) {
            datos.nextLine();
            System.out.println("Empleado No." + (i + 1));
            System.out.print("Ingrese nombre: ");
            nombre = datos.nextLine();
            System.out.println(" ");
            System.out.println("Fecha de nacimiento:");
            System.out.println("Ingrese año:");
            anio = datos.nextInt();
            System.out.println("Ingrese mes:");
            mes = datos.nextInt();
            System.out.println("Ingrese dia:");
            dia = datos.nextInt();
            fechaNacimiento = new Fecha(dia, mes, anio);
            System.out.println(" ");
            System.out.println("Fecha de Ingreso:");
            System.out.println("Ingrese año:");
            anio = datos.nextInt();
            System.out.println("Ingrese mes:");
            mes = datos.nextInt();
            System.out.println("Ingrese dia:");
            dia = datos.nextInt();
            fechaIngreso = new Fecha(dia, mes, anio);
            System.out.println(" ");
            emp[i] = new Empleado(nombre, fechaNacimiento, fechaIngreso);
        }
    }

    public static Fecha fechaActual() {
        Calendar calendario = new GregorianCalendar();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DATE);
        fechaActual = new Fecha(dia,mes+1,anio);
        return fechaActual;
    }
    
    public static void calcularEdad(Fecha fechaNacimiento){
        fechaActual = fechaActual();
        LocalDate fechaNac = LocalDate.of(fechaNacimiento.getAnio(), fechaNacimiento.getMes(), fechaNacimiento.getDia());
        LocalDate fechaAct = LocalDate.of(fechaActual.getAnio(), fechaActual.getMes(), fechaActual.getDia());
        Period periodo = Period.between(fechaNac, fechaAct);
        System.out.printf("%s años, %s meses y %s dias.", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
    
        public static void calcularTiempoEmpresa(Fecha fechaIngreso){
        fechaActual = fechaActual();
        LocalDate fechaIng = LocalDate.of(fechaIngreso.getAnio(), fechaIngreso.getMes(), fechaIngreso.getDia());
        LocalDate fechaAct = LocalDate.of(fechaActual.getAnio(), fechaActual.getMes(), fechaActual.getDia());
        Period periodo = Period.between(fechaIng, fechaAct);
        System.out.printf("%s años, %s meses y %s dias.", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}
