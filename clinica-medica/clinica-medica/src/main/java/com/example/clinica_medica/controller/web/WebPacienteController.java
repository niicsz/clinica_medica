package com.example.clinica_medica.controller.web;

import com.example.clinica_medica.entities.Paciente;
import com.example.clinica_medica.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pacientes")
public class WebPacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodosPacientes());
        return "pacientes/lista";
    }

    @GetMapping("/novo")
    public String formNovoPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/form";
    }

    @PostMapping("/salvar")
    public String salvarPaciente(@Valid @ModelAttribute("paciente") Paciente paciente,
                                 BindingResult result,
                                 RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "pacientes/form";
        }

        try {
            pacienteService.incluirPaciente(paciente);
            attributes.addFlashAttribute("mensagem", "Paciente cadastrado com sucesso!");
            return "redirect:/pacientes";
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao cadastrar paciente: " + e.getMessage());
            return "redirect:/pacientes/novo";
        }
    }

    @GetMapping("/editar/{id}")
    public String formEditarPaciente(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
        if (paciente == null) {
            return "redirect:/pacientes";
        }
        model.addAttribute("paciente", paciente);
        return "pacientes/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPaciente(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            pacienteService.excluirPaciente(id);
            attributes.addFlashAttribute("mensagem", "Paciente excluído com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao excluir paciente: " + e.getMessage());
        }
        return "redirect:/pacientes";
    }
}