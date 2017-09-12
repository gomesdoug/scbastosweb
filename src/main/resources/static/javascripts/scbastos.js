
//funcao para mascara decimal
/*$(function(){
	
	var decimal = $('.js-decimal');
	decimal.maskMoney({decimal:',',thousands:'.'});
	
	var inteiro = $('.js-inteiro');
	inteiro.maskMoney({precision: 0, decimal:'',thousands:''});
	
	var cep = $('.jsmask-cep');
	cep.mask("99999-999");
	
	var cpf = $('.jsmask-cpf');
	cpf.mask("999.999.999-99");
	
	var celular = $('.jsmask-celular');
	celular.mask("(99) 99999-9999");
	
	var telFixo = $('.jsmask-telFixo');
	telFixo.mask("(99) 9999-9999");
	
	
});*/

/*NAMESPACE PARA SCBASTOSWEBB*/

var scbastosweb = scbastosweb || {};

/*MASCARA PARA VALORES MONETARIOS e INTEIROS*/

scbastosweb.MaskMoney = (function() {
	
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.inteiro = $('.js-inteiro');
	}
	
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.inteiro.maskMoney({ precision: 0, decimal:'',thousands:''});
	}
	
	return MaskMoney;
	
}());

/* MASCARA PARA CEP e CPF*/

scbastosweb.Mask = (function(){

function Mask(){
	
	this.cep = $('.jsmask-cep');
	this.cpf = $('.jsmask-cpf');
	//this.celular = $('.jsmask-celular');
	//this.telefonefixo = $('.jsmask-telFixo');
}

Mask.prototype.enable = function(){
	
	this.cep.mask("99999-999");
	this.cpf.mask("999.999.999-99");
	//this.celular("(99) 99999-9999");
	//this.telefonefixo("(99) 9999-9999");
}

return Mask;

}());



/*MASCARA PARA NUMEROS DE TELEFONE*/

scbastosweb.MaskPhoneNumber = (function() {
	
	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}
	
	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};
		
		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};
		
		this.inputPhoneNumber.mask(maskBehavior, options);
	}
	
	return MaskPhoneNumber;
	
}());



/*CHAMADA DAS FUNCOES*/

$(function() {
	var maskMoney = new scbastosweb.MaskMoney();
		maskMoney.enable();
	
	var mask = new scbastosweb.Mask()
		mask.enable();
	
	var maskPhoneNumber = new scbastosweb.MaskPhoneNumber();
		maskPhoneNumber.enable();
});








