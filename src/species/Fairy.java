package species;

import annotations.CallMethod;

public class Fairy extends Unit{
    public Fairy() {
        super("fairy", Ability.FLYING);
    }

    @CallMethod(method = "printMe")
    public String str = "me";

    void printMe(){
        System.out.println(str);
    }

    @Override
    public Nature getNature() {
        return null;
    }

    @Override
    public Integer getLifeExpectancy() {
        return null;
    }
}
