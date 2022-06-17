package br.com.aleferamos.BookStore.controllers.dto;

import br.com.aleferamos.BookStore.services.validation.ChagePasswordSave;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ChagePasswordSave
public class ResetPasswordDTO {

    @NotNull
    @Size(min=10)
    private String token;

    @NotNull
    @Size(min=6)
    private String password;

    @NotNull
    @Size(min=6)
    @JsonProperty("password_confirm")
    private String passwordConfirm;

}