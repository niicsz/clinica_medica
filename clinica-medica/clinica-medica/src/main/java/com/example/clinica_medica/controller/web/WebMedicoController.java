package com.example.clinica_medica.controller.web;

import com.example.clinica_medica.entities.Medico;
import com.example.clinica_medica.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/medicos")
public class WebMedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listarMedicos(Model model) {
        model.addAttribute("medicos", medicoService.listarTodosMedicos());
        return "medicos/lista";
    }

    @GetMapping("/novo")
    public String formNovoMedico(Model model) {
        model.addAttribute("medico", new Medico());
        return "medicos/form";
    }

    @PostMapping("/salvar")
    public String salvarMedico(@Valid @ModelAttribute("medico") Medico medico,
                               BindingResult result,
                               RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "medicos/form";
        }

        try {
            medicoService.incluirMedico(medico);
            attributes.addFlashAttribute("mensagem", "Médico cadastrado com sucesso!");
            return "redirect:/medicos";
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao cadastrar médico: " + e.getMessage());
            return "redirect:/medicos/novo";
        }
    }

    @GetMapping("/editar/{id}")
    public String formEditarMedico(@PathVariable Long id, Model model) {
        Medico medico = medicoService.buscarMedicoPorId(id);
        if (medico == null) {
            return "redirect:/medicos";
        }
        model.addAttribute("medico", medico);
        return "medicos/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMedico(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            medicoService.excluirMedico(id);
            attributes.addFlashAttribute("mensagem", "Médico excluído com sucesso!");
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao excluir médico: " + e.getMessage());
        }
        return "redirect:/medicos";
    }
}