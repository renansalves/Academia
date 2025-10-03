
package br.tec.db.veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.tec.db.veiculos.dto.CarroDto;
import br.tec.db.veiculos.model.Carro;
import br.tec.db.veiculos.repository.CarroRepository;
import br.tec.db.veiculos.util.ConverterCarro;

@Service
public class CarroService {

  @Autowired
  private CarroRepository carroRepository;

  @Autowired
  private ConverterCarro converterCarro;

  public CarroDto salvarCarro(Carro carro) {
    return converterCarro.converterParaDto(carroRepository.save(carro));
  }

  public ResponseEntity<CarroDto> atualizarCarro(Carro carro, Long id) {
    return carroRepository.findById(id)
        .map(carroEntity -> {
          carroEntity.setMarca(carro.getMarca());
          carroEntity.setTipo(carro.getTipo());
          carroEntity.setModelo(carro.getModelo());
          carroEntity.setNumeroPortas(carro.getNumeroPortas());

          Carro carroAtualizado = carroRepository.save(carroEntity);
          CarroDto carroDto = converterCarro.converterParaDto(carroAtualizado);

          return ResponseEntity.ok(carroDto);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  public ResponseEntity<CarroDto> listaCarroPorId(Long id) {
    return carroRepository.findById(id)
        .map(carro -> {
          CarroDto carroDto = converterCarro.converterParaDto(carro);
          return ResponseEntity.ok(carroDto);
        })
        .orElse(ResponseEntity.notFound().build());
  }

}
