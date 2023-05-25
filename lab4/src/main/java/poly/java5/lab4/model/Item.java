package poly.java5.lab4.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public @Data
class Item {
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity=1;
}
