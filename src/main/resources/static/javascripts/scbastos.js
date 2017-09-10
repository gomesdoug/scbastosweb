
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

//function calcular(){
//    var valor1 = parseFloat(document.getElementById('valorimovel').value, 10);
//    var valor2 = parseFloat(document.getElementById('sinal').value, 10);
//    
//    subtracao = valor1 - valor2;
//   
//    document.getElementById('saldoDevedor').value= subtracao;
//}



//function id( el ){
//    return document.getElementById( el );
//}
//function getMoney( el ){
//    var money = id( el ).value.replace( '.', ',' );
//    return parseFloat( money )*100;
//}
//function saldoDevedor()
//{
//    var total = getMoney('valorimovel') - getMoney('sinal');
//    id('saldoDevedor').value = total/100;
//}







