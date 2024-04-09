package tacos2.tacocloud2.Controllers;


import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tacos2.tacocloud2.Tacos.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;

import tacos2.tacocloud2.Tacos.Ingredient;
import tacos2.tacocloud2.Tacos.Ingredient.Type;
import tacos2.tacocloud2.Tacos.Taco;


import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsModel(Model model) { // Model - obiekt przenoszący dane między kontrolerem i widokiem odpowiedzialnym za ich wyświetlenie
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("PSZ", "Pszenny", Ingredient.Type.WRAP),
                new Ingredient("KUK", "Kukurydziany", Ingredient.Type.WRAP),
                new Ingredient("KUR", "Kurczak", Ingredient.Type.PROTEIN),
                new Ingredient("POM", "Pomidorki", Ingredient.Type.VEGGIES),
                new Ingredient("SAL", "Sałata", Ingredient.Type.VEGGIES),
                new Ingredient("FET", "Feta", Ingredient.Type.CHEESE),
                new Ingredient("MOC", "Mozzarela", Ingredient.Type.CHEESE),
                new Ingredient("CZO", "Czosnkowy", Ingredient.Type.SAUCE),
                new Ingredient("BBQ", "BBQ - HOT & SWEET", Ingredient.Type.SAUCE),
                new Ingredient("WOL", "Wołowina", Ingredient.Type.PROTEIN)
        );

        Type[] types = Ingredient.Type.values(); // filtrowanie listy na podstawie typu składnika
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), //czemu nie możemy od razu wyświetlić Stringa??
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute (name = "tacoOrder") // tworzy pusty obiekt tacoOrder??
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco") // tu odwołujemy się do tego co jest w HTML - design - i tam method="POST" th:object="${taco} ??
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type){
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco (
            @Valid Taco taco, Errors errors,
            @ModelAttribute TacoOrder tacoOrder){

        if (errors.hasErrors()){
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Procesing taco: {}", taco);

        return "redirect:/orders/current";
    }


}
