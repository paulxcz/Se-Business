/**
 * 
 */


window.onload = function() {
	let fecha = new Date(); //Fecha actual
	let mes = fecha.getMonth() + 1; //obteniendo mes
	let dia = fecha.getDate() + 5; //obteniendo dia
	let anio = fecha.getFullYear(); //obteniendo año
	if (dia < 10)
		dia = '0' + dia; //agrega cero si el menor de 10
	if (mes < 10)
		mes = '0' + mes //agrega cero si el menor de 10
	document.getElementById('fechaCulminacionEstimada').min = anio + "-"
		+ mes + "-" + dia;
	document.getElementById('fechaCulminacionEstimada').value = anio + "-"
		+ mes + "-" + dia;
}