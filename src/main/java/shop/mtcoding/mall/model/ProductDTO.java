package shop.mtcoding.mall.model;

import lombok.*;


@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private String des;//상품설명

    @Builder
    public ProductDTO(Integer id, String name, Integer price, Integer qty, String des) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.des = des;
    }
}
