import annotations.CallMethod;
import annotations.CreateListOfUnits;
import annotations.InnerUnit;
import annotations.RandomInt;
import species.Unit;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitFactory {

    public Unit createUnit(String unitClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException, IllegalClassFormatException, ClassNotFoundException {
        Unit unitByName = createUnitByName(false, unitClass);
        callMethod(unitByName);
        makeInnerUnit(unitByName);
        return unitByName;
    }

    private Unit createUnitByName(boolean isInner, String unitClass) throws ClassNotFoundException, IllegalClassFormatException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class newUnit;
        if (isInner) {
             newUnit = Class.forName(unitClass);
        }else  newUnit = Class.forName("species."+unitClass);

        if(newUnit.getSuperclass() == Unit.class) {
            Unit unit = (Unit) newUnit.getConstructor().newInstance();
            Arrays.stream(unit.getClass().getDeclaredFields()).forEach(field -> {
                if (field.getAnnotation(RandomInt.class) != null) {
                    field.setAccessible(true);
                    try {
                        field.set(unit, randomInt(field.getAnnotation(RandomInt.class).min(),
                                field.getAnnotation(RandomInt.class).min()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
            return unit;
        }
        return null;
    };

    private void callMethod(Unit unit){
        Arrays.stream(unit.getClass().getDeclaredFields()).forEach(field -> {
            if (field.getAnnotation(CallMethod.class) != null) {
                try {
                    unit.getClass()
                            .getMethod(field.getAnnotation(CallMethod.class).method(), null)
                            .invoke(unit,null);
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void makeInnerUnit(Unit unit) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, IllegalClassFormatException, ClassNotFoundException {
        Arrays.stream(unit.getClass().getDeclaredFields()).forEach(field -> {
            if (field.getAnnotation(InnerUnit.class) != null) {
                try {
                    field.setAccessible(true);
                    field.set(unit,createUnitByName(true, field.getType().getTypeName()));
                } catch (ClassNotFoundException | IllegalClassFormatException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    List<Unit> getUnits(int count, String unitClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException, IllegalClassFormatException, ClassNotFoundException {
        Unit u = createUnitByName(false, unitClass);
        List<Unit> units = new ArrayList<>();
        Arrays.stream(u.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(CreateListOfUnits.class) != null)
                .forEach(field -> {
                    for (int i = 0; i < count; i++) {
                        try {
                            units.add(createUnitByName(false, unitClass));
                        } catch (ClassNotFoundException | IllegalClassFormatException
                                | NoSuchMethodException | IllegalAccessException
                                | InvocationTargetException | NoSuchFieldException
                                | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return units;
    }

    int randomInt(int min, int max){
        if(min>=max){
            int tmp = min;
            min = max;
            max = tmp+1;
        }

        return (int)(min + max*Math.random());
    }

}
