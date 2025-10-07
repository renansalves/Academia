package br.tec.db.veiculos.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "veiculo")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Carro.class, name = "Carro"),
        @JsonSubTypes.Type(value = Moto.class, name = "Moto"),
        @JsonSubTypes.Type(value = Caminhao.class, name = "Caminhao")
})
public abstract class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String tipo;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", anoFabricacao="
                + anoFabricacao + "]";
    }
}
