/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "tb_veioficial")
public class VeiOficial extends Veiculo{
    @Column(name = "renavan", length = 11, nullable = false)
    private String renavan;
    
    @Column(name = "chassi", length = 20, nullable = false)
    private String chassi;
    
    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
}
