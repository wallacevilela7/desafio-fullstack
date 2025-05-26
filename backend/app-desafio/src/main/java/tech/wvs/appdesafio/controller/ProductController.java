package tech.wvs.appdesafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.wvs.appdesafio.dto.ProductDto;
import tech.wvs.appdesafio.pagination.PageResponse;
import tech.wvs.appdesafio.service.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<PageResponse<ProductDto>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                            @RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize) {
        return ResponseEntity.ok(service.findAll(page, pageSize));
    }
}
