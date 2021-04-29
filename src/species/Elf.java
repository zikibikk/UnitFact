package species;

import annotations.CallMethod;
import annotations.CreateListOfUnits;
import annotations.InnerUnit;
import annotations.RandomInt;

import java.util.List;

public class Elf extends Unit{
    public Elf() {
        super("Elf", Ability.HEALING);
    }

    @RandomInt(min = 300, max = 600)
    Integer lifeExpectancy;

    @CallMethod(method = "generate_nature")
    public Nature nature;

    @CallMethod(method = "generate_character")
    public Character character;

    @InnerUnit
    Fairy apprentice;

    @CreateListOfUnits
    List<Unit> elfArmy;

    @Override
    public Integer getLifeExpectancy() {
        return this.lifeExpectancy;
    }

    @Override
    public Nature getNature() {
        return this.nature;
    }

    @Override
    public Unit getInner(){
        System.out.println("Your apprentice, Lord");
        return apprentice;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "lifeExpectancy=" + lifeExpectancy +
                ", nature=" + nature +
                ", character=" + character +
                ", apprentice=" + apprentice +
                ", elfArmy=" + elfArmy +
                '}';
    }

    public void generate_nature(){
        switch (((int) Math.random()*5)%2) {
            case 0 -> this.nature = Nature.MILITANT;
            case 1 -> this.nature = Nature.PEACEFUL;
        }
    }

    public void generate_character(){
        switch ((int) (Math.random() * 4)) {
            case 0 -> this.character = Character.ANGRY;
            case 1 -> this.character = Character.GENEROUS;
            case 2 -> this.character = Character.IRSCIBLE;
            case 3 -> this.character = Character.MERCIFUL;
            default -> this.character = Character.STRICT;
        }
    }
}
