package com.example.clinica_medica.config;

import com.example.clinica_medica.entities.Medico;
import com.example.clinica_medica.entities.Paciente;
import com.example.clinica_medica.entities.Usuario;
import com.example.clinica_medica.services.MedicoService;
import com.example.clinica_medica.services.PacienteService;
import com.example.clinica_medica.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public CommandLineRunner initTestData() {
        return args -> {
            Medico medico1 = new Medico();
            medico1.setNome("Dr. João Silva");
            medico1.setEspecialidade("Cardiologia");
            medicoService.incluirMedico(medico1);

            Medico medico2 = new Medico();
            medico2.setNome("Dra. Maria Souza");
            medico2.setEspecialidade("Pediatria");
            medicoService.incluirMedico(medico2);

            Medico medico3 = new Medico();
            medico3.setNome("Dr. Pedro Santos");
            medico3.setEspecialidade("Ortopedia");
            medicoService.incluirMedico(medico3);

            Paciente paciente1 = new Paciente();
            paciente1.setNome("Ana Oliveira");
            paciente1.setCpf("12345678901");
            paciente1.setIdade(35);
            paciente1.setEmail("ana@email.com");
            pacienteService.incluirPaciente(paciente1);

            Paciente paciente2 = new Paciente();
            paciente2.setNome("Carlos Pereira");
            paciente2.setCpf("98765432109");
            paciente2.setIdade(42);
            paciente2.setEmail("carlos@email.com");
            pacienteService.incluirPaciente(paciente2);

            Paciente paciente3 = new Paciente();
            paciente3.setNome("Mariana Costa");
            paciente3.setCpf("45678912345");
            paciente3.setIdade(28);
            paciente3.setEmail("mariana@email.com");
            pacienteService.incluirPaciente(paciente3);

            Usuario usuario1 = new Usuario();
            usuario1.setNome("Admin");
            usuario1.setCpf("11111111111");
            usuario1.setIdade(40);
            usuario1.setEmail("admin@clinica.com");
            usuario1.setSenha("senha123");
            usuarioService.incluirUsuario(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setNome("Recepcionista");
            usuario2.setCpf("22222222222");
            usuario2.setIdade(35);
            usuario2.setEmail("recepcao@clinica.com");
            usuario2.setSenha("senha456");
            usuarioService.incluirUsuario(usuario2);
        };
    }
}
