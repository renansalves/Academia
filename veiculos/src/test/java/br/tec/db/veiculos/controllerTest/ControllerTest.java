package br.tec.db.veiculos.controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.tec.db.veiculos.service.*;
import br.tec.db.veiculos.model.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DirtiesContext()
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private VeiculoService veiculoService;

  @Test
  void deveCriarMotoComSucesso() throws Exception {
    Moto moto = new Moto();
    moto.setTipo("Moto");
    moto.setMarca("Honda");
    moto.setModelo("CG 160");
    moto.setAnoFabricacao(2022);
    moto.setTemPartidaEletrica(true);

    mockMvc.perform(post("/veiculos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(moto)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.tipo").value("Moto"))
        .andExpect(jsonPath("$.marca").value("Honda"));
  }

  @Test
  void deveListarVeiculos() throws Exception {
    mockMvc.perform(get("/veiculos"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray());
  }

  @Test
  void deveAtualizarUmVeiculo() throws Exception {

    Moto motoSalvar = new Moto();
    motoSalvar.setTipo("Moto");
    motoSalvar.setMarca("Honda");
    motoSalvar.setModelo("CG 160");
    motoSalvar.setAnoFabricacao(2022);
    motoSalvar.setTemPartidaEletrica(true);
    veiculoService.salvarVeiculo(motoSalvar);

    Moto moto = new Moto();
    moto.setTipo("Moto");
    moto.setMarca("Honda");
    moto.setModelo("CG 160");
    moto.setAnoFabricacao(2023);
    moto.setTemPartidaEletrica(true);

    mockMvc.perform(put("/veiculos/2")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(moto)))
        .andExpect(status().isOk());
  }

  @Test
  void deveExcluirUmVeiculoComSucesso() throws Exception {
    Carro carro = new Carro();
    carro.setTipo("Carro");
    veiculoService.salvarVeiculo(carro);

    mockMvc.perform(delete("/veiculos/1"))
        .andExpect(status().isNoContent());

  }
}
