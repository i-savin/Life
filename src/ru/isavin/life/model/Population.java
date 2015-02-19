package ru.isavin.life.model;

/**
 * @author ilasavin
 * @since 19.02.15
 */
public enum Population {
    Random("Random colony"),
    Glider("Glider"),
    GliderGun("Glider Gun"),
    DieHard("Diehard"),
    Acorn("Acorn"),
    LineColony("Line colony");

    private String name;

    private Population(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
