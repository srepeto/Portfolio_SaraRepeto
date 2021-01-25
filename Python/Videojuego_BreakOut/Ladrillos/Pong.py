import pygame, sys, random


def animacion_bola():
    global vel_bola_x, vel_bola_y, punt_jugador, tiempo_punt

    bola.x += vel_bola_x
    bola.y += vel_bola_y

    if bola.top <= 0:
        vel_bola_y = -vel_bola_y

    if bola.left <= 0:
        vel_bola_x = -vel_bola_x

    if bola.right >= ancho_ventana:
        vel_bola_x = -vel_bola_x

    if bola.bottom >= alto_ventana:
        tiempo_punt = pygame.time.get_ticks()
        punt_jugador = punt_jugador - 1

    if bola.colliderect(jugador):
        if abs(bola.right - jugador.left) < 10:
            vel_bola_x = -vel_bola_x
        elif abs(bola.bottom - jugador.top) < 10 and vel_bola_y > 0:
            vel_bola_y = -vel_bola_y
        elif abs(bola.top - jugador.bottom) < 10 and vel_bola_y < 0:
            vel_bola_y = -vel_bola_y


def animacion_jugador():
    jugador.x += vel_jugador

    if jugador.left <= 0:
        jugador.left = 0
    if jugador.right >= ancho_ventana:
        jugador.right = ancho_ventana


def inicio_bola():
    global vel_bola_x, vel_bola_y, tiempo_punt

    jugador.y = (alto_ventana - 20)
    jugador.x = (ancho_ventana/2 - 50)
    bola.center = (ancho_ventana/2, alto_ventana - 40)
    tiempo_actual = pygame.time.get_ticks()

    if tiempo_actual - tiempo_punt < 700:
        numero_tres = fuente_basica.render("3", False, gris_claro)
        ventana.blit(numero_tres, (ancho_ventana / 2 - 10, alto_ventana / 2 + 20))
    if 700 < tiempo_actual - tiempo_punt < 1400:
        numero_dos = fuente_basica.render("2", False, gris_claro)
        ventana.blit(numero_dos, (ancho_ventana / 2 - 10, alto_ventana / 2 + 20))
    if 1400 < tiempo_actual - tiempo_punt < 2100:
        numero_uno = fuente_basica.render("1", False, gris_claro)
        ventana.blit(numero_uno, (ancho_ventana / 2 - 10, alto_ventana / 2 + 20))

    if tiempo_actual - tiempo_punt < 2100:
        vel_bola_y, vel_bola_x = 0, 0
    else:
        vel_bola_x = 7 * random.choice((1, -1))
        vel_bola_y = 7 * (-1)
        tiempo_punt = None

# Setup general
pygame.mixer.pre_init(44100, -16, 2, 512)
pygame.init()
reloj = pygame.time.Clock()

# Ventana principal
ancho_ventana = 960
alto_ventana = 720
ventana = pygame.display.set_mode((ancho_ventana, alto_ventana))
pygame.display.set_caption('Juego de destrozar ladrillos')

# Colores
gris_claro = (200, 200, 200)
color_fondo = pygame.Color('grey12')
azul = (0, 0, 255)

# Rectángulos (pos x, pos y, ancho, alto)
bola = pygame.Rect(ancho_ventana/2, alto_ventana - 40, 25, 25)
jugador = pygame.Rect(ancho_ventana/2 -50, alto_ventana - 20, 100, 10)

# Variables
vel_bola_x = 7 * random.choice((1, -1))
vel_bola_y = 7 * (-1)
vel_jugador = 0
tiempo_punt = True

# Textos de puntuaciones
punt_jugador = 3
fuente_basica = pygame.font.Font('freesansbold.ttf', 32)

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT:
                vel_jugador -= 6
            if event.key == pygame.K_RIGHT:
                vel_jugador += 6
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_LEFT:
                vel_jugador += 6
            if event.key == pygame.K_RIGHT:
                vel_jugador -= 6

    animacion_bola()
    animacion_jugador()

    ventana.fill(color_fondo)
    pygame.draw.rect(ventana, gris_claro, jugador)
    pygame.draw.ellipse(ventana, gris_claro, bola)

    if tiempo_punt:
        inicio_bola()

    texto_jugador = fuente_basica.render("%s %d" % tuple(["Vidas: ", punt_jugador]), False, gris_claro)
    ventana.blit(texto_jugador, (20, 20))

    pygame.display.flip()
    reloj.tick(60)