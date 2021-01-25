<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
		<link rel="stylesheet" href="stylesheets/main.css">
		<link rel="stylesheet" href="stylesheets/formularios.css">
        <link rel="stylesheet" href="stylesheets/resultado.css">
		<title>Resultado final</title>
	</head>
	<body>
		<header>
			<h1 class="titulo">Gestión de datos de alumnos</h1>
		</header>
		<main>
			<article>
                <div id="result">
                    <?php
                        $bdd = new mysqli("localhost:3306","root","root","EP3T4");
                        if (mysqli_connect_errno()) {
                            echo "Error: No se pudo conectar a MariaDB.<br/>errno de depuración: " . mysqli_connect_errno() . "<br/>error de depuración: " . mysqli_connect_error();
                            exit;
                        }
                        
                        $cod = $_POST['codigo'];

                        if(isset($_POST["introduce"])) {

                            $nom = $_POST['nombre'];
                            $ape = $_POST['apellidos'];
                            $ext = ".jpg";
                            $newname = 'Alumno_'.$cod.$ext; 
                            $target = 'images/'.$newname;

                            $resultado = $bdd->query("SELECT * FROM Alumnos WHERE Codigo = $cod");
                            if($resultado->num_rows === 1) {
                                echo "Error: ya existe un alumno con ese código.";
                            } else {
                                move_uploaded_file( $_FILES['foto']['tmp_name'], $target);
                                $bdd->query("INSERT INTO Alumnos VALUES ('$cod','$nom','$ape',LOAD_FILE ('C:/xampp/htdocs/Proyectos/EP3T4/$target'))");
                                echo "Se ha insertado correctamente";
                            }
                        }

                        if(isset($_POST["botonBorrar"])) {
                            $bdd->query("DELETE FROM Alumnos WHERE Codigo = $cod");
                            if($bdd->affected_rows === 1) {
                                echo "Se ha borrado correctamente.";
                            } else {
                                echo "Error: el borrado no ha podido efectuarse correctamente.";
                            }
                        }

                        if(isset($_POST["botonModif"])) {

                            $nom = $_POST['nombre'];
                            $ape = $_POST['apellidos'];
                            $ext = ".jpg";
                            $newname = 'Alumno_'.$cod.$ext; 
                            $target = 'images/'.$newname;

                            $resultado = $bdd->query("SELECT * FROM Alumnos WHERE Codigo = $cod");
                            if($resultado->num_rows === 1) {
                                move_uploaded_file( $_FILES['foto']['tmp_name'], $target);
                                $bdd->query("UPDATE Alumnos SET Nombre='$nom', Apellidos='$ape', Foto=LOAD_FILE ('C:/xampp/htdocs/Proyectos/EP3T4/$target') WHERE Codigo = $cod");
                                echo "Se ha modificado correctamente";
                            } else {
                                echo "Error: no hay ningún alumno con ese código.";
                            }                  

                        }

                        if(isset($_POST["botonCons"])) {
                            $resultado = $bdd->query("SELECT * FROM Alumnos WHERE Codigo = $cod");
                            if($resultado->num_rows === 1) {
                                $reg = $resultado->fetch_assoc();
                                echo "<label>Código:</label> " . $reg["Codigo"] . "<br/><label>Nombre:</label> " . $reg["Nombre"] . "<br/><label>Apellidos:</label> " . $reg["Apellidos"] . "<br/><br/><label>Foto:</label><br/><img src=\"images/Alumno_" . $cod . ".jpg\" />";
                            } else {
                                echo "Error: la consulta no ha podido efectuarse correctamente.";
                            }
                        }

                        $bdd->close();
                    ?>
                </div>
            </article>
        </main>
        <input type="button" id="volver" onclick="window.location.href = 'index.html'" value="Página principal"/>
    </body>
</html>