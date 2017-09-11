
//funcao para mascara decimal
$(function(){
	
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
	
	
});








