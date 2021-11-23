/**
 * 
 */


const inputValue = document.getElementById("inputValue");
const btnBuscar = document.getElementById("btnSetInput");
const value = document.getElementById("valor");


let salario = localStorage.getItem("salario");
if (salario > 0) {
	value.innerText = salario;

} else {
	value.innerText = "1200";
}

btnBuscar.addEventListener("click", () => {

	if (inputValue.value > 0 ) {
		window.location.href = `http://localhost:8081/proyectos/reporte4/${inputValue.value}`;
		localStorage.setItem("salario", inputValue.value);
	}
})

