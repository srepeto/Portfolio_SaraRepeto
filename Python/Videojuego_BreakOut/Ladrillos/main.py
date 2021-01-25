# Importamos las librerias necesarias
import sys
import pygame

# Declaración del tamaño de pantalla
tamaño_pantalla = 900, 550

# Tamaño de los objetos declarados para el juego
ancho_ladrillo = 60
alto_ladrillo = 15
ancho_paleta = 90
alto_paleta = 12
diametro_pelota = 18
radio_pelota = diametro_pelota / 2

# Limitaciones de tamaño de pelota y paleta para su futura colisión
limite_paleta_x = tamaño_pantalla[0] - ancho_paleta
limite_pelota_x = tamaño_pantalla[0] - diametro_pelota
limite_pelota_y = tamaño_pantalla[1] - diametro_pelota

# Coordenadas del eje Y de la paleta
paleta_y = tamaño_pantalla[1] - alto_paleta - 10

# Colores para el juego
blanco = (255, 255, 255)
color_ladrillo = (blanco)
celeste = (0, 180, 206)
morado = (225, 0, 157)

# Constantes del juego
pelota_en_paleta = 0
en_juego = 1
victoria = 2
game_over = 3


# Función para dar lugar al inicio del juego
def inicio_juego():
    global vidas, puntuacion, estado, paleta, pelota, velocidad_pelota  # Variables globales para el correcto funcionamiento del juego

    # Inicialización de las variables con sus diferentes estados
    vidas = 3
    puntuacion = 0
    estado = pelota_en_paleta
    pygame.mixer.pre_init(44100, -16, 2,512)  # Se le pasan los argumentos al mezclador incluyendo el tamaño del buffer para que no haya retraso en el sonido

    paleta = pygame.Rect(400, paleta_y, ancho_paleta,alto_paleta)  # Se crea la paleta en el espacio y con las dimensiones definidas
    pelota = pygame.Rect(300, paleta_y - diametro_pelota, diametro_pelota,diametro_pelota)  # Se crea la pelota en el espacio y con las dimensiones definidas

    # Velocidad de la pelota
    velocidad_pelota = [5, -5]

    # Llamada a la funcion de creación de los ladrillos
    crear_ladrillo()


# Función encargada de la creación de ladrillos
def crear_ladrillo():
    global ladrillos
    ladrillos = []

    distancia_ladrillo_y = 75  # Distancia con el borde de la pantalla por parte de los bloques

    # Creación de las columnas y filas de bloques y declaración de los parámetros de distancia entre ellos
    for filas in range(5):
        distancia_ladrillo_x = 70
        for columnas in range(11):
            ladrillos.append(pygame.Rect(distancia_ladrillo_x, distancia_ladrillo_y, ancho_ladrillo, alto_ladrillo))
            distancia_ladrillo_x += ancho_ladrillo + 10
        distancia_ladrillo_y += alto_ladrillo + 5


# Función encargada de dibujar los ladrillos en pantalla
def dibujar_ladrillo():
    global ladrillos

    # For para dibujar uno a uno los ladrillos con su color
    for ladrillo in ladrillos:
        pygame.draw.rect(pantalla, color_ladrillo, ladrillo)


# Función encargada de administrar y gestionar los controles del juego por parte del usuario
def controles():
    global paleta, estado, velocidad_pelota

    teclas = pygame.key.get_pressed()

    # Control para dirigirnos hacia la izquierda
    if teclas[pygame.K_LEFT]:
        paleta.left -= 10
        if paleta.left < 0:
            paleta.left = 0

    # Control para dirigirnos hacia la derecha
    if teclas[pygame.K_RIGHT]:
        paleta.left += 10
        if paleta.left > limite_paleta_x:
            paleta.left = limite_paleta_x

    # Control para disparar la pelota con la barra espaciadora
    if teclas[pygame.K_SPACE] and estado == pelota_en_paleta:
        velocidad_pelota = [7, -7]
        estado = en_juego

    # Control para volver a iniciar el juego con la tecla ENTER
    elif teclas[pygame.K_RETURN] and (estado == game_over or estado == victoria):
        inicio_juego()


# Función para controlar el movimiento de la pelota
def movimiento_pelota():
    global pelota, velocidad_pelota  # Variables globales para el movimiento de la pelota

    pelota.left += velocidad_pelota[0]
    pelota.top += velocidad_pelota[1]

    # Control para el choque de la pelota con el borde izquierdo
    if pelota.left <= 0:
        pelota.left = 0
        velocidad_pelota[0] = -velocidad_pelota[0]
        pygame.mixer.Sound.play(sonido_botar)  # Se reproduce el sonido

    # Control para el choque de la pelota con el borde derecho
    elif pelota.left >= limite_pelota_x:
        pelota.left = limite_pelota_x
        velocidad_pelota[0] = -velocidad_pelota[0]
        pygame.mixer.Sound.play(sonido_botar)  # Se reproduce el sonido

    # Control para el choque de la pelota con el borde de arriba
    if pelota.top < 0:
        pelota.top = 0
        velocidad_pelota[1] = -velocidad_pelota[1]
        pygame.mixer.Sound.play(sonido_botar) # Se reproduce el sonido
    elif pelota.top >= limite_pelota_y:
        pelota.top = limite_pelota_y
        velocidad_pelota[1] = -velocidad_pelota[1]


def pausarJuego():  # Función para pausar el juego
    juegoPausado = True

    # Texto Juego Pausado
    pausa = fuente_basica.render('PAUSA', True, blanco)
    pausa_posicion = pausa.get_rect(centerx=pantalla.get_width() / 2)
    pausa_posicion.top = 295
    pantalla.blit(pausa, pausa_posicion)

    # Evento que pausa el juego
    while juegoPausado:
        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            if evento.type == pygame.KEYDOWN:
                if evento.key == pygame.K_p:
                    juegoPausado = False
            pygame.display.update()


def colisiones():
    global ladrillos, pelota, puntuacion, velocidad_pelota, estado, paleta, vidas  # Variables necesarias para las colisiones

    # For encargado de controlar las colisiones de la pelota con los ladrillos
    for ladrillo in ladrillos:
        if pelota.colliderect(ladrillo):  # Si colisiona...
            puntuacion += 1  # Se suma 1 a la puntuación actual
            velocidad_pelota[1] = -velocidad_pelota[1]  # Rebota la pelota
            ladrillos.remove(ladrillo)  # Se elimina el ladrillo
            pygame.mixer.Sound.play(sonido_ladrillo)  # Se reproduce el sonido de colisión
            break

    # If encargado de decir cuando se ha ganado el juego
    if len(ladrillos) == 0:
        estado = victoria
        pygame.mixer.Sound.play(sonido_victoria)  # Hacemos sonar el sonido

    # If encargado de controlar la interacción de la colisión de la pelota con la paleta
    if pelota.colliderect(paleta):
        pelota.top = paleta_y - diametro_pelota
        velocidad_pelota[1] = -velocidad_pelota[1]
        pygame.mixer.Sound.play(sonido_pong)  # Se reproduce el sonido de colisión

        # Se resta una vida si la bola choca con el borde inferior, y si las vidas son menores a cero, game over
    elif pelota.top > paleta.top:
        vidas -= 1
        pygame.mixer.Sound.play(sonido_lose)  # Hacemos sonar el sonido de perder 1 vida
        if vidas > 0:
            estado = pelota_en_paleta
        else:
            estado = game_over
            pygame.mixer.Sound.play(sonido_derrota)  # Hacemos sonar el sonido de derrota


# Función encartgada de mostrar la puntuación y vidas
def mostrar_variables():
    global fuente_basica, pantalla, vidas, puntuacion  # Variables necesarias para mostrar variables

    if fuente_basica:
        fuente = fuente_basica.render("PUNTUACIÓN: " + str(puntuacion), False, blanco)
        pantalla.blit(fuente, (100, 5))

        fuente_2 = fuente_basica.render("VIDAS: " + str(vidas), False,blanco)
        pantalla.blit(fuente_2, (655, 5))


# Funcion encargada de mostrar mensajes de victoria/derrota/lanzar pelota
def mostrar_mensajes(mensaje):
    global fuente_basica, pantalla  # Variables necesarias para mostrar los mensajes de victoria/derrota

    tamaño_texto = fuente_basica.size(mensaje)  # Tamaño del mensaje
    fuente = fuente_basica.render(mensaje, False, blanco)  # Fuente del mensaje

    # Posiciones X,Y de los mensajes
    x = (tamaño_pantalla[0] - tamaño_texto[0]) / 2
    y = (tamaño_pantalla[1] - tamaño_texto[1]) / 2 + 100
    pantalla.blit(fuente, (x, y))


# Iniciación del videojuego
pygame.init()
pantalla = pygame.display.set_mode(tamaño_pantalla)  # Adaptar el juego al tamaño de la ventana
pygame.display.set_caption("Juega a destrozar ladrillos")  # Título del juego/ventana
reloj = pygame.time.Clock()  # Creación del reloj interno del juego
estado = pelota_en_paleta  # Se llama al estado de la pelota pegada a la paleta
fuente_basica = pygame.font.Font("Goldman-Regular.ttf", 25)  # Fuente de texto del juego

fondo = pygame.image.load('images.jpg')  # Creamos el color que va a tener el fondo a partir un Color Object
fondo = pygame.transform.scale(fondo, (900, 550))  # Creación de una superficie sobre la que poder dibujar nuestro juego


# Sonidos del juego
sonido_pong = pygame.mixer.Sound("sonidos/pong.ogg")  # Se importa el sonido de pong al chocar con las paredes
sonido_derrota = pygame.mixer.Sound("sonidos/sonido_derrota.ogg")  # Se importa el sonido de derrota para el jugador
sonido_victoria = pygame.mixer.Sound("sonidos/sonido_victoria.ogg")  # Se importa el sonido de victoria para el jugador
sonido_ladrillo = pygame.mixer.Sound("sonidos/ladrillo.ogg")  # Se importa el sonido de romper el ladrillo para el jugador
sonido_botar = pygame.mixer.Sound("sonidos/botar.ogg")  # Se importa el sonido de botar la pelota en la paleta
sonido_lose = pygame.mixer.Sound("sonidos/lose.ogg")  # Se importa el sonido de botar la pelota en la paleta

ladrillos = []  # Inicializa los bloques
inicio_juego()  # Llamada a la función inicio_juego

while True:
    for evento in pygame.event.get():
        if evento.type == pygame.QUIT:  # Si el usuario ha pulsado el botón de cierre...
            pygame.quit()  # Desinicializa los módulos y finaliza el juego de manera apropiada
            sys.exit()  # Salir de Python
        if evento.type == pygame.KEYDOWN:
            if evento.key == pygame.K_p:  # Evento de pausa
                pausarJuego()

    pantalla.blit(fondo, (0, 0))

    controles()  # Llamamos a la función para activar los controles

    # Llamamos a las funciones necesarias para el movimiento de la pelota y las colisiones
    if estado == en_juego:
        movimiento_pelota() # Se llama la función del movimiento de la pelota
        colisiones() # Se llama la función de las colisiones
    elif estado == pelota_en_paleta:
        pelota.left = paleta.left + paleta.width / 2.5
        pelota.top = paleta.top - pelota.height
        mostrar_mensajes("PRESIONA 'ESPACIO' PARA LANZAR")  # Mensaje de lanzamiento de pelota
    elif estado == game_over:
        mostrar_mensajes("GAME OVER. PRESIONA 'ENTER' PARA VOLVER A JUGAR")  # Mensaje de game over
    elif estado == victoria:
        mostrar_mensajes("¡HAS GANADO! PULSA 'ENTER' PARA VOLVER A JUGAR")  # Mensaje de victoria

    # Llamamos a la función de dibujar los ladrillos
    dibujar_ladrillo()

    # Dibujamos nuestra paleta
    pygame.draw.rect(pantalla, celeste, paleta)

    # Dibujamos nuestra pelota
    pygame.draw.circle(pantalla, morado, (pelota.left + radio_pelota, pelota.top + radio_pelota), radio_pelota)

    # Mostramos nuestras variables puntuación y vidas
    mostrar_variables()

    pygame.display.flip() # Actualiza la superfie completa de la pantalla y realiza de nuevo el dibujo
    reloj.tick(60) # El bucle se va a repetir 60 veces por segundo (FPS)
