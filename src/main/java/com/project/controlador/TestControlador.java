package com.project.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestControlador {

    @GetMapping("/usuario")
    public String usuarioTest() {
        return "Acceso permitido para USUARIO";
    }

    @GetMapping("/empleado")
    public String empleadoTest() {
        return "Acceso permitido para EMPLEADO o ADMIN";
    }

    @GetMapping("/admin")
    public String adminTest() {
        return "Acceso permitido solo para ADMIN";
    }
}
