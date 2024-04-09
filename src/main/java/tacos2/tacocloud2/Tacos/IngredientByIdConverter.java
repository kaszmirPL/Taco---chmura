package tacos2.tacocloud2.Tacos;

import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.util.HashMap;
import java.util.Map;

import tacos2.tacocloud2.Tacos.Ingredient; // czemu samo Ingredient skoro impotruje później Type, albo samo ingredient nie wystarczy
import tacos2.tacocloud2.Tacos.Ingredient.Type;




@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{ //czy skoro mamy id to nie możemy danych z DesignTacoController wykożystać?

    private Map <String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter(){ // czemu musze konwertować ?? toż przecież w design mam
        ingredientMap.put("PSZ",
                new Ingredient("PSZ", "Pszenny Placek", Type.WRAP));
        ingredientMap.put("KUK",
                new Ingredient("KUK", "Kukurydziany Placek", Type.WRAP));
        ingredientMap.put("KUR",
                new Ingredient("KUR", "Pieczony kurczak", Type.PROTEIN));
        ingredientMap.put("WOL",
                new Ingredient("WOL",  "Pieczona wołowna", Type.PROTEIN));
        ingredientMap.put("POM",
                new Ingredient("POM", "Pomidorki koktajlowe", Type.VEGGIES));
        ingredientMap.put("SAL",
                new Ingredient("SAL", "Mix sałąt", Type.VEGGIES));
        ingredientMap.put("FET",
                new Ingredient("FET", "Fata", Type.CHEESE));
        ingredientMap.put("MOC",
                new Ingredient("MOC", "Mozzarela", Type.CHEESE));
        ingredientMap.put("CZO",
                new Ingredient("CZO", "Czosnkowy", Type.SAUCE));
        ingredientMap.put("BQQ",
                new Ingredient("BQQ", "BBQ HOT & SWEET", Type.SAUCE));
    }

    @Override
    public Ingredient convert (String id){

        return ingredientMap.get(id);
    }
}
