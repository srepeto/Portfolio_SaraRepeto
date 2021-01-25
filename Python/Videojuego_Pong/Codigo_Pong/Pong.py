import pygame, sys, random # importamos las librerías necesarias


def animacion_bola(): # animación de la bola
    global pantalla_final, vel_bola_x, vel_bola_y, punt_jugador, punt_oponente, tiempo_punt # se declaran variables globales

    bola.x += vel_bola_x # movimiento de la bola en x
    bola.y += vel_bola_y # movimiento de la bola en y

    if bola.top <= 0 or bola.bottom >= alto_ventana: # si la bola toca la parte superior o inferior del canvas...
        pygame.mixer.Sound.play(sonido_colision) # se escucha este sonido
        vel_bola_y = -vel_bola_y # se invierte el movimiento de la bola en y

    # Puntuación del jugador
    if bola.left <= 0: # si la bola toca la parte izquierda del canvas...
        pygame.mixer.Sound.play(sonido_punt) # se escucha este sonido
        tiempo_punt = pygame.time.get_ticks() # obtiene el tiempo que ha pasado desde el inicio hasta ahora en milisegundos
        punt_jugador += 1 # se suma uno a la puntuación del jugador
        if punt_jugador == 5: # Cuando la puntuación del jugador llegue a 5 (es decir, que ha ganado)...
            pantalla_final = True # pantalla_final pasa a ser True. Es decir, que se va a mostrar
            pygame.mixer.Sound.play(sonido_victoria) # Y se escucha el sonido de victoria


    # Puntuación del oponente
    if bola.right >= ancho_ventana: # si la bola toca la parte derecha del canvas...
        pygame.mixer.Sound.play(sonido_punt) # se escucha este sonido
        tiempo_punt = pygame.time.get_ticks() # obtiene el tiempo que ha pasado desde el inicio hasta ahora en milisegundos
        punt_oponente += 1 # se suma uno a la puntuación del oponente
        if punt_oponente == 5: # Cuando la puntuación del oponente llegue a 5 (es decir, que ha ganado)...
            pantalla_final = True # pantalla_final pasa a ser True. Es decir, que se va a mostrar
            pygame.mixer.Sound.play(sonido_derrota) # Y se escucha el sonido de derrota

    # Colisiones con el jugador
    if bola.colliderect(jugador) and vel_bola_x > 0: # si la bola colisiona con la pala del jugador...
        pygame.mixer.Sound.play(sonido_colision) # se escucha este sonido
        if abs(bola.right - jugador.left) < 10: # si la parte derecha de la bola toca la parte izquierda de la pala
            vel_bola_x = -vel_bola_x # se invierte el movimiento de la bola en x
        elif abs(bola.bottom - jugador.top) < 10 and vel_bola_y > 0: # si la parte inferior de la bola toca la parte superior de la pala...
            vel_bola_y = -vel_bola_y # se invierte el movimiento de la bola en y
        elif abs(bola.top - jugador.bottom) < 10 and vel_bola_y < 0: # si la parte superior de la bola toca la parte inferior de la pala...
            vel_bola_y = -vel_bola_y # se invierte el movimiento de la bola en y

    # Colisiones con el oponente
    if bola.colliderect(oponente) and vel_bola_x < 0: # si la bola colisiona con la pala del jugador...
        pygame.mixer.Sound.play(sonido_colision) # se escucha este sonido
        if abs(bola.left - oponente.right) < 10: # si la parte izquierda de la bola toca la parte derecha de la pala
            vel_bola_x = -vel_bola_x # se invierte el movimiento de la bola en x
        elif abs(bola.bottom - oponente.top) < 10 and vel_bola_y > 0: # si la parte inferior de la bola toca la parte superior de la pala...
            vel_bola_y = -vel_bola_y # se invierte el movimiento de la bola en y
        elif abs(bola.top - oponente.bottom) < 10 and vel_bola_y < 0: # si la parte superior de la bola toca la parte inferior de la pala...
            vel_bola_y = -vel_bola_y # se invierte el movimiento de la bola en y


def animacion_jugador(): # animación del jugador
    jugador.y += vel_jugador # movimiento de la pala en y

    if jugador.top <= 0: # si la parte superior de la pala llega a la parte superior del canvas...
        jugador.top = 0 # se queda en 0 y no puede subir más aunque se pulse la tecla
    if jugador.bottom >= alto_ventana: # si la parte inferior de la pala llega a la parte inferior del canvas...
        jugador.bottom = alto_ventana # se queda en 0 y no puede bajar más aunque se pulse la tecla


def animacion_oponente(): # animación del oponente
    if oponente.top < bola.y: # si la parte superior de la pala está más arriba que la pelota...
        oponente.y += vel_oponente # la pala se mueve hacia abajo
    if oponente.bottom > bola.y: # si la parte inferior de la pala está mas abajo que la pelota...
        oponente.y -= vel_oponente # la pala se mueve hacia arriba

    if oponente.top <= 0: # si la parte superior de la pala llega a la parte superior del canvas...
        oponente.top = 0 # se queda en 0 y no puede subir más aunque se pulse la tecla
    if oponente.bottom >= alto_ventana: # si la parte inferior de la pala llega a la parte inferior del canvas...
        oponente.bottom = alto_ventana # se queda en 0 y no puede bajar más aunque se pulse la tecla


def inicio_bola(): # acciones que ocurrirán cuando uno de los jugadores marque o cuando empiece el juego
    global vel_bola_x, vel_bola_y, tiempo_punt # se declaran variables globales

    bola.center = (ancho_ventana / 2, alto_ventana / 2) # el centro de la bola se va a situar en la mitad del canvas
    tiempo_actual = pygame.time.get_ticks() # obtiene el tiempo que ha pasado desde el inicio hasta ahora en milisegundos

    if tiempo_actual - tiempo_punt < 700: # si han pasado menos de 700 milisegundos desde que algún jugador logró un punto o desde el inicio del juego...
        numero_tres = fuente_321.render("3", False, gris) # Se crea la superficie donde se va a visualizar el texto "3" de la cuenta atrás
        ventana.blit(numero_tres, (ancho_ventana / 2 - 60, alto_ventana / 2 + 20)) # Colocamos la superficie recién creada en la superficie principal con sus coordenadas x e y
    if 700 < tiempo_actual - tiempo_punt < 1400: # si han pasado otros 700 milisegundos desde que pintamos el 3...
        numero_dos = fuente_321.render("2", False, gris) # Se crea la superficie donde se va a visualizar el texto "2" de la cuenta atrás
        ventana.blit(numero_dos, (ancho_ventana / 2 - 60, alto_ventana / 2 + 20)) # Colocamos la superficie recién creada en la superficie principal con sus coordenadas x e y
    if 1400 < tiempo_actual - tiempo_punt < 2100: # si han pasado otros 700 milisegundos desde que pintamos el 2...
        numero_uno = fuente_321.render("1", False, gris) # Se crea la superficie donde se va a visualizar el texto "1" de la cuenta atrás
        ventana.blit(numero_uno, (ancho_ventana / 2 - 40, alto_ventana / 2 + 20)) # Colocamos la superficie recién creada en la superficie principal con sus coordenadas x e y

    if tiempo_actual - tiempo_punt < 2100: # si el tiempo que ha pasado desde que algún jugador logró un punto o desde el inicio del juego no ha superado los 2100 milisegundos...
        vel_bola_y, vel_bola_x = 0, 0 # la bola se para
    else: # sino...
        vel_bola_x = 7 * random.choice((1, -1)) # sé moverá hacia la izquierda o hacia la derecha de manera random
        vel_bola_y = 7 * random.choice((1, -1)) # sé moverá hacia arriba o hacia abajo de manera random
        tiempo_punt = None # score_time pasa a ser false para que en la siguiente vuelta del bucle principal no se repita esta cuenta atrás hasta que alguno marque


# Configuración general
pygame.mixer.pre_init(44100, -16, 2, 512) # se le pasan los argumentos al mezclador incluyendo el tamaño del buffer para que no haya retraso en el sonido
pygame.init() # inicializa todos los módulos pygame importados
reloj = pygame.time.Clock() # crea un reloj para que el programa se actualice a una velocidad fija

# Ventana principal
ancho_ventana = 960 # ancho de la ventana
alto_ventana = 720 # alto de la ventana
ventana = pygame.display.set_mode((ancho_ventana, alto_ventana)) # inicializa la ventana para su visualización
pygame.display.set_caption('Juego de Ping-Pong') # título de la ventana

# Colores
azul_oscuro = (0, 52, 104) # creamos el color azul de la pelota a partir de los RGB
rojo = (128, 0, 0) # creamos el color gris a partir de los RGB
negro = (0,0,0) # creamos el color negro a partir de los RGB
amarillo = (255,191,0) # creamos el color amarillo a partir de los RGB
azul_claro = (162,231,255) # creamos el color azul claro a partir de los RGB
gris = (48,48,48) # creamos el color gris a partir de los RGB
fondo = pygame.image.load('fondo.png') # creamos el color que va a tener el fondo a partir un Color Object
fondo = pygame.transform.scale(fondo, (960, 720)) # Le damos el alto y el ancho que queramos a la imagen

# Rectángulos (pos x, pos y, ancho, alto)
bola = pygame.Rect(ancho_ventana / 2 - 12.5, alto_ventana / 2 - 12.5, 25, 25) # rectángulo donde dibujaremos la bola
jugador = pygame.Rect(ancho_ventana - 20, alto_ventana / 2 - 50, 10, 100) # rectángulo donde dibujaremos la pala
oponente = pygame.Rect(10, alto_ventana / 2 - 50, 10, 100)  # rectángulo donde dibujaremos la pala del oponente

# Variables
vel_bola_x = 7 * random.choice((1, -1)) # la velocidad de la bola en x puede inicializarse en 1 o -1 de manera random
vel_bola_y = 7 * random.choice((1, -1)) # la velocidad de la bola en y puede inicializarse en 1 o -1 de manera random
vel_jugador = 0 # la velocidad de la pala del jugador se inicializa en 0
vel_oponente = 7 # la velocidad de la pala del oponente se inicializa en 7
tiempo_punt = True # inicializa en true para que luego en el bucle se comience llamando a la función de inicio de la bola
pantalla_final = False # La pantalla final se inicializa en False hasta que uno de los dos llegue a 5

# Textos
punt_jugador = 0 # la puntuación del jugador se inicializa en 0
punt_oponente = 0 # la puntuación del oponente se inicializa en 0
fuente_basica = pygame.font.Font('Goldman-Regular.ttf', 50) # se crea la fuente y su tamaño
fuente_321 = pygame.font.Font('Goldman-Regular.ttf', 200) # se crea la fuente y su tamaño
fuente_final = pygame.font.Font('Goldman-Regular.ttf', 100) # se crea la fuente y su tamaño
fuente_info = pygame.font.Font('Goldman-Regular.ttf', 25) # se crea la fuente y su tamaño

# Sonidos
sonido_colision = pygame.mixer.Sound("sonidos/pong.ogg") # se importa el sonido de choque de la bola con las palas en el mezclador
sonido_punt = pygame.mixer.Sound("sonidos/score.ogg") # se importa el sonido de nueva puntuación
sonido_victoria = pygame.mixer.Sound("sonidos/sonido_victoria.ogg") # se importa el sonido de victoria para el jugador
sonido_derrota = pygame.mixer.Sound("sonidos/sonido_derrota.ogg") # se importa el sonido de derrota para el jugador

while True:
    if not pantalla_final:
        for event in pygame.event.get(): # recibe una cola de eventos de interacciones del usuario
            if event.type == pygame.QUIT: # si el usuario ha pulsado el botón de cierre...
                pygame.quit() # desinicializa los módulos y finaliza el juego de manera apropiada
                sys.exit() # sale de Python
            if event.type == pygame.KEYDOWN: # si algún botón ha sido presionado...
                if event.key == pygame.K_UP: # si el botón presionado es la flecha hacia arriba...
                    vel_jugador -= 6 # la pala del jugador irá hacia arriba
                if event.key == pygame.K_DOWN: # si el botón presionado es la flecha hacia abajo...
                    vel_jugador += 6 # la pala del jugador irá hacia abajo
            if event.type == pygame.KEYUP: # si algún botón ha dejado de ser presionado...
                if event.key == pygame.K_UP: # si ha sido el de flecha hacia arriba...
                    vel_jugador += 6 # hace que pare el movimiento que llevaba hacia arriba
                if event.key == pygame.K_DOWN: # si ha sido el de flecha hacia abajo...
                    vel_jugador -= 6 # hace que pare el movimiento que llevaba hacia abajo

        # Lógica del juego
        animacion_bola() # llama a la función de la animación de la bola
        animacion_jugador() # llama a la función de la animación del jugador
        animacion_oponente() # llama a la función de la animación del oponente

        # Dibujamos (en los draw se indican (superficie, color, rectángulo))
        ventana.blit(fondo, (0,0)) # Se dibuja el fondo con la imagen cargada anteriormente
        pygame.draw.rect(ventana, rojo, jugador) # dibuja la pala del jugador
        pygame.draw.rect(ventana, rojo, oponente) # dibuja la pala del oponente
        pygame.draw.ellipse(ventana, azul_oscuro, bola) # dibuja la bola

        if tiempo_punt: # si es true (que significa que alguno a marcado, o que ha empezado el juego)...
            inicio_bola() # llama a esta función para que se ejecute una nueva cuenta atrás

        texto_jugador = fuente_basica.render(f'{punt_jugador}', False, negro) # Se crea la superficie donde se va a visualizar el texto de la puntuación del jugador
        ventana.blit(texto_jugador, (535, 5)) # Colocamos la superficie recién creada en la superficie principal con sus coordenadas x e y

        texto_oponente = fuente_basica.render(f'{punt_oponente}', False, negro) # Se crea la superficie donde se va a visualizar el texto de la puntuación del oponente
        ventana.blit(texto_oponente, (400, 5)) # Colocamos la superficie recién creada en la superficie principal con sus coordenadas x e y

    if pantalla_final: # Si pantalla_final es true...
        for event in pygame.event.get():  # recibe una cola de eventos de interacciones del usuario
            if event.type == pygame.QUIT:  # si el usuario ha pulsado el botón de cierre...
                pygame.quit()  # desinicializa los módulos y finaliza el juego de manera apropiada
                sys.exit()  # sale de Python
            if event.type == pygame.KEYDOWN: # si algún botón ha sido presionado...
                if event.key == pygame.K_SPACE: # si el botón presionado es el espacio..
                    tiempo_punt = pygame.time.get_ticks() # creamos el "punto de partida" que necesitará el método inicio_bola() para su correcto funcionamiento
                    punt_jugador = 0 # se reinicia a 0 la puntuación del jugador
                    punt_oponente = 0 # se reinicia a 0 la puntuación del oponente
                    pantalla_final = False # pasa a False para que pueda iniciarse una nueva partida

        ventana.fill (azul_claro) # Se rellena la pantalla con el color azul claro

        if punt_oponente == 5: # Si la puntuación del oponente es igual a 5...
            texto_derrota = fuente_final.render("¡DERROTA!", False, negro) # Superficie donde se va a visualizar el texto de la derrota
            ventana.blit(texto_derrota, (ancho_ventana/4 - 60, alto_ventana/3 + 50)) # La colocamos en la superficie principal con sus coordenadas x e y
            texto_nuevaPartida = fuente_info.render("Presiona 'espacio' para comenzar una nueva partida", False, negro) # Superficie donde se va a visualizar el texto de info
            ventana.blit(texto_nuevaPartida, (ancho_ventana / 4 - 100, alto_ventana / 2 + 100)) # La colocamos en la superficie principal con sus coordenadas x e y

        if punt_jugador == 5: # Si la puntuación del jugador es igual a 5...
            texto_victoria = fuente_final.render("¡VICTORIA!", False, negro) # Superficie donde se va a visualizar el texto de la victoria
            ventana.blit(texto_victoria, (ancho_ventana/4 - 40, alto_ventana/3 + 50)) # La colocamos en la superficie principal con sus coordenadas x e y
            texto_nuevaPartida = fuente_info.render("Presiona 'espacio' para comenzar una nueva partida", False, negro) # Superficie donde se va a visualizar el texto de info
            ventana.blit(texto_nuevaPartida, (ancho_ventana / 4 - 100, alto_ventana / 2 + 100)) # La colocamos en la superficie principal con sus coordenadas x e y

    pygame.display.flip() # actualiza la superficie completa de la pantalla y realiza de nuevo el dibujo
    reloj.tick(60) # el bucle se va a repetir 60 veces por segundo (fotogramas por segundo)

