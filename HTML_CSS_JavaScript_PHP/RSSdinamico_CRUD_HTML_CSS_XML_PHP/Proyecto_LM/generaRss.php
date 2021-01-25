<?php
    $bdd = new mysqli("localhost:3306","root","root","proyecto_lm");
    if (mysqli_connect_errno()) {
        echo "Error: No se pudo conectar a MariaDB.<br/>errno de depuración: " . mysqli_connect_errno() . "<br/>error de depuración: " . mysqli_connect_error();
        exit;
    }
    $limite = $_POST["numNot"];
    $resultado = $bdd->query("SELECT * FROM noticias ORDER BY 5 DESC, 6 DESC LIMIT $limite");

    if($resultado->num_rows > 0) {
        $cadena = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>
<rss version=\"2.0\">
    <channel>
        <title>Equipo1</title>
        <link>http://equipo1rssdinamico.freevar.com/</link>
        <description>RSS equipo 1 LDM</description>";

        while($fila = $resultado->fetch_assoc()) {
            $cadena = $cadena . "
        <item>
            <category>" . $fila["seccion"] . "</category>
            <title>" . $fila["titulo"] . "</title>
            <author>" . $fila["autor"] . "</author>
            <pubDate>" . $fila["fecha"] . ", " . $fila["hora"] . "</pubDate>
        </item>";
        }
        $cadena = $cadena . "
    </channel>
</rss>";
    } else {
        echo "La consulta no se ha ejecutado correctamente.";
    }
    file_put_contents("rss.xml", $cadena);
    header("location: rss.xml");
    $bdd->close();
?>
