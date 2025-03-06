package com.example.clinica_medica.controller.web;

import com.example.clinica_medica.entities.Usuario;
import com.example.clinica_medica.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class WebUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodosUsuarios());
        return "usuarios/lista";
    }

    @GetMapping("/novo")
    public String formNovoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                BindingResult result,
                                RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "usuarios/form";
        }

        try {
            usuarioService.incluirUsuario(usuario);
            attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
            return "redirect:/usuarios";
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao cadastrar usuário: " + e.getMessage());
            return "redirect:/usuarios/novo";
        }
    }

    @GetMapping("/editar/{id}")
    public String formEditarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario == null) {
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", usuario);
        return "usuarios/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            usuarioService.excluirUsuario(id);
            attributes.addFlashAttribute("mensagem", "Usuário excluído com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao excluir usuário: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }
}