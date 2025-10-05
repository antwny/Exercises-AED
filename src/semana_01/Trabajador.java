package semana_01;

public class Trabajador {
    public int codigo, horas;
    public String nombre;
    public double tarifahoraria;

    public double sueldobruto(){
        return horas*tarifahoraria;
    }

    public double descuento(){
        return sueldobruto()*0.12;
        }
    

    public double sueldoneto(){
        return sueldobruto()-descuento();
    }
}
