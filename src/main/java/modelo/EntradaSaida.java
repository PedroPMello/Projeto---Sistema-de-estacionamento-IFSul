/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "tb_entradasaida")
public class EntradaSaida {
     @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;
     
    @Column(nullable = false, length = 8)
    private Date data;
    
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    
    
    private final Veiculo veiculo;

    public EntradaSaida(TipoMovimentacao tipo, Veiculo veiculo) {
        tipoMovimentacao = tipo;
        this.veiculo = veiculo;
        data = new Date();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    
}
