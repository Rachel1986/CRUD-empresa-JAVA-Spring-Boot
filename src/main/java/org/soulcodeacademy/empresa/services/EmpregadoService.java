package org.soulcodeacademy.empresa.services;

import org.soulcodeacademy.empresa.domain.Empregado;
import org.soulcodeacademy.empresa.domain.dto.EmpregadoDTO;
import org.soulcodeacademy.empresa.repositories.EmpregadoRepository;
import org.soulcodeacademy.empresa.services.errors.RecursoNaoEncontradoError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EnderecoService enderecoService;

    public List<Empregado> listar() {

        return this.empregadoRepository.findAll();
    }

  public Empregado getEmpregado(Integer idEmpregado) {
      Optional<Empregado> empregado = this.empregadoRepository.findById(idEmpregado);

      if (empregado.isEmpty()) {
          throw new RecursoNaoEncontradoError("O empregado não foi encontrado.");
      } else {
          return empregado.get();
      }
  }

    public Empregado salvar(EmpregadoDTO dto) {
       Empregado empregado = new Empregado(null, dto.getNome(), dto.getEmail(), dto.getSalario());
       Empregado salvo = this.empregadoRepository.save(empregado);

        return salvo;
    }

    public Empregado atualizar(Integer idEmpregado, EmpregadoDTO dto) {
        // Busca o funcionário com o idFuncionario
        Empregado empregadoAtual = this.getEmpregado(idEmpregado);

        empregadoAtual.setNome(dto.getNome());
        empregadoAtual.setEmail(dto.getEmail());
        empregadoAtual.setSalario(dto.getSalario());

        Empregado atualizado = this.empregadoRepository.save(empregadoAtual);
        return atualizado;
    }

    public void deletar(Integer idEmpregado) {
        Empregado empregado = this.getEmpregado(idEmpregado);
        this.empregadoRepository.delete(empregado);
    }
}
