package phoowichai.phanuwat.lab10;

import java.time.*;

class Person implements Comparable<Person> {
    protected String name;
    protected double weight, height;
    protected LocalDate dob;

    Person(String name, double height, double weight, LocalDate dob) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.dob = dob;
    }

	// --- Name --- //
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // --- Weight --- //
    public double getWeight() {
        return this.weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // --- Height --- //
    public double getHeight() {
        return this.height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }

    // --- Date of Birth --- //
    public LocalDate getDoB() {
        return this.dob;
    }
    
    public void setDoB(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String name = getName();
        double weight = getWeight();
        double height = getHeight();
        LocalDate dob = getDoB();

        //Get age. (Compare dob with today date)
        int year_old = Math.abs(dob.getYear() - LocalDate.now().getYear());
        int month_old = Math.abs(dob.getMonthValue() - LocalDate.now().getMonthValue());
        int day_old = Math.abs(dob.getDayOfMonth() - LocalDate.now().getDayOfMonth());

        return name + " is " + year_old + " years " + month_old  + " months " 
                + day_old + " days, has weight as" + weight + " kg., and height as " 
                + height + " cm.";
    }

    @Override
    public int compareTo(Person other_person) {
        return this.getName().compareToIgnoreCase(other_person.getName());
    }
}