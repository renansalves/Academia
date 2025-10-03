package br.tec.db.veiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.tec.db.veiculos.dto.MotoDto;
import br.tec.db.veiculos.model.Moto;
import br.tec.db.veiculos.repository.MotoRepository;
import br.tec.db.veiculos.util.ConverterMoto;

@Service
public class MotoService {

  @Autowired
  private MotoRepository motoRepository;

  @Autowired
  private ConverterMoto converterMoto;

  public MotoDto salvarMoto(Moto moto) {

    return converterMoto.converterParaDto(motoRepository.save(moto));
  }

  public ResponseEntity<MotoDto> atualizarMoto(Moto moto, Long id) {
    return motoRepository.findById(id).map(motoEntity -> {
      motoEntity.setModelo(moto.getModelo());
      motoEntity.setMarca(moto.getMarca());
      motoEntity.setTipo(moto.getTipo());
      motoEntity.setModelo(moto.getModelo());
      motoEntity.setTemPartidaEletrica(moto.getTemPartidaEletrica());

      Moto motoAtualizado = motoRepository.save(motoEntity);
      MotoDto motoDto = converterMoto.converterParaDto(motoAtualizado);
      return ResponseEntity.ok(motoDto);
    }).orElse(ResponseEntity.notFound().build());
  }

  public ResponseEntity<MotoDto> listaMotoPorId(Long id) {
    return motoRepository.findById(id)
        .map(moto -> {
          MotoDto motoDto = converterMoto.converterParaDto(moto);
          return ResponseEntity.ok(motoDto);
        })
        .orElse(ResponseEntity.notFound().build());
  }

}
