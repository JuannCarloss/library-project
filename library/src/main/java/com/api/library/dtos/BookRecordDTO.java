package com.api.library.dtos;

import jakarta.validation.constraints.NotBlank;

public record BookRecordDTO(@NotBlank String name,@NotBlank String autor,@NotBlank String publisher) {
}
