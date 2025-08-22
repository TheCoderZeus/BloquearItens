
# BloquearItens

O BloquearItens é um plugin desenvolvido para servidores de Minecraft que oferece controle granular sobre o uso de itens e blocos específicos no jogo. A principal função do plugin é permitir que administradores de servidor restrinjam a interação dos jogadores com uma variedade de itens, aumentando a segurança e a personalização da jogabilidade.

## Funcionalidades

O plugin permite o bloqueio das seguintes interações e itens:

*   **Baús:** Impede que jogadores não autorizados abram baús.
*   **Bancadas de Trabalho (Crafting Tables):** Restringe o acesso à interface de criação de itens.
*   **Bigornas:** Bloqueia o uso de bigornas para reparar ou encantar itens.
*   **Dispensadores (Dispensers) e Ejetores (Droppers):** Controla a utilização desses blocos.
*   **Funis (Hoppers):** Limita a capacidade de mover itens entre inventários.
*   **Portas e Portões:** Gerencia a interação com portas e portões de todos os tipos.
*   **Mecanismos de Redstone:**
    *   **Pistões:** Desativa a funcionalidade de pistões normais e aderentes.
    *   **Alavancas e Botões:** Impede o acionamento de mecanismos por meio de alavancas e botões.
    *   **Placas de Pressão:** Bloqueia a ativação de placas de pressão.
    *   **Redstone e TNT:** Restringe a colocação e o uso de componentes de redstone e dinamite (TNT), incluindo a prevenção de explosões.

## Configuração

O plugin é altamente configurável através do arquivo `config.yml`. Os administradores podem:

*   Ativar ou desativar o bloqueio para cada item individualmente.
*   Personalizar as mensagens de bloqueio exibidas aos jogadores.
*   Especificar em quais mundos o plugin deve operar, permitindo a criação de zonas com regras de interação distintas.

## Permissões

O BloquearItens inclui um sistema de permissões que permite aos administradores conceder a jogadores ou grupos específicos a capacidade de contornar os bloqueios. Cada item bloqueável possui sua própria permissão de bypass, oferecendo flexibilidade máxima no gerenciamento de acesso.
