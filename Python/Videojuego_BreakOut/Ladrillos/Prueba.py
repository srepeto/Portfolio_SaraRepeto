import sys
import pygame

SCREEN_SIZE   = 640,480

# Object dimensions
BRICK_WIDTH   = 60
BRICK_HEIGHT  = 15
PADDLE_WIDTH  = 85
PADDLE_HEIGHT = 12
BALL_DIAMETER = 16
BALL_RADIUS   = BALL_DIAMETER / 2

MAX_PADDLE_X = SCREEN_SIZE[0] - PADDLE_WIDTH
MAX_BALL_X   = SCREEN_SIZE[0] - BALL_DIAMETER
MAX_BALL_Y   = SCREEN_SIZE[1] - BALL_DIAMETER

# Paddle Y coordinate
PADDLE_Y = SCREEN_SIZE[1] - PADDLE_HEIGHT - 10

# Color constants
BLACK = (0,0,0)
WHITE = (255,255,255)
BRICK_COLOR = (126,186,175)
ROSA = (236,70,100)
ROSA_PALO = (246,179,179)

# State constants
STATE_BALL_IN_PADDLE = 0
STATE_PLAYING = 1
STATE_WON = 2
STATE_GAME_OVER = 3



def init_game():
    global lives, score, state, paddle, ball, ball_vel

    lives = 3
    score = 0
    state = STATE_BALL_IN_PADDLE

    paddle   = pygame.Rect(300,PADDLE_Y,PADDLE_WIDTH,PADDLE_HEIGHT)
    ball     = pygame.Rect(300,PADDLE_Y - BALL_DIAMETER,BALL_DIAMETER,BALL_DIAMETER)

    ball_vel = [5,-5]

    create_bricks()


def create_bricks():
    global bricks

    bricks = []
    y_ofs = 45

    for i in range(7):
        x_ofs = 40
        for j in range(8):
            bricks.append(pygame.Rect(x_ofs,y_ofs,BRICK_WIDTH,BRICK_HEIGHT))
            x_ofs += BRICK_WIDTH + 10
        y_ofs += BRICK_HEIGHT + 5

def draw_bricks():
    global bricks

    for brick in bricks:
        pygame.draw.rect(screen, BRICK_COLOR, brick)

def check_input():
    global paddle, state, ball_vel

    keys = pygame.key.get_pressed()

    if keys[pygame.K_LEFT]:
        paddle.left -= 8
        if paddle.left < 0:
            paddle.left = 0

    if keys[pygame.K_RIGHT]:
        paddle.left += 8
        if paddle.left > MAX_PADDLE_X:
            paddle.left = MAX_PADDLE_X

    if keys[pygame.K_SPACE] and state == STATE_BALL_IN_PADDLE:
        ball_vel = [5,-5]
        state = STATE_PLAYING
    elif keys[pygame.K_RETURN] and (state == STATE_GAME_OVER or state == STATE_WON):
        init_game()

def move_ball():
    global ball, ball_vel

    ball.left += ball_vel[0]
    ball.top  += ball_vel[1]

    if ball.left <= 0:
        ball.left = 0
        ball_vel[0] = -ball_vel[0]
    elif ball.left >= MAX_BALL_X:
        ball.left = MAX_BALL_X
        ball_vel[0] = -ball_vel[0]

    if ball.top < 0:
        ball.top = 0
        ball_vel[1] = -ball_vel[1]
    elif ball.top >= MAX_BALL_Y:
        ball.top = MAX_BALL_Y
        ball_vel[1] = -ball_vel[1]

def handle_collisions():
    global bricks, ball, score, ball_vel, state, paddle, lives

    for brick in bricks:
        if ball.colliderect(brick):
            score += 1
            ball_vel[1] = -ball_vel[1]
            bricks.remove(brick)
            break

    if len(bricks) == 0:
        state = STATE_WON

    if ball.colliderect(paddle):
        ball.top = PADDLE_Y - BALL_DIAMETER
        ball_vel[1] = -ball_vel[1]
    elif ball.top > paddle.top:
        lives -= 1
        if lives > 0:
            state = STATE_BALL_IN_PADDLE
        else:
            state = STATE_GAME_OVER

def show_stats():
    global fuente_basica, screen, lives, score

    if fuente_basica:
        font_surface = fuente_basica.render("SCORE: " + str(score) + " LIVES: " + str(lives), False, BLACK)
        screen.blit(font_surface, (205,5))

def show_message(message):
    global fuente_basica, screen

    size = fuente_basica.size(message)
    font_surface = fuente_basica.render(message, False, BLACK)
    x = (SCREEN_SIZE[0] - size[0]) / 2
    y = (SCREEN_SIZE[1] - size[1]) / 2
    screen.blit(font_surface, (x,y))



pygame.init()

screen = pygame.display.set_mode(SCREEN_SIZE)
pygame.display.set_caption("Juega a destrozar ladrillos")
clock = pygame.time.Clock()

fondo = pygame.image.load('fondo.jpg') # creamos el color que va a tener el fondo a partir un Color Object
fondo = pygame.transform.scale(fondo, (640, 480)) # Le damos el alto y el ancho que queramos a la imagen

state = STATE_BALL_IN_PADDLE
paddle = pygame.Rect(300,PADDLE_Y,PADDLE_WIDTH,PADDLE_HEIGHT)
ball = pygame.Rect(300,PADDLE_Y - BALL_DIAMETER,BALL_DIAMETER,BALL_DIAMETER)
ball_vel = [5,-5]
bricks = []
fuente_basica = pygame.font.Font("Goldman-Regular.ttf", 20)

init_game()



while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:  # si el usuario ha pulsado el botón de cierre...
            pygame.quit()  # desinicializa los módulos y finaliza el juego de manera apropiada
            sys.exit()  # sale de Python

    screen.blit(fondo, (0, 0))  # Se dibuja el fondo con la imagen cargada anteriormente
    check_input()

    if state == STATE_PLAYING:
        move_ball()
        handle_collisions()
    elif state == STATE_BALL_IN_PADDLE:
        ball.left = paddle.left + paddle.width / 2
        ball.top  = paddle.top - ball.height
        show_message("PRESS SPACE TO LAUNCH THE BALL")
    elif state == STATE_GAME_OVER:
        show_message("GAME OVER. PRESS ENTER TO PLAY AGAIN")
    elif state == STATE_WON:
        show_message("YOU WON! PRESS ENTER TO PLAY AGAIN")

    draw_bricks()

    # Draw paddle
    pygame.draw.rect(screen, ROSA, paddle)

    # Draw ball
    pygame.draw.circle(screen, ROSA_PALO, (ball.left + BALL_RADIUS, ball.top + BALL_RADIUS), BALL_RADIUS)

    show_stats()

    pygame.display.flip()
    clock.tick(50)