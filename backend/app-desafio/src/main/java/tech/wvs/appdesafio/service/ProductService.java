package tech.wvs.appdesafio.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import tech.wvs.appdesafio.dto.ProductDto;
import tech.wvs.appdesafio.pagination.PageResponse;
import tech.wvs.appdesafio.pagination.PaginationResponse;
import tech.wvs.appdesafio.repository.ProductRepository;

import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public PageResponse<ProductDto> findAll(Integer page, Integer pageSize) {
        var pageRequest = PageRequest.of(page, pageSize);

        var items = repository.findAll(pageRequest);

        var content = items.stream()
                .map(ProductDto::fromDomain)
                .toList();

        return new PageResponse<>(
                content,
                new PaginationResponse(
                        items.getNumber(),
                        items.getSize(),
                        items.getTotalElements(),
                        items.getTotalPages(),
                        items.hasNext()));
    }
}
