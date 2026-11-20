package org.guilherme.ifsp.exercises.TreinoPOO.Basic.ContaBanco;


import java.util.Objects;

public class ContaBanco {
    private final int numConta;
    protected TipoConta tipo;
    private final String dono;
    private double saldo;
    private boolean status;


    public ContaBanco(int numConta, String dono, TipoConta tipo, double saldo) {
        this.numConta = numConta;
        this.dono = dono;
        this.tipo =  tipo;
        this.saldo = 0;
        this.status = false;
    }

    public void abrirConta(){
        if(this.status){
            throw new RegraNegocioException("Essa conta já existe");
        }
        this.status = true;
    }

    public void fecharConta(){
        if(!this.status){
            throw new RegraNegocioException("A conta já esta fechada");
        }
        if(saldo != 0){
            throw new RegraNegocioException("Não é possível fechar conta com saldo disponível. Favor sacar todo o saldo");
        }
        this.status = false;
    }

    public void depositar(double valor){
        if(!this.status){
            throw new RegraNegocioException("Sua conta não foi aberta");
        }
        if(valor <= 0){
            throw new RegraNegocioException("O valor do depósito deve ser maior que 0");
        }
        this.saldo += valor;
    }

    public double sacar(double valor){
        if(!status){
            throw new RegraNegocioException("Conta não existe");
        }
        if(valor <= 0){
            throw new RegraNegocioException("O valor de saque deve ser maior que 0");
        }
        if(valor > saldo){
            throw new RegraNegocioException("Não é possível sacar um valor maior que o saldo da conta");
        }
        this.saldo -= valor;
        return this.saldo;
    }

    public void pagarMensal(){
        if (!this.status) {
            throw new RegraNegocioException("Não é possível cobrar mensalidade de uma conta fechada.");
        }
    }

    public TipoConta getTipo() {
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
