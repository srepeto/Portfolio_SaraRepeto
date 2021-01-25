

function validateForm (form) {
    var DNI = form.DNI.value;
    var nombre = form.nombre.value;
    var apellidos = form.apellidos.value;
    var fechaNac = form.fechaNac.value;
    var domicilio = form.domicilio.value;
    var codPostal = form.codPostal.value;
    var provincia = form.provincia.value;
    var telefono = form.telefono.value;
    var comentario = form.comentario.value;
    var dig1 = form.dig1.value;
    var dig2 = form.dig2.value;
    var dig3 = form.dig3.value;
    var dig4 = form.dig4.value;

    if (DNI == "" || nombre == "" || apellidos == "" || fechaNac == "" || domicilio == "" || 
        codPostal == "" || provincia == "" || telefono == "" || comentario == "" || dig1 == "" || 
        dig2 == "" || dig3 == "" || dig4 == "") {
        alert("Ha dejado campos sin rellenar");
        return false;
      }

    if (!validatePost()) {
        alert("Código postal incorrecto")
        return false;
    }

    if (!validateTelf()) {
        alert("Teléfono incorrecto")
        return false;
    }

    if (!validateEmail()) {
        alert("Email incorrecto")
        return false;
    }

    if (!validateDate()) {
        alert("Fecha de nacimiento incorrecta")
        return false;
    }

    if (!validateDNI()) {
        alert("DNI incorrecto")
        return false;
    }

    if (!validateCuenta()) {
        alert("Cuenta bancaria incorrecta")
        return false;
    }

    mostrarHora();
}

// --------------------------------------------------------------

function resetear() {
    document.getElementById('identSexo').textContent = "";
    document.getElementById('huecoEsp').textContent = "";
    document.getElementById('huecoFran').textContent = "";
    document.getElementById('huecoIng').textContent = "";
    document.getElementById('huecoAle').textContent = "";
}

// --------------------------------------------------------------

function controlCeros(i) {
    if (i < 10) {
      i = "0" + i;
    }
    return i;
}
  
function mostrarHora() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();

    h = controlCeros(h);
    m = controlCeros(m);
    s = controlCeros(s);

    document.getElementById('hora').value = h + ":" + m + ":" + s;
}

// --------------------------------------------------------------

function validateNombre () {
    if (document.getElementById("nombre").value == "") {
        return false;
    } else {
        return true;
    }
}

document.getElementById("nombre").addEventListener('keyup', function() {
    pintaNombre("nombre");
    }
);
document.getElementById("nombre").addEventListener('focusin', function() {
    pintaNombre("nombre");
    }
);
document.getElementById("nombre").addEventListener('focusout', function() {
    despintaBorde("nombre");
    }
);

function pintaNombre (campo) {
    if (validateNombre())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

function validateApellidos () {
    if (document.getElementById("apellidos").value == "") {
        return false;
    } else {
        return true;
    }
}

document.getElementById("apellidos").addEventListener('keyup', function() {
    pintaApellidos("apellidos");
    }
);
document.getElementById("apellidos").addEventListener('focusin', function() {
    pintaApellidos("apellidos");
    }
);
document.getElementById("apellidos").addEventListener('focusout', function() {
    despintaBorde("apellidos");
    }
);

function pintaApellidos (campo) {
    if (validateApellidos())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

function validateDomicilio () {
    if (document.getElementById("domicilio").value == "") {
        return false;
    } else {
        return true;
    }
}

document.getElementById("domicilio").addEventListener('keyup', function() {
    pintaDomicilio("domicilio");
    }
);
document.getElementById("domicilio").addEventListener('focusin', function() {
    pintaDomicilio("domicilio");
    }
);
document.getElementById("domicilio").addEventListener('focusout', function() {
    despintaBorde("domicilio");
    }
);

function pintaDomicilio (campo) {
    if (validateDomicilio())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

function validateProvincia () {
    if (document.getElementById("provincia").value == "") {
        return false;
    } else {
        return true;
    }
}

document.getElementById("provincia").addEventListener('keyup', function() {
    pintaProvincia("provincia");
    }
);
document.getElementById("provincia").addEventListener('focusin', function() {
    pintaProvincia("provincia");
    }
);
document.getElementById("provincia").addEventListener('focusout', function() {
    despintaBorde("provincia");
    }
);

function pintaProvincia (campo) {
    if (validateProvincia())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

function validateComentario () {
    if (document.getElementById("comentario").value == "") {
        return false;
    } else {
        return true;
    }
}

document.getElementById("comentario").addEventListener('keyup', function() {
    pintaComentario("comentario");
    }
);
document.getElementById("comentario").addEventListener('focusin', function() {
    pintaComentario("comentario");
    }
);
document.getElementById("comentario").addEventListener('focusout', function() {
    despintaBorde("comentario");
    }
);

function pintaComentario (campo) {
    if (validateComentario())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

function textoSexo() {
    if(document.getElementById('hombre').checked) {
        document.getElementById('identSexo').textContent = "Es "+document.getElementById("hombre").value;
    }
    if(document.getElementById('mujer').checked) {
        document.getElementById('identSexo').textContent = "Es "+document.getElementById("mujer").value;
    }
}

// --------------------------------------------------------------

function textoIdiomas() {
    if(document.getElementById('espanol').checked) {
        document.getElementById('huecoEsp').textContent = document.getElementById('espanol').value;;
    } else {
        document.getElementById('huecoEsp').textContent = "";
    }
    if (document.getElementById('frances').checked) {
        document.getElementById('huecoFran').textContent = document.getElementById('frances').value;;
    } else {
        document.getElementById('huecoFran').textContent = "";
    }
    if (document.getElementById('ingles').checked)  {
        document.getElementById('huecoIng').textContent = document.getElementById('ingles').value;;
    } else {
        document.getElementById('huecoIng').textContent = "";
    }
    if (document.getElementById('aleman').checked)  {
        document.getElementById('huecoAle').textContent = document.getElementById('aleman').value;;
    } else {
        document.getElementById('huecoAle').textContent = "";
    }
}

document.getElementById("espanol").addEventListener("change", textoIdiomas);
document.getElementById("frances").addEventListener("change", textoIdiomas);
document.getElementById("ingles").addEventListener("change", textoIdiomas);
document.getElementById("aleman").addEventListener("change", textoIdiomas);

// --------------------------------------------------------------

document.getElementById("DNI").maxLength = "9";

function validateDNI () {
    var dni = document.getElementById("DNI").value;	
    var letraDNI = dni.substring(8, 9);
    var numDNI = parseInt(dni.substring(0, 8));
    
    var letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
    var letraCorrecta = letras[numDNI % 23];
    
    if(numDNI == /\d{8}[a-z A-Z]/){
      return false;
    } else {    
        if(letraDNI.toUpperCase() != letraCorrecta){
        return false;
        } else {
        return true;
        }
    }

}

document.getElementById("DNI").addEventListener('keyup', function() {
    pintaDNI("DNI");
    }
);
document.getElementById("DNI").addEventListener('focusin', function() {
    pintaDNI("DNI");
    }
);
document.getElementById("DNI").addEventListener('focusout', function() {
    despintaBorde("DNI");
    }
);

function pintaDNI (campo) {
    if (validateDNI())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

// Cuenta de ejemplo: ES85 2098 0008 64 1207383832

document.getElementById("dig1").maxLength = "4";
document.getElementById("dig2").maxLength = "4";
document.getElementById("dig3").maxLength = "2";
document.getElementById("dig4").maxLength = "10";

function validateCuenta(){
    var banco = document.getElementById("dig1").value;
    var sucursal = document.getElementById("dig2").value;
    var dc = document.getElementById("dig3").value;
    var cuenta = document.getElementById("dig4").value;
    var CCC = banco+sucursal+dc+cuenta;
    if (!/^[0-9]{20}$/.test(banco+sucursal+dc+cuenta)){
        return false;
    }
    else
    {
        valores = new Array(1, 2, 4, 8, 5, 10, 9, 7, 3, 6);
        control = 0;
        for (i=0; i<=9; i++)
        control += parseInt(cuenta.charAt(i)) * valores[i];
        control = 11 - (control % 11);
        if (control == 11) control = 0;
        else if (control == 10) control = 1;
        if(control!=parseInt(dc.charAt(1))) {
            return false;
        }
        control=0;
        var zbs="00"+banco+sucursal;
        for (i=0; i<=9; i++)
            control += parseInt(zbs.charAt(i)) * valores[i];
        control = 11 - (control % 11);
        if (control == 11) control = 0;
            else if (control == 10) control = 1;
        if(control!=parseInt(dc.charAt(0))) {
            return false;
        }
        CalcularIBAN(CCC);
        return true;
    }
}

function CalcularIBAN(account) {

    var iban = "ES" + "00" + account;
    var code     = iban.substring(0, 2);
    var checksum = iban.substring(2, 4);
    var bban     = iban.substring(4);

    var digits = "";
    for (var i = 0; i < bban.length; ++i)
    {
    var ch = bban.charAt(i).toUpperCase();
    if ("0" <= ch && ch <= "9")
        digits += ch;
    else
        digits += convertirMayusculasNumeros(ch);
    }
    for (var i = 0; i < code.length; ++i)
    {
    var ch = code.charAt(i);
    digits += convertirMayusculasNumeros(ch);
    }
    digits += checksum;

    checksum = 98 - modulo97(digits);

    var IBANfinal = "ES" + rellenarCeros("" + checksum, 2);
    document.getElementById("IBAN").value = "IBAN: "+IBANfinal;
}

function modulo97(digit_string) {
    var m = 0;
    for (var i = 0; i < digit_string.length; ++i)
    m = (m * 10 + parseInt(digit_string.charAt(i))) % 97;
    return m;
}

function convertirMayusculasNumeros(ch) {
    var capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (var i = 0; i < capitals.length; ++i)
    if (ch == capitals.charAt(i))
        break;
    return i + 10;
}

function rellenarCeros(s, l) {
    while (s.length < l)
    s = "0" + s;
    return s;
}


document.getElementById("dig1").addEventListener('keyup', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig1").addEventListener('focusin', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig1").addEventListener('focusout', function() {
    despintaBorde("dig1");
    despintaBorde("dig2");
    despintaBorde("dig3");
    despintaBorde("dig4");
    }
);

document.getElementById("dig2").addEventListener('keyup', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig2").addEventListener('focusin', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig2").addEventListener('focusout', function() {
    despintaBorde("dig1");
    despintaBorde("dig2");
    despintaBorde("dig3");
    despintaBorde("dig4");
    }
);

document.getElementById("dig3").addEventListener('keyup', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig3").addEventListener('focusin', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig3").addEventListener('focusout', function() {
    despintaBorde("dig1");
    despintaBorde("dig2");
    despintaBorde("dig3");
    despintaBorde("dig4");
    }
);

document.getElementById("dig4").addEventListener('keyup', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig4").addEventListener('focusin', function() {
    pintaCuenta("dig1");
    pintaCuenta("dig2");
    pintaCuenta("dig3");
    pintaCuenta("dig4");
    }
);

document.getElementById("dig4").addEventListener('focusout', function() {
    despintaBorde("dig1");
    despintaBorde("dig2");
    despintaBorde("dig3");
    despintaBorde("dig4");
    }
);

function pintaCuenta (campo) {
    if (validateCuenta())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

function validatePost () {
    var codPostal = document.getElementById("codPostal").value;
    codPostal.toString();
    if (codPostal.length == 5) {
        return true;
    }
    return false;
}

document.getElementById("codPostal").addEventListener('keyup', function() {
    pintaPost("codPostal");
    }
);
document.getElementById("codPostal").addEventListener('focusin', function() {
    pintaPost("codPostal");
    }
);
document.getElementById("codPostal").addEventListener('focusout', function() {
    despintaBorde("codPostal");
    }
);

function pintaPost (campo) {
    if (validatePost())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

document.getElementById("telefono").maxLength = "9";

function validateTelf () {
    var telefono = document.getElementById("telefono").value;
    telefono.toString();
    if (telefono.length == 9) {
        return true;
    }
    return false;
}

document.getElementById("telefono").addEventListener('keyup', function() {
    pintaTelf("telefono");
    }
);
document.getElementById("telefono").addEventListener('focusin', function() {
    pintaTelf("telefono");
    }
);
document.getElementById("telefono").addEventListener('focusout', function() {
    despintaBorde("telefono");
    }
);

function pintaTelf (campo) {
    if (validateTelf())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

function validateEmail() {
var mail = document.getElementById("email").value;
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
  {
    return (true)
  }
    return (false)
};

document.getElementById("email").addEventListener('keyup', function() {
    pintaEmail("email");
    }
);
document.getElementById("email").addEventListener('focusin', function() {
    pintaEmail("email");
    }
);
document.getElementById("email").addEventListener('focusout', function() {
    despintaBorde("email");
    }
);

function pintaEmail (campo) {
    if (validateEmail())
        pintaVerde(campo);
    else 
        pintaRojo(campo); 
}

// --------------------------------------------------------------

document.getElementById("fechaNac").maxLength = "10";

    function validateDate() {

        var fechaNac = document.getElementById("fechaNac").value;
        var datePat = /^(\d{2,2})(\/)(\d{2,2})\2(\d{4}|\d{4})$/;
        
        var matchArray = fechaNac.match(datePat);
        if (matchArray == null) {
         return false;
        }
        
        day = matchArray[1];
        month = matchArray[3];
        year = matchArray[4];
        if (year < 1920 || year > 2020) {
            return false;
        }
        if (month < 1 || month > 12) {
         return false;
        }
        if (day < 1 || day > 31) {
         return false;
        }
        if ((month==4 || month==6 || month==9 || month==11) && day==31) {
         return false;
        }
        if (month == 2) { 
         var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
         if (day>29 || (day==29 && !isleap)) {
          return false;
           }
        }
        return true;  
       }
    
    document.getElementById("fechaNac").addEventListener('keyup', function() {
        pintaDate("fechaNac");
        }
    );
    document.getElementById("fechaNac").addEventListener('focusin', function() {
        pintaDate("fechaNac");
        }
    );
    document.getElementById("fechaNac").addEventListener('focusout', function() {
        despintaBorde("fechaNac");
        }
    );
    
    function pintaDate (campo) {
        if (validateDate())
            pintaVerde(campo);
        else 
            pintaRojo(campo); 
    }

// --------------------------------------------------------------

function pintaVerde (campo) {
    document.getElementById(campo).style.border = "1px solid";
    document.getElementById(campo).style.borderColor = "green";
}

function pintaRojo (campo) {
    document.getElementById(campo).style.border = "1px solid";
    document.getElementById(campo).style.borderColor = "red";
}

function despintaBorde(campo){
    document.getElementById(campo).style.border = "none";
}