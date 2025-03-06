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

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuario));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario != null
                ? ResponseEntity.ok(usuario)
                : ResponseEntity.notFound().build();
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

    @PutMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.atualizarPaciente(id, paciente));
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<Void> excluirPaciente(@PathVariable Long id) {
        pacienteService.excluirPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPacientePorId(id);
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

    @PutMapping("/medicos/{id}")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable Long id, @Valid @RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.atualizarMedico(id, medico));
    }

    @DeleteMapping("/medicos/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        medicoService.excluirMedico(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/consultas")
    public ResponseEntity<Consulta> agendarConsulta(@Valid @RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.agendarConsulta(consulta));
    }

    @GetMapping("/consultas")
    public ResponseEntity<List<Consulta>> listarConsultas() {
        return ResponseEntity.ok(consultaService.listarTodasConsultas());
    }

    @PutMapping("/consultas/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable Long id, @Valid @RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.atualizarConsulta(id, consulta));
    }

    @DeleteMapping("/consultas/{id}")
    public ResponseEntity<Void> excluirConsulta(@PathVariable Long id) {
        consultaService.excluirConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consultas/{id}")
    public ResponseEntity<Consulta> buscarConsultaPorId(@PathVariable Long id) {
        Consulta consulta = consultaService.buscarConsultaPorId(id);
        return consulta != null
                ? ResponseEntity.ok(consulta)
                : ResponseEntity.notFound().build();
    }
}