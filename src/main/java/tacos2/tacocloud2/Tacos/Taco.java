package tacos2.tacocloud2.Tacos;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



@Data
public class Taco {

    private long id; // dodanie unikatowego id do naszego Tacosa (dla DataBase)
    private Date createdAt = new Date(); // Tworzenie pola z datą zamówienia

    @NotNull
    @Size (min = 5, message = "Nazwa musi zawierać nonajmniej 5 znaków")
    private String name;

    @NotNull
    @Size(min = 1, message = "musisz wybrać conajmniej jeden składnik")
    private List<Ingredient> ingredients;

}
