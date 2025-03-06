package com.example.clinica_medica.services;

import com.example.clinica_medica.entities.Consulta;
import com.example.clinica_medica.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public Consulta agendarConsulta(Consulta consulta) {
        validationService.validarConsulta(consulta);
        return consultaRepository.save(consulta);
    }

    @Transactional(readOnly = true)
    public List<Consulta> listarTodasConsultas() {
        return consultaRepository.findAll();
    }

    @Transactional
    public void excluirConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    @Transactional
    public Consulta atualizarConsulta(Long id, Consulta consulta) {
        Consulta existingConsulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        consulta.setId(id);
        validationService.validarConsulta(consulta);
        return consultaRepository.save(consulta);
    }

    @Transactional(readOnly = true)
    public Consulta buscarConsultaPorId(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }
}