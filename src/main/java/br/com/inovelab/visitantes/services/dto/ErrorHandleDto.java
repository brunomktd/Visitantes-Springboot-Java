package br.com.inovelab.visitantes.services.dto;

public class ErrorHandleDto {
    private String input;
    private String error;

    public ErrorHandleDto(String input, String error) {
        this.input = input;
        this.error = error;
    }

    public String getInput() {
        return input;
    }

    public String getError() {
        return error;
    }
}
