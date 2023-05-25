package poly.java5.lab3.model;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public @Data
class Student {

    @NotBlank()
    private String name;

    @NotBlank()
    @Email()
    private String email;

    @Min(value = 0)
    @Max(value = 10)
    @NotNull()
    private Double marks;

    @NotNull()
    private Boolean gender;

    @NotNull()
    private String faculty;

    @NotEmpty()
    private List<String> hobbies;
}
