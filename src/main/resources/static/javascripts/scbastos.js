
//funcao para mascara decimal
$(function(){
	
	var decimal = $('.js-decimal');
	decimal.maskMoney();
	
	var inteiro = $('.js-inteiro');
	inteiro.maskMoney({thousands:'',decimal:''});
	
	var cep = $('.jsmask-cep');
	cep.mask("99999-999");
	
});

//$(".alpha-only").on("input", function(){
//	  var regexp = /[^a-zA-Z]/g;
//	  if($(this).val().match(regexp)){
//	    $(this).val( $(this).val().replace(regexp,'') );
//	  }
//	});