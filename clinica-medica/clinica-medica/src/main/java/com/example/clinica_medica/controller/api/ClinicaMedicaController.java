package com.example.clinica_medica.controller.api;

import com.example.clinica_medica.entities.Consulta;
import com.example.clinica_medica.entities.Medico;
import com.example.clinica_medica.entities.Paciente;
import com.example.clinica_medica.entities.Usuario;
import com.example.clinica_medica.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClinicaMedicaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.incluirUsuario(usuario));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarTodosUsuarios());
    }


    @PostMapping("/pacientes")
    public ResponseEntity<Paciente> cadastrarPaciente(@Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.incluirPaciente(paciente));
    }

    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarTodosPacientes());
    }

    @GetMapping("/pacientes/cpf/{cpf}")
    public ResponseEntity<Paciente> buscarPacientePorCpf(@PathVariable String cpf) {
        Paciente paciente = pacienteService.buscarPacientePorCpf(cpf);
        return paciente != null
                ? ResponseEntity.ok(paciente)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/medicos")
    public ResponseEntity<Medico> cadastrarMedico(@Valid @RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.incluirMedico(medico));
    }

    @GetMapping("/medicos")
    public ResponseEntity<List<Medico>> listarMedicos() {
        return ResponseEntity.ok(medicoService.listarTodosMedicos());
    }

    @GetMapping("/medicos/{id}")
    public ResponseEntity<Medico> buscarMedicoPorId(@PathVariable Long id) {
        Medico medico = medicoService.buscarMedicoPorId(id);
        return medico != null
                ? ResponseEntity.ok(medico)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/consultas")
    public ResponseEntity<Consulta> agendarConsulta(@Valid @RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.agendarConsulta(consulta));
    }

    @GetMapping("/consultas")
    public ResponseEntity<List<Consulta>> listarConsultas() {
        return ResponseEntity.ok(consultaService.listarTodasConsultas());
    }
}