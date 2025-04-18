# kon - Conversor de unidades via terminal

Kon é uma ferramenta de linha de comando simples para converter unidades rapidamente

## Demonstração

kon -c temp -f C -t F -v 100

# Saída: 212.0

# Instalação

Pré-requisitos
 - Java 21 ou superior

Passos
 - Baixe a versão mais recente
 - unzip kon.zip && cd kon
 - ./install.sh
 - source ~/bashrc

# Uso básico

Comandos disponíveis:

kon --list, -l <grandeza>
Lista as unidades disponíveis de uma grandeza

kon --convert, -c <grandeza> --from, -f <unidade-origem> --to, -t <unidade-destino> --value, -v <valor>
Converte um valor de uma unidade para outra

kon --help, -h
Exibe o guia de uso

# Desinstalação

rm -rf ~/.kon

# Autor

## Marlon de Souza

github: @marlonzl7

