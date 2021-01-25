var canvas = document.getElementById("myCanvas"); //La variable canvas recoge el canvas creado en el html
var ctx = canvas.getContext("2d"); //Variable que almacena el contexto de renderizado 2D

var x = canvas.width/2; //Posición inicial de la pelota en X
var y = canvas.height-30; //Posición inicial de la pelota en Y
var VelocidadX = 4; //Velocidad a la que se va a mover la pelota en X
var VelocidadY = -4; //Velocidad a la que se va a mover la pelota en Y
var ballRadius = 10; //Radio de la pelota

var paddleHeight = 10; //Altura de la barra
var paddleWidth = 75; //Anchura de la barra
var paddleX = (canvas.width-paddleWidth) / 2; //Coordenadas iniciales de la barra en X
var paddleY = (canvas.height-paddleHeight); //Coordenadas iniciales de la barra en Y

var rightPressed = false; //El botón de moverse a la derecha se inicializa en false
var leftPressed = false; //El botón de moverse a la izquierda se inicializa en false

var brickRowCount = 3; //Número de filas
var brickColumnCount = 7; //Número de columnas
var brickWidth = 65; //Ancho de cada ladrillo
var brickHeight = 20; //Altura de cada ladrillo
var brickPadding = 10; //Distancia entre cada ladrillo
var brickOffsetTop = 30; //Distancia entre la parte superior del canvas y la primera fila de ladrillos
var brickOffsetLeft = 30; //Distancia entre la parte izquierda del canvas y la primera columna de ladrillos
var bricks = []; //Array que va a contener los ladrillos

var score = 0; //Puntos que se consiguen a medida que se van destrozando los ladrillos
var lives = 3; //Vidas iniciales

for (var numColumns = 0; numColumns < brickColumnCount; numColumns++) { //Este for va recorriendo todas las columnas de ladrillos
    bricks[numColumns] = []; //Al array se le añaden las columnas
    for (var numFilas = 0; numFilas < brickRowCount; numFilas++) { //Este for recorre cada fila de la columna en la que esté el for anterior
        bricks[numColumns][numFilas] = { x: 0, y: 0, status: 1 }; //Al array se le añaden las filas para poder obtener los ladrillos uno a uno y poder asignarles el estatus 1 de inicio
    }
}

document.addEventListener("keydown", keyDownHandler, false); //Se añade el evento de pulsado de una tecla
document.addEventListener("keyup", keyUpHandler, false); //Se añade el evento de no tener pulsada una tecla
document.addEventListener("mousemove", mouseMoveHandler, false); //Se añade el evento de movimiento con el ratón

function keyDownHandler(e) {
    if(e.key == "Right" || e.key == "ArrowRight") {
        rightPressed = true; //Si el botón de movimiento hacia la derecha está pulsado, rightPressed es true
    }
    else if(e.key == "Left" || e.key == "ArrowLeft") {
        leftPressed = true; //Si el botón de movimiento hacia la izquierda está pulsado, leftPressed es true
    }
}

function keyUpHandler(e) {
    if(e.key == "Right" || e.key == "ArrowRight") {
        rightPressed = false; //Si el botón de movimiento hacia la derecha no está pulsado, rightPressed es false
    }
    else if(e.key == "Left" || e.key == "ArrowLeft") {
        leftPressed = false; //Si el botón de movimiento hacia la izquierda no está pulsado, leftPressed es false
    }
}

function mouseMoveHandler(e) { //La barra se desplazará lateralmente en eje X según se mueva el ratón
    var relativeX = e.clientX - canvas.offsetLeft; //Esta variable recoge la posición del ratón en cuanto éste entra en el canvas
    if(relativeX > 0 && relativeX < canvas.width) { //Mientras que el ratón esté dentro del canvas...
      paddleX = relativeX - paddleWidth/2; // El puntero del ratón se coordinará con la barra siendo el punto de encuentro el centro de la barra
    }
  }

function collisionDetection() { //Función para detectar la colisión de la pelota con los ladrillos
    for (var numColumns = 0; numColumns < brickColumnCount; numColumns++) { //for que recorre las columnas de ladrillos
        for (var numFilas = 0; numFilas < brickRowCount; numFilas++) { //for que recorre las filas de cada columna
            var objBrick = bricks[numColumns][numFilas]; //Se sitúa en un ladrillo en concreto según la vuelta en la que estén los for anteriores
            if (objBrick.status == 1) { //Si el ladrillo aun está intacto (inicialmente, seguro)...
                if (x > objBrick.x && x < objBrick.x + brickWidth && y > objBrick.y && y < objBrick.y + brickHeight) { //Si la pelota toca ese ladrilo intacto..
                    VelocidadY = -VelocidadY; //La pelota invierte su movimiento
                    objBrick.status = 0; //El estatus del ladrillo pasa a ser 0 porque ya lo ha tocado la pelota
                    score++; //La puntuación sube al haber conseguido destruir un ladrillo
                    if (score == (brickColumnCount*brickRowCount)) { //Si la puntuación es igual al número de ladrillos que hay...
                        alert("VICTORIA!!"); //Sale una alerta diciéndote que has ganado
                        document.location.reload(); //Vuelve a cargar el juego tras haber cerrado la alerta
                    }
                }
            }
        }
    }
}
   
function drawBall() { //Dibuja la pelota
    ctx.beginPath(); //Se empieza a dibujar
    ctx.arc(x, y, ballRadius, 0, Math.PI*2); //círculo(coordenadaX, coordenadaY, radio, ángulo inicial, ángulo final)
    ctx.fillStyle = "#D10000"; //Color
    ctx.fill(); //Rellena la forma con el color
    ctx.closePath(); //Se termina de dibujar
}

function drawPaddle() { //Dibuja la barra
    ctx.beginPath(); //Se empieza a dibujar
    ctx.rect(paddleX, paddleY, paddleWidth, paddleHeight); //rectángulo(coordenadaX, coordenadaY, ancho de la barra, alto de la barra)
    ctx.fillStyle = "#0095DD"; //Color
    ctx.fill(); //Rellena la forma con el color
    ctx.closePath(); //Se termina de dibujar
}

function drawBricks() { //Dibuja los ladrillos
    for (var numColumns = 0; numColumns < brickColumnCount; numColumns++) { //for que recorre las columnas de ladrillos
        for (var numFilas = 0; numFilas < brickRowCount; numFilas++) { //for que recorre las filas de cada columna
            if (bricks[numColumns][numFilas].status == 1) { //Si el ladrillo sigue sin haber sido tocado por la pelota...
                var brickX = (numColumns * (brickWidth + brickPadding)) + brickOffsetLeft; //En brickX mete la coordenada X donde debería ir dibujado el ladrillo
                var brickY = (numFilas * (brickHeight + brickPadding)) + brickOffsetTop; //En brickY mete la coordenada Y donde debería ir dibujado el ladrillo
                bricks[numColumns][numFilas].x = brickX; //Coloca el ladrillo en esa coordenada X
                bricks[numColumns][numFilas].y = brickY; //Coloca el ladrillo en esa coordenada Y
                ctx.beginPath(); //Se empieza a dibujar
                ctx.rect(brickX, brickY, brickWidth, brickHeight); //Se dibuja cada ladrillo con un rectángulo añadiéndole las coordenadas y las dimensiones
                ctx.fillStyle = "#0095DD"; //Color
                ctx.fill(); //Se rellena la forma con el color
                ctx.closePath(); //Se termina de dibujar
            }
        }
    }
}

function drawTitle() { //Dibuja el título
    ctx.font = "16px Arial"; //Tamaño y tipo de fuente
    ctx.fillStyle = "#D10000"; //Color
    ctx.fillText("JUEGA A DESTROZAR LADRILLOS", 160, 20); //Texto del título con las coordenadas X e Y
}

function drawScore() { //Dibuja la puntuación
    ctx.font = "16px Arial"; //Tamaño y tipo de fuente
    ctx.fillStyle = "#0095DD"; //Color
    ctx.fillText("Puntuación: "+score, 8, 20); //Texto con la puntuación y las coordenadas X e Y
}

function drawLives() { //Dibuja las vidas que te queden
    ctx.font = "16px Arial"; //Tamaño y tipo de fuente
    ctx.fillStyle = "#0095DD"; //Color
    ctx.fillText("Vidas: "+lives, canvas.width-65, 20); //Texto con las vidas y las coordenadas X e Y
}

function draw() { 
    ctx.clearRect(0, 0, canvas.width, canvas.height); //Se limpia el canvas con el clearRect para que no se quede pintado el recorrido de la pelota

    drawBricks(); //Llama a la función que dibuja los ladrillos
    drawBall(); //Llama a la función que dibuja la pelota
    drawPaddle(); //Llama a la función que dibuja la barra
    drawScore(); //Llama a la función que dibuja la puntuación
    drawLives(); //Llama a la función que dibuja las vidas
    drawTitle(); //Llama a la función que dibuja el título
    collisionDetection(); //Llama a la función de detección de colisiones entre la pelota y los ladrillos

    if(x + VelocidadX > canvas.width-ballRadius || x + VelocidadX < ballRadius) { //Cuando la pelota toque alguno de los laterales el canvas..
        VelocidadX = -VelocidadX; //Se invierte su movimiento
    }

    if(y + VelocidadY < ballRadius) { //Si la pelota toca la parte superior del canvas...
        VelocidadY = -VelocidadY; //Se invierte su movimimento
    } else if(y + VelocidadY > canvas.height-ballRadius) { //Si la pelota se sitúa en la parte inferior del canvas
        if(x > paddleX && x < paddleX + paddleWidth) { //Comprueba si las coordenadas de la pelota se comprenden entre el extremo dcho e izq de la barra (es decir, si toca la barra)
            VelocidadY = -VelocidadY; //Si toca la barra se invierte el movimiento de la pelota
        } else {
            lives--; //Si toca el "suelo", se le resta una vida
            if(!lives) { //Si no le quedan vidas...
                alert("DERROTA!!"); //Sale una alerta indicando que el juego ha acabado
                document.location.reload(); //Vuelve a cargar el juego tras haber cerrado la alerta
            }
            else { //Esto coloca la pelota y la barra en su sitio tras haber perdido una vida
                x = canvas.width/2; //Coordenada X inicial de la pelota
                y = canvas.height-30; //Coordenada Y inicial de la pelota
                paddleX = (canvas.width-paddleWidth)/2; //Coordenada X inicial de la barra
            }
        }
    }

    if(rightPressed && paddleX < canvas.width-paddleWidth) { //Si rightPressed está pulsado y la barra aun no ha llegado al lateral derecho del canvas...
        paddleX += 7; //Se mueve la barra hacia la derecha
      }
      else if(leftPressed && paddleX > 0) { //Si leftPressed está pulsado y la barra aun no ha llegado al lateral izquierdo del canvas...
        paddleX -= 7; //Se mueve la barra hacia la izquierda
      }
    
      x += VelocidadX; //Movimiento de la pelota en X
      y += VelocidadY; //Movimiento de la pelota en Y

    requestAnimationFrame(draw); //Le da al navegador el control sobre el framerate (o fotogramas por segundo)
    //Esto hará que solo renderice las formas cuando sea necesario y que, por tanto, sea mucho más eficiente y fluido 
    
}

draw(); //Se llama a la función draw