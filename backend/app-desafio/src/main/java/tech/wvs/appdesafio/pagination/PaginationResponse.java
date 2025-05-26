package tech.wvs.appdesafio.pagination;

public record PaginationResponse(
        Integer page,
        Integer pageSize,
        Long totalElements,
        Integer totalPages,
        boolean hasNext) {
}
