package com.simplesdental.models;

import java.util.Date;

import com.simplesdental.models.enums.StatusContaBancaria;
import com.simplesdental.models.enums.TipoContaBancaria;
import com.simplesdental.models.enums.TipoTitularContaBancaria;

public class ContaBancaria {
	public Integer Id;
	public String DigitoAgencia;
	public String DigitoConta;
	public String DescricaoStatus;
	public Boolean EmitirComprovante;
	public Integer CodigoBanco;
	public String CodigoAgencia;
	public String NumeroConta;
	public String Descricao = "";
	public Boolean Excluida;
	public String Operacao;
	public Date DataValidadeAprovada;
	public Date DataValidadeSolicitada;
	public StatusContaBancaria Status;
	public TipoContaBancaria TipoConta;
	public TipoTitularContaBancaria TipoTitular;
	public TitularContaBancaria Titular;
}
