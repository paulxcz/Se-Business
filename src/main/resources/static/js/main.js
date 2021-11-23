/**
 * 
 */  
	
  window.onload = function(){
	
  let fecha = new Date(); //Fecha actual
  let mes = fecha.getMonth()+1; //obteniendo mes
  let dia = fecha.getDate(); //obteniendo dia
  let anio = fecha.getFullYear(); //obteniendo año
  if(dia<10)
    dia='0'+dia; //agrega cero si el menor de 10
  if(mes<10)
    mes='0'+mes //agrega cero si el menor de 10
  document.getElementById('dateContrato').value=anio+"-"+mes+"-"+dia;

  let fecha2 = new Date(); //Fecha actual
  let mes2 = fecha2.getMonth()+1; //obteniendo mes
  let dia2 = fecha2.getDate()+5; //obteniendo dia
  let anio2 = fecha2.getFullYear(); //obteniendo año
  if(dia2<10)
    dia2='0'+dia2; //agrega cero si el menor de 10
  if(mes2<10)
    mes2='0'+mes2 //agrega cero si el menor de 10
  document.getElementById('fechaCulminacionEstimada').min=anio2+"-"+mes2+"-"+dia2;
  document.getElementById('fechaCulminacionEstimada').value=anio2+"-"+mes2+"-"+dia2;

 }

