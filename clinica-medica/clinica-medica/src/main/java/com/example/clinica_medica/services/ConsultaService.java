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

    @Transactional
    public Consulta agendarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Transactional(readOnly = true)
    public List<Consulta> listarTodasConsultas() {
        return consultaRepository.findAll();
    }
}
