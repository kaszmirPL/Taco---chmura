package tacos2.tacocloud2.Tacos;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type{
        WRAP, SAUCE, CHEESE, PROTEIN, VEGGIES
    }
}
