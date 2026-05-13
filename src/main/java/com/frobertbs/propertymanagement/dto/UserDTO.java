package com.frobertbs.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;

    private String ownerName;

    @NotNull(message = "Email is mandatory")
    private String email;

    private String phone;

    @Size(min = 6, max = 15, message = "Password must be between 6 and 15 characters")
    @NotNull
    private String password;
}
