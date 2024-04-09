package tacos2.tacocloud2.Tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank; // czemu tu jest jakarta, a nie javax??
import lombok.Data;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;


@Data
public class TacoOrder {
    private static final long serialVersionUID = 1L;
    private Long id; // dodanie indywidualnego id (dla DB)
    private Data placedAt; // dodanie daty


    @NotBlank (message = "Imię jest wymagane")
    private String deliveryName;

    @NotBlank (message = "Ulica jest wymagana")
    private String deliveryStreet;

    @NotBlank (message = "Miasto jest wymagane")
    private String deliveryCity;

    @NotBlank (message = "Województwo jest wymagane")
    private String deliveryState;

    @NotBlank (message = "Kod pocztowy jest wymagany")
    private String deliveryZip;

    @NotBlank (message = "Niepoprawny nr. karty")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Wymagany format MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "nieprawidłowy nr. CVV")
    private String ccCVV;

    private List <Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco){ // metoda
        this.tacos.add(taco);
    }

}
