# kon - Conversor de unidades via terminal

Kon é uma ferramenta de linha de comando simples para converter unidades rapidamente

## Demonstração

kon -c temp -f C -t F -v 100

Saída: 212.0

## Instalação

Pré-requisitos
 - Java 21 ou superior

Passos
 <pre>
 # Baixe a versão mais recente e extraia
 unzip kon.zip && cd kon

 # De permissão de execução ao instalador
 chmod +x install.sh

 # Execute o instalador
 ./install.sh

 Recarregue as variáveis de ambiente (ajuste conforme seu shell)
 source ~/bashrc # ou ~/.zshrc
</pre>

## Uso básico

Comandos disponíveis:

<pre>
kon --list, -l <grandeza>
# Lista as unidades disponíveis de uma grandeza
</pre>

<pre>
kon --convert, -c <grandeza> --from, -f <unidade-origem> --to, -t <unidade-destino> --value, -v <valor>
# Converte um valor de uma unidade para outra
</pre>

<pre>
kon --help, -h
# Exibe o guia de uso
</pre>

## Desinstalação

<pre> rm -rf ~/.kon </pre>

---

Desenvolvido por [@marlonzl7](https://github.com/marlonzl7)

