# Parsing de Descenso Recursivo

Esta es una implementación manual de un lexer y un parser utilizando la técnica de descenso recursivo. La implementación
está basada en los patrones especificados en _Parr, T. Language Implementation Patterns. The Pragmatic Bookshelf, 2009_.

El objetivo de este código es demostrar un primer acercamiento de solución al problema del parsing. El ejemplo permite ilustar
los posibles problemas que se pueden encontrar conforme las gramáticas crecen en complejidad e introduce la necesidad de
desarrollar algoritmos más sofisticados.

Lexer:

```groovy
code =
        '''
        " este es un
          comentario
          multilinea
        "
        [
            el1,
            el2,
            3
        ]
        '''
        
def token
Lexer lexer = new ListLexer(new StringReader(code))
while ((token = lexer.nextToken()).tokenType != TokenType.EOF) {
    println(token)
}
```

Parser:

```groovy
def code = '[[x, 1],[y, 2],[z, 3]]'
Parser parser = new ListParser(new ListLexer(new StringReader(code)))
parser.list()
println(parser.ast)
```
