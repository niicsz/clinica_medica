package com.example.clinica_medica.services;

import com.example.clinica_medica.entities.Medico;
import com.example.clinica_medica.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public Medico incluirMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Transactional(readOnly = true)
    public Medico buscarMedicoPorId(Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Medico> listarTodosMedicos() {
        return medicoRepository.findAll();
    }
}