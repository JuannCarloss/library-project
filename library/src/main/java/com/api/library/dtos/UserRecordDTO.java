package com.api.library.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRecordDTO(@NotBlank String name,@NotBlank String email,@NotBlank @NotNull String documentCPF,
                            @NotBlank @NotNull String phoneNumber) {
}
