/**
 * 
 */
 
 function validarConteiner(){
	let numero = frmConteiner.numero.value;
	let cliente = frmConteiner.cliente.value;
	
	if (numero === ""){
		alert('Campo Numero é obrigatorio');
		frmConteiner.numero.focus();
		return false;
	}
	else if (cliente === ""){
		alert('Campo Cliente é obrigatorio');
		frmConteiner.cliente.focus();
		return false;
	}
	else{
		document.forms["frmConteiner"].submit();
	}
}

 function validarMov(){
	let numero = frmMov.numero.value;
	let inicio = frmMov.inicio.value;
	let fim = frmMov.fim.value;
	
	if (numero === ""){
		alert('Campo Numero é obrigatorio');
		frmCMov.numero.focus();
		return false;
	}
	else if (inicio === ""){
		alert('Campo Inicio é obrigatorio');
		frmMov.inicio.focus();
		return false;
	}
	else if (fim === ""){
		alert('Campo Fim é obrigatorio');
		frmMov.inicio.focus();
		return false;
	}
	else{
		document.forms["frmMov"].submit();
	}
}