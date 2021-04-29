package species;

import annotations.CallMethod;
import annotations.CreateListOfUnits;
import annotations.InnerUnit;
import annotations.RandomInt;

import java.util.List;

public class Fairy extends Unit{
    public Fairy() {
        super("Fairy", Ability.FLYING);
    }

    @RandomInt(min = 25, max = 50)
    Integer lifeExpectancy;

    @CallMethod(method = "generate_nature")
    public Nature nature;

    @CallMethod(method = "generate_character")
    public Character character;

    @InnerUnit
    Fairy parent;

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
        System.out.println("Your mum is always here, honey");
        return parent;
    }

    @Override
    public String toString() {
        return "Fairy{" +
                "lifeExpectancy=" + lifeExpectancy +
                ", nature=" + nature +
                ", character=" + character +
                ", parent=" + parent +
                ", centaurArmy=" + centaurArmy +
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
