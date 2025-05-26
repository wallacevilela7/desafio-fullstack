package tech.wvs.appdesafio.dto;

import tech.wvs.appdesafio.domain.Product;

import java.math.BigDecimal;

public record ProductDto(String name,
                         BigDecimal price) {

    public static ProductDto fromDomain(Product product) {
        return new ProductDto(product.getName(), product.getPrice());
    }
}
