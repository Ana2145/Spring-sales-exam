package mx.utez.edu.ventas.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomResponse<T>{
    T data;
    boolean error;
    int statusCode;
    String message;



}