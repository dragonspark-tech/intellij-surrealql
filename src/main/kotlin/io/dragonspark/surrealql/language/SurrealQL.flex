package io.dragonspark.surrealql.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import io.dragonspark.surrealql.language.psi.SurrealQLTypes;

%%
%class SurrealQLLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%caseless
%ignorecase
%eof{  return;
%eof}

// Macros
CRLF = \r|\n|\r\n
WHITE_SPACE = [ \t\f]
DIGIT = [0-9]
LETTER = [a-zA-Z]
ESCAPE = \b | \n | \r | \t | \r\n

// Numbers
INTEGER = {DIGIT}+
FLOAT = {DIGIT}+ \. {DIGIT}+ ([eE][+-]?{DIGIT}+)?

// Strings and Identifiers
STRING_SINGLE = ' ( (\\') | (\\.) | [^'\\] )* '
STRING_DOUBLE = \" ( (\\\") | (\\.) | [^\"\\] )* \"
QUOTED_IDENTIFIER = ` ( \\` | [^`] )* `
IDENTIFIER = {LETTER} ({LETTER}|{DIGIT}|_)*
PARAMETER = \$ {IDENTIFIER}

// Comments
LINE_COMMENT = "--" [^\r\n]*
BLOCK_COMMENT = "/*" ~"*/"

// Operators
OPERATOR = "&&" | "AND" | "||" | "OR" | "!" | "!!" | "??" | "?:" | "=" | "IS" | "!=" | "IS NOT" | "==" | "?=" | "*=" | "~" | "!~" | "*~" | "<" | "<=" | ">" | ">=" | "+" | "-" | "*" | "×" | "/" | "÷" | "**" | "IN" | "NOT IN" | "CONTAINS" | "∋" | "CONTAINSNOT" | "∌" | "CONTAINSALL" | "∌" | "CONTAINSANY" | "⊃" | "CONTAINSNONE" | "⊅" | "INSIDE" | "∈" | "NOTINSIDE" | "NOT IN" | "∉" | "ALLINSIDE" | "⊆" | "ANYINSIDE" | "⊂" | "NONEINSIDE" | "⊄" | "OUTSIDE" | "INTERSECTS" | "@@" | "@[ref]@" | "<|" | "|>"

// Keywords (case-insensitive)
KEYWORDS = "ACCESS" | "ALTER" | "BEGIN" | "BREAK" | "CANCEL" | "COMMIT" | "CONTINUE" | "CREATE" | "DEFINE" | "DELETE" | "FOR" | "IF ELSE" | "INFO" | "INSERT" | "KILL" | "LET" | "LIVE" | "REBUILD" | "RELATE" | "REMOVE" | "RETURN" | "SELECT" | "SHOW" | "SLEEP" | "THROW" | "UPDATE" | "UPSERT" | "USE"

// States
%state IN_BLOCK_COMMENT

%%

<YYINITIAL> {
  {KEYWORDS} { return SurrealQLTypes.KEYWORD; }

  {OPERATOR} { return SurrealQLTypes.OPERATOR; }

  {INTEGER} { return SurrealQLTypes.INTEGER; }
  {FLOAT} { return SurrealQLTypes.FLOAT; }

  {STRING_SINGLE} | {STRING_DOUBLE} { return SurrealQLTypes.STRING; }

  {PARAMETER} { return SurrealQLTypes.PARAMETER; }

  {LINE_COMMENT} { return SurrealQLTypes.COMMENT; }
  "/*" { yybegin(IN_BLOCK_COMMENT); return SurrealQLTypes.COMMENT; }

  {QUOTED_IDENTIFIER} { return SurrealQLTypes.IDENTIFIER; }
  {IDENTIFIER} { return SurrealQLTypes.IDENTIFIER; }

  "," { return SurrealQLTypes.COMMA; }
  "(" { return SurrealQLTypes.LPAREN; }
  ")" { return SurrealQLTypes.RPAREN; }
  "{" { return SurrealQLTypes.LBRACE; }
  "}" { return SurrealQLTypes.RBRACE; }
  "[" { return SurrealQLTypes.LBRACKET; }
  "]" { return SurrealQLTypes.RBRACKET; }
  ";" { return SurrealQLTypes.SEMICOLON; }

  {WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }
  {CRLF}+ { return TokenType.WHITE_SPACE; }

  [^] { return TokenType.BAD_CHARACTER; }
}

<IN_BLOCK_COMMENT> {
  "*/" { yybegin(YYINITIAL); }
  [^] { }
}