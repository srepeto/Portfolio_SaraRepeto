<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
		<link rel="stylesheet" href="stylesheets/main.css">
		<link rel="stylesheet" href="stylesheets/formularios.css">
        <link rel="stylesheet" href="stylesheets/final.css">
		<title>Modificar noticias</title>
	</head>
	<body>
		<header>
			<h1 class="titulo">Gestión de un RSS dinámico</h1>
		</header>
		<main>
			<div id="resultado">
                <?php
                    $bdd = new mysqli("localhost:3306","root","root","proyecto_lm");
                    if (mysqli_connect_errno()) {
                        echo "Error: No se pudo conectar a MariaDB.<br/>errno de depuración: " . mysqli_connect_errno() . "<br/>error de depuración: " . mysqli_connect_error();
                        exit;
                    }
                    $cod = $_POST["id"];
                    if(isset($_POST["introduce"]) || isset($_POST["modifica"])) {
                        $sec = $_POST["seccion"];
                        $tit = $_POST["titulo"];
                        $aut = $_POST["autor"];
                        $fec = strtotime($_POST["fecha"]);
                        $fecha = date('Y-m-d',$fec);
                        $hor = strtotime($_POST["hora"]);
                        $hora = date('H:i',$hor);
						$archivo = "noticias/" . $cod . ".html";
                        if(isset($_POST["introduce"])) {
                            $bdd->query("INSERT INTO noticias VALUES ('$cod','$sec','$tit','$aut','$fecha','$hora')");
                            if($bdd->affected_rows === 1 && move_uploaded_file($_FILES["noticia"]["tmp_name"],$archivo)) {
                                echo "Registro insertado correctamente";
                            } else {
                                echo "La consulta no se ha ejecutado correctamente.";
                            }
                        } elseif(isset($_POST["modifica"])) {
                            $bdd->query("UPDATE noticias SET seccion = '$sec',titulo = '$tit',autor = '$aut',fecha = '$fecha',hora = '$hora' WHERE id = '$cod'");
                            if($bdd->affected_rows === 1 && move_uploaded_file($_FILES["noticia"]["tmp_name"],$archivo)) {
                                echo "Registro modificado correctamente";
                            } else {
                                echo "La consulta no se ha ejecutado correctamente.";
                            }
                        }
                    } elseif(isset($_POST["consulta"])) {
                        $resultado = $bdd->query("SELECT * FROM noticias WHERE id = '$cod'");
                        if($resultado->num_rows === 1) {
                            $fila = $resultado->fetch_assoc();
							header("location: noticias/" . $cod . ".html");
                            echo $fila["titulo"] . $fila["seccion"] . $fila["autor"] . $fila["fecha"] . $fila["hora"];
                        } else {
                            echo "La consulta no se ha ejecutado correctamente.";
                        }
                    } elseif(isset($_POST["borra"])) {
                        $bdd->query("DELETE FROM noticias WHERE id = '$cod'");
                        if($bdd->affected_rows === 1) {
                            echo "Se ha eliminado correctamente.";
                        } else {
                            echo "La consulta no se ha ejecutado correctamente.";
                        }
                    }
                    $bdd->close();
                ?>
            </p>
        </main>
        <input type="button" id="volver" onclick="window.location.href = 'index.html'" value="Página principal"/>
    </body>
</html>
