/* Se o valor dado ao 'img' == null o valor é trocado por 'img' == ERRO, com isso 
 * a função substitui por um p == uma msg */
function ImagemErro(imagem){
	if(imagem == "ERRO"){
		let imgErro = document.getElementById('ERRO');
		let p = document.createElement('p');
		p.innerHTML = "<b>Sem Imagem</b>";
		imgErro.parentNode.replaceChild(p, imgErro);
	}
}

/* Se o valor do codigo da imagem != undefined a função retorna um p vazio
 * Se o valor do codigo da imagem == undefined a funçãoe retorna um p com uma msg*/
function AusenciaImagem(objeto, codImagem){
	if(codImagem == undefined){
		let p = document.createElement('p');
		p.innerHTML = "";
		objeto.parentNode.replaceChild(p, objeto);
	}else{
		let p = document.createElement('p');
		p.innerHTML = "<b>Sem Imagem</b>";
		objeto.parentNode.replaceChild(p, objeto);
	}
}
