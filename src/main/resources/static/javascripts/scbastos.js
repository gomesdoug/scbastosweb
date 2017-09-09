
//funcao para mascara decimal
$(function(){
	
	var decimal = $('.js-decimal');
	decimal.maskMoney();
	
	var inteiro = $('.js-inteiro');
	inteiro.maskMoney({thousands:'',decimal:''});
	
	var cep = $('.jsmask-cep');
	cep.mask("99999-999");
	
	var cpf = $('.jsmask-cpf');
	cpf.mask("999.999.999-99");
	
	var celular = $('.jsmask-celular');
	celular.mask("(99) 99999-9999");
	
	var telFixo = $('.jsmask-telFixo');
	telFixo.mask("(99) 9999-9999");
	
});

//$(".alpha-only").on("input", function(){
//	  var regexp = /[^a-zA-Z]/g;
//	  if($(this).val().match(regexp)){
//	    $(this).val( $(this).val().replace(regexp,'') );
//	  }
//	});







