/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;
    
    /**
     * Constructor de la clase Animal
     * <p>
     * Crea un nuevo objeto Animal inicializando sus atributos principales:
     * código identificativo, fecha de nacimiento, sexo y peso.
     * </p>
     * <p>Validaciones realizadas sobre los parámetros:
     * <ul>
     *     <li>El {@code codigo} debe tener exactamente 5 caracteres alfanuméricos 
     *         (dígitos 0-9 o letras minúsculas a-z).</li>
     *     <li>El {@code sexo} debe ser igual a 'M' (hembra) o 'H' (macho).</li>
     *     <li>El {@code peso} debe ser un valor numérico positivo mayor que cero.</li>
     *     <li>La {@code fechaNacimiento} debe corresponder a un formato ISO-8601 
     *         válido (yyyy-MM-dd).</li>
     * </ul>
     * </p>
     * 
     * @param codigo El código identificativo del animal, compuesto por 5 caracteres alfanuméricos en minúscula.
     * @param fechaNacimiento La fecha de nacimiento del animal en formato "yyyy-MM-dd".
     * @param sexo El sexo del animal, donde 'M' representa hembra y 'H' representa macho.
     * @param peso El peso del animal en kilogramos, debe ser estrictamente mayor que 0.
     * 
     * @throws IllegalArgumentException si el código no cumple el patrón establecido,<br> 
     * el sexo es incorrecto, el peso no es positivo o la fecha no tiene un formato válido.
     */
    
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {
 
        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    public abstract String hacerSonido();

    public abstract String alegrarse();

    public abstract String enfadarse();

    public abstract String queSoy();

}
