package species;

import annotations.CallMethod;
import annotations.CreateListOfUnits;
import annotations.InnerUnit;
import annotations.RandomInt;

import java.util.List;

public class Centaur extends Unit{
    public Centaur() {
        super("Cento", Ability.FIREBALLS);
    }

    @RandomInt(min = 70, max = 250)
    Integer lifeExpectancy;

    @CallMethod(method = "generate_nature")
    public Nature nature;

    @CallMethod(method = "generate_character")
    public Character character;

    @InnerUnit
    Elf slave;

    @CreateListOfUnits
    List<Unit> centaurArmy;

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
        System.out.println("Your slave is here, Sir");
        return slave;
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
