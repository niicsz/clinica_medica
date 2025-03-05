package com.example.clinica_medica.controller.web;

import com.example.clinica_medica.entities.Consulta;
import com.example.clinica_medica.services.ConsultaService;
import com.example.clinica_medica.services.MedicoService;
import com.example.clinica_medica.services.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/consultas")
public class WebConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaService.listarTodasConsultas());
        return "consultas/lista";
    }

    @GetMapping("/nova")
    public String formNovaConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("pacientes", pacienteService.listarTodosPacientes());
        model.addAttribute("medicos", medicoService.listarTodosMedicos());
        return "consultas/form";
    }

    @PostMapping("/salvar")
    public String salvarConsulta(@Valid @ModelAttribute("consulta") Consulta consulta,
                                 BindingResult result,
                                 RedirectAttributes attributes,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pacientes", pacienteService.listarTodosPacientes());
            model.addAttribute("medicos", medicoService.listarTodosMedicos());
            return "consultas/form";
        }

        try {
            consultaService.agendarConsulta(consulta);
            attributes.addFlashAttribute("mensagem", "Consulta agendada com sucesso!");
            return "redirect:/consultas";
        } catch (Exception e) {
            attributes.addFlashAttribute("mensagemErro", "Erro ao agendar consulta: " + e.getMessage());
            return "redirect:/consultas/nova";
        }
    }
}