package org.guilherme.ifsp.exercises.TreinoPOO.ContaDeBanco;


import java.util.Objects;

public class ContaBanco {
    private final int numConta;
    private TipoConta tipo;
    private final String dono;
    private double saldo;
    private boolean status;


    public ContaBanco(int numConta, String dono, TipoConta tipo, double saldoInicial, boolean status) {
        this.numConta = numConta;
        this.dono = dono;
        this.tipo =  tipo;
        this.saldo = saldoInicial;
        this.status = status;
    }

    public void abrirConta(TipoConta tipo){
        if(!status){
            this.status = true;
            this.tipo = tipo;
        }
    }

    public void fecharConta(){
        if(saldo != 0){
            throw new RegraNegocioException("Não é possível fechar conta com saldo disponível. Favor sacar todo o saldo");
        }
        this.status = false;
    }

    public double depositar(double valor){
        if(!this.status){
            throw new RegraNegocioException("Sua conta não foi aberta");
        }
        if(valor < 0){
            throw new RegraNegocioException("O valor do depósito deve ser maior que 0");
        }
        this.saldo += valor;
        return this.saldo;
    }

    public double sacar(double valor){
        if(valor > saldo){
            throw new RegraNegocioException("Não é possível sacar um valor maior que o saldo da conta");
        }
        this.saldo -= valor;
        return this.saldo;
    }

    public double pagarMensal(double valor){
        return 0.0;
    }

    public Enum getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContaBanco that = (ContaBanco) o;
        return numConta == that.numConta;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numConta);
    }

    @Override
    public String toString() {
        return String.format("ContaBanco" + "\n" + "numConta = " + numConta + " tipo = " + tipo + " dono = '" + dono + '\'' +  " saldo = " + saldo + " status = " + status );
    }
}
