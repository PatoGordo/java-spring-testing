package com.example.crud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestProduct(
        @NotBlank @NotNull String name,
        @NotNull Integer price
) { }
