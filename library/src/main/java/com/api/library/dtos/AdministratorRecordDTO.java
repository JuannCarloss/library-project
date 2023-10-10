package com.api.library.dtos;

import jakarta.validation.constraints.NotBlank;

public record AdministratorRecordDTO(@NotBlank String name,@NotBlank String email,@NotBlank String cpf) {
}
