package com.api.library.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdministratorRecordDTO(@NotBlank String name,@NotBlank String email,@NotBlank String documentCPF,
                                     @NotBlank @NotNull String phoneNumber, @NotBlank @NotNull String hiringCode) {
}
