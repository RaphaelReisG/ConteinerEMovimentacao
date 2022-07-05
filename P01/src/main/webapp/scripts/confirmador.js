/**
 * 
 */
 
 function confirmarConteiner(numero){
	let resposta = confirm("Tem certeza que quer exclluir o conteiner?");
	if(resposta === true){
		//alert(id);
		window.location.href = "deleteConteiner?numero=" + numero;
	}
	
}

 function confirmarMov(id){
	let resposta = confirm("Tem certeza que quer exclluir a movimentacao?");
	if(resposta === true){
		//alert(id);
		window.location.href = "deleteMov?id=" + id;
	}
	
}

 function teste(id){
	alert('Opa');
}