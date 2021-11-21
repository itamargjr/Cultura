/*	Máscaras Baseadas no Evento "oninput" do js passando-se apenas
*	o Objeto via html ex:. "oninput='FuncaoDesejadaDeMascara(this)'";
*	Contudo, o Primefaces so aceita se usar o método "onfocus".
*	Por trás do código foi implementado o "oninput".
*
*	Máscaras criadas usando Regex(Expressões Regulares)
*/

//Função para sobrescrever e tirar a mascara atual
function SemMascara(sem){
	sem.oninput = function(){
		//Metodo para resetar Evento
	}
}

// Cria uma Máscara de CPF 9999.99.99
function ClassFiscal(classFiscal){
  classFiscal.oninput = function(){
  	classFiscal.value = classFiscal.value
      .replace(/\D/g, '')
      .replace(/^(\d{4})(\d)/, "$1.$2")
      .replace(/(\.\d{2})(\d)/, "$1.$2")
      .replace(/(\.\d{2})\d+?$/, "$1");
  }
}

//Cria uma Máscara de Cep 99999-999
function Cep(cep){
	cep.oninput = function(){
		cep.value = cep.value
	  	.replace(/\D/g, '')
	    .replace(/(\d{5})(\d)/, "$1-$2")
	    .replace(/(-\d{3})\d+?$/, "$1");
	}
}

// Cria uma Máscara de CNPJ 99.999.999/9999-99
function Cnpj(cnpj){
	cnpj.oninput = function(){
  	cnpj.value = cnpj.value
    	.replace(/\D/g, '')
      .replace(/(\d{2})(\d)/, "$1.$2")
      .replace(/(\d{3})(\d)/, "$1.$2")
      .replace(/(\d{3})(\d)/, "$1/$2")
      .replace(/(\d{4})(\d{1,2})/, "$1-$2")
      .replace(/(-\d{2})\d+?$/, "$1");
  }
}

// Cria uma Máscara de CPF 999.999.999-99
function Cpf(cpf){
  cpf.oninput = function(){
  	cpf.value = cpf.value
      .replace(/\D/g, '')
      .replace(/(\d{3})(\d)/, "$1.$2")
      .replace(/(\d{3})(\d)/, "$1.$2")
      .replace(/(\d{3})(\d{1,2})/, "$1-$2")
      .replace(/(-\d{2})\d+?$/, "$1");
  }
}

// Cria uma Máscara de Data 31/12/2999
function Data(data){
	data.oninput = function(){
		data.value = data.value
			.replace(/\D/g, '')
			.replace(/^[4-9]/, "");

    if(data.value[0] == '3'){
      data.value = data.value
        .replace(/(\d)[2-9]?/, "$1")
        .replace(/(\d{2})[2-9]?/, "$1");
    }

		data.value = data.value
    	.replace(/(\d{2})(\d)/, "$1/$2");

    if(data.value[3] == '1'){
      data.value = data.value
      	.replace(/(\/\d)[3-9]?/, "$1");
    }

		data.value = data.value
			.replace(/(\/\d{2})[3-9]?/, "$1")
			.replace(/(\d{2})(\d)/, "$1/$2")
      .replace(/(\/\d{4})\d+?$/, "$1");
  }

  data.onkeydown = function(e){
    if(data.selectionEnd != data.value.length){
    	if(e.keyCode == 8 || e.keyCode == 46){
				data.select();
    	}
    }
	}
}

// Cria uma Máscara de Letras Maiusculas Generica
function StringMaiuscula(letraM, limite){
	if(limite != -1){
		letraM.maxLength = limite;
	}
	
	letraM.oninput = function(){
		letraM.value = letraM.value.toUpperCase();
	}
}

function StringMinuscula(letraM, limite){
	if(limite != -1){
		letraM.maxLength = limite;
	}

  	letraM.oninput = function(){
  		letraM.value = letraM.value.toLowerCase();
  	}
}


// Cria uma Máscara de Letras Maiusculas com limite definido
function LetraMaiusculaLimite(letraM, limite, espaco){
	if(limite != -1){
		letraM.maxLength = limite;
	}
  letraM.oninput = function(){
  	letraM.value = letraM.value
  		.replace(/[0-9]/g, "")
  		.replace(/[_]/g, "")
    	.replace(/([\u0300-\u036f]|[^0-9a-zA-Z\s])/g, '').toUpperCase()

    if(espaco == false){
    	letraM.value = letraM.value
    		.replace(/\W/g, '')
    }
  }
}

// Cria uma Máscara de Letras Minusculas com limite definido
function LetraMinusculaLimite(letraM, limite, espaco){
	if(limite != -1){
		letraM.maxLength = limite;
	}
  letraM.oninput = function(){
  	letraM.value = letraM.value
  		.replace(/[0-9]/g, "")
  		.replace(/[_]/g, "")
    	.replace(/([\u0300-\u036f]|[^0-9a-zA-Z\s])/g, '').toLowerCase()

    if(espaco == false){
    	letraM.value = letraM.value
    		.replace(/\W/g, '')
    }
  }
}

// Cria uma Máscara de Moeda ~999.999,99
function Moeda(moeda){
  moeda.oninput = function(){
  	let i;
    const v = ((moeda.value.replace(/\D/g, '') / 100).toFixed(2) + '').split('.');

    const m = v[0].split('').reverse().join('').match(/.{1,3}/g);

    for (i = 0; i < m.length; i++)
    	m[i] = m[i].split('').reverse().join('') + '.';

    const r = m.reverse().join('');

    moeda.value = r.substring(0, r.lastIndexOf('.')) + ',' + v[1];
  }
}

// Cria uma Máscara de Numérico Inteiro 99999999~, se limite == -1 limite e infinito.
function NumericoInteiroLimite(numero, limite){
	numero.maxLength = limite;

	numero.oninput = function(){
  	numero.value = numero.value
    	.replace(/\D/g, '')
  }
}

// Cria uma Máscara com duas casas decimais, separados por ponto. Aceita numeros negativos.
function Numerico2Casas(num){
	num.oninput = function(){
		sinal = false;

		if(num.value == "0.0" || num.value == "-0.0"){
			num.value = "";
		} else {
			if(num.value[0] == "-"){
				num.value[0] = "";
				sinal = true;
			}

			let stringTratada = num.value.replace(/\D/g ,"");
			let v = ((stringTratada / 100).toFixed(2)).split('.');

			if(sinal){
				num.value = "-" + v[0] + "." + v[1];
			} else {
				num.value = v[0] + "." + v[1];
			}
		}
	}
}

// Cria uma Máscara com tres casas decimais, separados por ponto. Aceita numeros negativos.
function Numerico3Casas(num){
	num.oninput = function(){
		sinal = false;

		if(num.value == "0.0" || num.value == "-0.0"){
			num.value = "";
		} else {
			if(num.value[0] == "-"){
				num.value[0] = "";
				sinal = true;
			}

			let stringTratada = num.value.replace(/\D/g ,"");
			let v = ((stringTratada / 1000).toFixed(3)).split('.');

			if(sinal){
				num.value = "-" + v[0] + "." + v[1];
			} else {
				num.value = v[0] + "." + v[1];
			}
		}
  }
}

// Cria uma Máscara de Pis/Pasep 999.99999.99-9
function PisPasep(pp) {
	pp.oninput = function(){
		pp.value = pp.value
		.replace(/\D/g, "")
		.replace(/^(\d{3})(\d)/, "$1.$2")
		.replace(/^(\d{3})\.(\d{5})(\d)/, "$1.$2.$3")
		.replace(/(\d{3})\.(\d{5})\.(\d{2})(\d)/, "$1.$2.$3-$4")
		.replace(/(\d{3})\.(\d{5})\.(\d{2})-(\d)\d+?$/, "$1.$2.$3-$4");
	}
}

// Cria uma Máscara de RG 99.999.999-9
function RG(rg){
	rg.oninput = function(){
  	rg.value = rg.value
    	.replace(/\D/g, '')
      .replace(/(\d{2})(\d)/, "$1.$2")
      .replace(/(\d{3})(\d)/, "$1.$2")
      .replace(/(\d{3})(\d)/, "$1-$2")
      .replace(/(-\d)\d+?$/, "$1");
  }
}

// Cria uma Máscara de Telefone Fixo (99)9999-9999
function TelFixo(tel){
	tel.oninput = function(){
    tel.value = tel.value
    	.replace(/\D/g, '')
      .replace(/(\d)/,"($1")
      .replace(/(\d{2})(\d)/, "$1)$2")
			.replace(/(\d{4})(\d)/, "$1-$2")
      .replace(/(-\d{4})\d+?$/, "$1");
  }
}

// Cria uma Máscara de Telefone Cel (99)9999-9999
function TelCel(tel){
  tel.oninput = function(){
    tel.value = tel.value
    	.replace(/\D/g, '')
      .replace(/(\d)/,"($1")
      .replace(/(\d{2})(\d)/, "$1)$2")
      .replace(/(\d{5})(\d)/, "$1-$2")
      .replace(/(-\d{4})\d+?$/, "$1");
  }
}

// Cria uma Máscara de Tempo 99:99
function Tempo(tempo){
  tempo.oninput = function(){
    tempo.value = tempo.value
    	.replace(/\D/g, '')
      .replace(/(\d{2})(\d)/, "$1:$2")
      .replace(/(:\d{2})\d+?$/, "$1");
  }
}

// Cria uma Máscara de Tempo com Limite de 29 horas e 99 Minutos
function TempoLimite24(tempo24){
  tempo24.oninput = function(){
    tempo24.value = tempo24.value
    	.replace(/\D/g, '')
      .replace(/^[3-9]/, "")
      .replace(/(\d{2})/, "$1")
      .replace(/(\d{2})/, "$1")
      .replace(/(\d{2})(\d)/, "$1:$2")
      .replace(/(:\d{2})\d+?$/, "$1");
  }
}
