package tech.wvs.appdesafio.pagination;

import org.springframework.data.domain.Page;

public record PaginationResponse(
        Integer page,
        Integer pageSize,
        Long totalElements,
        Integer totalPages,
        boolean hasNext) {

    public static PaginationResponse fromPage(Page pageable) {
        return new PaginationResponse(
                pageable.getNumber(),
                pageable.getSize(),
                pageable.getTotalElements(),
                pageable.getTotalPages(),
                pageable.hasNext());
    }
}
