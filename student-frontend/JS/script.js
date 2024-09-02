// Máscara para o campo de telefone
$("#telefone").mask("(99) 9999-99999");

// Array para armazenar os alunos
var students = [];

var course = [];

//Ao carregar a página, carregar os estudantes
loadStudents();
loadCourses();


//Load all courses
function loadCourses() { //Carregamento de cursos na tabela
    $.ajax({
        url: "http://localhost:8080/courses", //AJAX para chamadas Síncronas
        type: "GET",
        async: false, //Chamada síncrona ---- Uma por vez
        success: (response) => { // Requisição JSON $
            courses = response;
            for (var cour of courses) {
                document.getElementById("curso").innerHTML += `<option value= ${cour.id}>${cour.name}</option>`;
            }
        }
    });
}

    function loadStudents() { //Carregamento dos alunos na tabela
    $.getJSON("http://localhost:8080/students", (response) => {
        students = response;
        for (let stud of students) {
            addNewRow(stud);
        }

    });

}

// Função para salvar um novo aluno
function save() {

    var stud = {
        id: students.length + 1, // Definindo um ID único para cada aluno
        name: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('telefone').value,
        idCurso: parseInt(document.getElementById('curso').value),
        periodo: parseInt(document.querySelector('input[name="turnoSelect"]:checked').value) // Obtendo o valor do turno selecionado
    };
$.ajax({ 
    url: "http://localhost:8080/students",
    type: "POST",
    contentType: "application/json", //Servidor
    data: JSON.stringify(stud),
    async: true,
    success: (student) => {

        addNewRow(student);
        students.push(student);

        document.getElementById('formAlunos').reset();
    }
});
}

// Função para adicionar uma nova linha na tabela de alunos
function addNewRow(stud) {
    var tableBody = document.getElementById('alunosTableBody');
    var newRow = tableBody.insertRow();

    // Preenchendo as células com os valores do aluno
    newRow.insertCell().textContent = stud.id;
    newRow.insertCell().textContent = stud.name;

    // Email
    var cell = newRow.insertCell();
    cell.textContent = stud.email;
    cell.className = "d-none d-md-table-cell";

    // Telefone
    var cell = newRow.insertCell();
    cell.textContent = stud.phone;
    cell.className = "d-none d-md-table-cell";

    // Curso
    var cursoText = "";
    if (stud.idCurso === 1) {
        cursoText = "Angular";
    } else if (stud.idCurso === 2) {
        cursoText = "Bootstrap";
    } else if (stud.idCurso === 3) {
        cursoText = "Git/GitHub";
    }
    
    var cell = newRow.insertCell();
    cell.textContent = cursoText;
    cell.className = "d-none d-md-table-cell";

    // Turno
    var periodoText = "";
    switch (stud.periodo) { //Verifica o tipo de valor recebido
        case 1:
            periodoText = "Manhã";
            break;
        case 2:
            periodoText = "Tarde";
            break;
        case 3:
            periodoText = "Noite";
            break;
    }

    var cell = newRow.insertCell();
    cell.textContent = periodoText;// inserir o turno na tabela
    cell.className = "d-none d-md-table-cell";
}
