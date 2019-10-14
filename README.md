# DFA_NFA_SIMULATOR

Aluno: Luiz Eduardo Gonçalves Silva

Data: 14/10/2019

Trabalho 01 - LFA 

# Requisitos do sistema:

Sistema operacional: Windows (x86) / Windows (x64) / Mac OS / Linux (Qualquer sistema operacional que tenha suporte ao Java)


Java: --version 8.x ou superior

# Como usar o programa:

0) Execute o .jar, contido na pasta: "dist" na raiz deste projeto.

1) Clique no botão: "Open DFA File Table" e selecione um arquivo .txt, que contém a tabela de transição do DFA, seguindo os padrões estabelecidos abaixo.

2) Clique no botão: "Open tests file" e selecione um arquivo .txt, que contém as strings de teste, seguindo os padrões estabelecidos abaixo.

3) Após o passo 2, uma caixa de diálogo será aberta para que você possa escolher onde salvar um arquivo .txt contendo o resultado dos testes. Nomeie o arquivo com o nome de sua preferência e salve-o no local de sua preferência. Obs.: O nome do arquivo não precisa ser acompanhado de ".txt". O programa o salva como .txt automaticamente.

# ENTRADA:

A tabela de transição do DFA deve estar no seguinte formato:
Símbolos do alfabeto separados por ","
Estado inicial, cujo pré-fixo é: ">"
Conjunto de estados finais, separados por vírgula (caso tenha mais que um), cujo pré-fixo de cada estado é: "*"
Nome do estado:Estado atingível lendo o 1 símbolo do alfabeto, Estado atingível lendo o 2 símbolo do alfabeto
Nome do estado:Estado atingível lendo o 1 símbolo do alfabeto, Estado atingível lendo o 2 símbolo do alfabeto
Etc
Obs.: Estados que não possuem transição para dado símbolo do alfabeto devem seguir o seguinte formato:
Nome do estado:{},Estado atingível lendo o 2 símbolo do alfabeto

Ex.:

    0,1 - símbolos do alfabeto
    >q0 - estado inicial
    *q0,*q1 - estados final
    q0:q2,q1 - estado q0, lendo 0, vai para q2. Lendo 1, vai para q1
    q1:q3,q0
    q2:q3,q3
    q3:q1,q2
    q4:{},q2
    q5:{},{}


O arquivo que contém as strings teste deve estar no seguinte formato:
Cada caracter da string deve estar separado por vírgula e cada string diferente deve estar na linha inferior à antecessora.

Ex.:

    0,1 - equivalente a 01

    0,1,0,1,0,1,0,0 - equivalente a 01010100

    0 - equivalente a 0


Na pasta 'exemplos_arq_entradas', há alguns exemplos de inputs de tabelas e strings teste.


# SAIDA:

A saída será um arquivo .txt no seguinte formato:
String teste: transições -> ACEITA/NAO ACEITA

Ex.:

    1,0,1: q0->q1->q2->  NAO ACEITA

    0,0,1: q0->q1->q2->  NAO ACEITA

    1,0,1,0,1,0,1,0,1,0,1: q0->q1->q2->  NAO ACEITA

    0,1,0,0,0,1,0,0,1: q0->q1->q2->  NAO ACEITA
