function filtrarTabla() {
    let input = document.getElementById("buscar").value.toLowerCase();
    let filas = document.querySelectorAll("#tablaVentas tbody tr");

    filas.forEach(fila => {
        let texto = fila.innerText.toLowerCase();
        fila.style.display = texto.includes(input) ? "" : "none";

    });
}