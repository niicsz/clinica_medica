package com.example.clinica_medica.services;

import com.example.clinica_medica.entities.Paciente;
import com.example.clinica_medica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public Paciente incluirPaciente(Paciente paciente) {
        validationService.validarPaciente(paciente);
        return pacienteRepository.save(paciente);
    }

    @Transactional(readOnly = true)
    public Paciente buscarPacientePorCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }

    @Transactional(readOnly = true)
    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }

    @Transactional
    public void excluirPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Transactional
    public Paciente atualizarPaciente(Long id, Paciente paciente) {
        Paciente existingPaciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        paciente.setId(id);
        validationService.validarPaciente(paciente);
        return pacienteRepository.save(paciente);
    }

    @Transactional(readOnly = true)
    public Paciente buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }
}