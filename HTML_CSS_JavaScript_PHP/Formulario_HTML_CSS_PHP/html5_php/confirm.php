<?php

$DNI = ($_POST['DNI']);
$nombre = ($_POST['Nombre']);
$apellidos = ($_POST['Apellidos']);
$fechaNac = ($_POST['FechaNac']);
$domicilio = ($_POST['Domicilio']);
$codPostal = ($_POST['CodPostal']);
$provincia = ($_POST['Provincia']);
$telefono = ($_POST['Telefono']);
$email = ($_POST['Email']);
$comentario = ($_POST['Comentario']);
$digBanco = ($_POST['Banco']);
$digSucursal = ($_POST['Sucursal']);
$digControl = ($_POST['DigitosControl']);
$digCuenta = ($_POST['NumeroCuenta']);
$enviar = ($_POST['enviar']);

// -------------------------------------------

$errorVacio = false;
$errorPostal = false;
$errorTelf = false;
$errorEmail = false;
$errorFecha = false;
$errorCuenta = false;
$errorDNI = false;

// -------------------------------------------

if (empty($DNI) || empty($nombre) || empty($apellidos) || empty($fechaNac) || empty($domicilio) || empty($codPostal) || empty($provincia) || empty($telefono) || empty($email) || empty($comentario) || empty($digBanco) || empty($digSucursal) || empty($digControl) || empty($digCuenta)) {
    $errorVacio = true;
}

// -------------------------------------------

$codPostalLong = strlen($codPostal);

if ($codPostalLong != 5) {
    $errorPostal = true;
}

// -------------------------------------------

$telefonoLong = strlen($telefono);

if ($telefonoLong != 9) {
    $errorTelf = true;
}

// -------------------------------------------

if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    $errorEmail = true; 
}

// -------------------------------------------
 
$dateExploded = explode("/", $fechaNac);
 
if(count($dateExploded) != 3){
    $errorFecha = true;
}
 
$month = $dateExploded[1];
$day = $dateExploded[0];
$year = $dateExploded[2];

if (strlen($month) != 2 || strlen($day) != 2) {
    $errorFecha = true;
}

if (strlen($year) != 4) {
    $errorFecha = true;
}
 
if(!checkdate($month, $day, $year)){
    $errorFecha = true;
}

// -------------------------------------------

// Cuenta de ejemplo: ES85 2098 0008 64 1207383832

    $digCont1=0;
    $digCont2=0;
    $x;
    $y=0;
    $constantes = array(1,2,4,8,5,10,9,7,3,6);

    for ($x=2; $x<=5; $x++) {
        $digCont1= $digCont1 + $constantes[$x] * (intval(strval($digBanco[$y])));
        $y++;
    }

    $y=0;

    $largoConst = count($constantes);

    for ($x=6; $x<$largoConst; $x++) {
        $digCont1= $digCont1 + $constantes[$x] * (intval(strval($digSucursal[$y])));
        $y++;
    }
    $digCont1 = 11-($digCont1%11);

    if ($digCont1 == 10) {
        $digCont1 = 1;
    } else if ($digCont1 == 11){
        $digCont1 = 0;
    }

    $y=0;
    for ($x=0; $x<$largoConst; $x++) {
        $digCont2= $digCont2 + $constantes[$x] * (intval(strval($digCuenta[$y])));
        $y++;
    }
    $digCont2 = 11-($digCont2%11);

    if ($digCont2 == 10) {
        $digCont2 = 1;
    } else if ($digCont2 == 11){
        $digCont2 = 0;
    }

    $fdigControl = strval($digCont1) . strval($digCont2);
    $fdigControl = intval($fdigControl);

    if ($fdigControl!=$digControl) {
        $errorCuenta = true;
    }

// -------------------------------------------

$digTotal = $digBanco . $digSucursal . $digControl . $digCuenta . 142800;
$longDigTotal = strlen($digTotal);

$m = 0;
$fdigIBAN;
$fdigitosIBAN;
for ($i = 0; $i < $longDigTotal; $i++) {
    $m = ($m * 10 + intval(strval($digTotal[$i]))) % 97;
}
$fdigIBAN = 98-$m;

if (($fdigIBAN>=0) && ($fdigIBAN<=9)) {
    $fdigitosIBAN = "0" . strval($fdigIBAN);
} else {
    $fdigitosIBAN = strval($fdigIBAN);
}

// -------------------------------------------

    $letra = substr($DNI, -1);
    $numeros = substr($DNI, 0, -1);
    $valido;
    if (substr("TRWAGMYFPDXBNJZSQVHLCKE", $numeros%23, 1) == $letra && strlen($letra) == 1 && strlen ($numeros) == 8 ){
      $errorDNI = false;
    }else{
        $errorDNI = true;
    }

// -------------------------------------------

if (isset($enviar)) {
    
    if ($errorVacio) {
        echo "Hay campos vacios - ";
    }

    if ($errorPostal) {
        echo "Código Postal incorrecto - ";
    }

    if ($errorTelf) {
        echo "Telefono incorrecto - ";
    }

    if ($errorEmail) {
        echo "Email incorrecto - ";
    }
    if ($errorFecha) {
        echo "Fecha de nacimiento incorrecta - ";
    }

    if ($errorDNI) {
        echo "DNI incorrecto - ";
    }

    if ($errorCuenta) {
        echo "La cuenta es incorrecta - ";
    }

    if (!$errorVacio && !$errorPostal && !$errorTelf && !$errorEmail && !$errorFecha && !$errorDNI && !$errorCuenta) {
        echo "Formulario completado correctamente - IBAN: ES" . $fdigitosIBAN . " - Hora del envío: " . date('H:i');
    }

    if ($errorVacio || $errorPostal || $errorTelf || $errorEmail || $errorFecha || $errorDNI || $errorCuenta) {
        echo "<a href=\"javascript:history.go(-1)\">vuelve a rellenar el formulario desde lo dejaste</a>" . " o " . "<a href=\"index.html\">vuelve a rellenarlo desde el principio</a>";;
        //Para lo que pide el enunciado realmente sólo habría que poner esto dentro del isset($enviar) --> header("Location: index.html");
    }

}


?>
