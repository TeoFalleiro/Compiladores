grammar Numbers;

/*
// Descomente para gerar codigo em c#
options {
    language=CSharp;
}
*/

number: BINARY; // precisa ao menos uma regra de gram√°tica
                 // ignorar isso por hora

NEWLINE : [\r\n ]+;

BINARY : BIN_DIGIT+ 'b' ; // Sequencia de digitos seguida de b  10100b

BIN_DIGIT : [01];

INT_DIGIT : [0123456789]; // Numeros de 0-9 que seram usados nos inteiros

HEX_DIGIT : [0123456789ABCDEFabcdef]; // digitos alfanumericos para hexadecimal com digitos de A-F (maiusculo e minusculo)

INTEGER : INT_DIGIT+ | '-' INT_DIGIT+ ; // Sequencia de digitos 0-9 usando ou n„o '-' antes

REAL : INTEGER '.' INT_DIGIT+ | INTEGER '.' INT_DIGIT+ 'e' INTEGER | INTEGER '.' INT_DIGIT+ 'e''+' INT_DIGIT+ | INTEGER '.' INT_DIGIT+ 'E' INTEGER | INTEGER '.' INT_DIGIT+ 'E''+' INT_DIGIT+ ; 
//Sequencias numeros inteiros seguidos de '.' mais numero pisitivo seguido ou n„o do digitos e|E|e+|E+ e uam sequencia de inteiros

HEXADECIMAL : '0''x' HEX_DIGIT+;
