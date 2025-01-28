package io.dragonspark.surrealql.language

import com.intellij.lexer.FlexAdapter

class SimpleLexerAdapter() : FlexAdapter(SurrealQLLexer(null))