package br.tec.db.veiculos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.tec.db.veiculos.dto.VeiculoDto;
import br.tec.db.veiculos.model.Caminhao;
import br.tec.db.veiculos.model.Carro;
import br.tec.db.veiculos.model.Moto;
import br.tec.db.veiculos.model.Veiculo;
import br.tec.db.veiculos.repository.VeiculosRepository;
import br.tec.db.veiculos.util.VeiculoConverter;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VeiculoService {

    @Autowired
    private VeiculosRepository veiculosRepository;

    @Autowired
    private VeiculoConverter veiculoConverter;

    public ResponseEntity<List<VeiculoDto>> listarVeiculos() {
        List<Veiculo> listaVeiculos = veiculosRepository.findAll();
        List<VeiculoDto> dtos = listaVeiculos.stream()
                .map(veiculoConverter::converterParaDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    public VeiculoDto salvarVeiculo(Veiculo veiculo) {
        VeiculoDto veiculoDto = veiculoConverter.converterParaDto(veiculo);

        System.out.println("id: " + veiculosRepository.save(veiculo).getId());
        return veiculoDto;
    }

    public VeiculoDto atualizarVeiculo(Veiculo veiculo, Long id) {
        Optional<Veiculo> veiculoOptional = veiculosRepository.findById(id);
        if (veiculoOptional.isEmpty()) {
            throw new EntityNotFoundException("Veículo com ID " + id + " não encontrado");
        }

        Veiculo veiculoExistente = veiculoOptional.get();

        if (veiculo.getAnoFabricacao().equals(null))
            veiculoExistente.setAnoFabricacao(veiculo.getAnoFabricacao());
        if (veiculo.getModelo().equals(null))
            veiculoExistente.setModelo(veiculo.getModelo());
        if (veiculo.getMarca().equals(null))
            veiculoExistente.setMarca(veiculo.getMarca());
        if (veiculo.getTipo().equals(null))
            veiculoExistente.setTipo(veiculo.getTipo());

        // Atualiza campos específicos conforme o tipo
        if (veiculoExistente instanceof Moto && veiculo instanceof Moto) {
            ((Moto) veiculoExistente).setTemPartidaEletrica(((Moto) veiculo).getTemPartidaEletrica());
        } else if (veiculoExistente instanceof Caminhao && veiculo instanceof Caminhao) {
            ((Caminhao) veiculoExistente).setCapacidadeCarga(((Caminhao) veiculo).getCapacidadeCarga());
        } else if (veiculoExistente instanceof Carro && veiculo instanceof Carro) {
            ((Carro) veiculoExistente).setNumeroPortas(((Carro) veiculo).getNumeroPortas());
        } else {
            throw new IllegalArgumentException("Tipo de veículo desconhecido: " + veiculo.getClass().getName());
        }

        Veiculo veiculoAtualizado = veiculosRepository.save(veiculoExistente);
        return veiculoConverter.converterParaDto(veiculoAtualizado);
    }

    public Boolean deletarVeiculo(Long id) {
        if (veiculosRepository.existsById(id)) {
            veiculosRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
