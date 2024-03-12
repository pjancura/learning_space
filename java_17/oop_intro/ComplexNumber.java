package java_17.oop_intro;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public void add(double real, double imaginary) {
        this.real = real + this.real;
        this.imaginary = imaginary + this.imaginary;
    }

    public void add(ComplexNumber complexNumber) {
        this.real = complexNumber.getReal() + this.real;
        this.imaginary = complexNumber.getImaginary() + this.imaginary;
    }

    public void subtract(double real, double imaginary) {
        this.real = this.real - real;
        this.imaginary = this.imaginary - imaginary;
    }

    public void subtract(ComplexNumber complexNumber) {
        this.real = this.real - complexNumber.getReal();
        this.imaginary = this.imaginary - complexNumber.getImaginary();
    }
    
}
