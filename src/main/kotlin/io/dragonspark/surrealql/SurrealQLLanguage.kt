package io.dragonspark.surrealql

import com.intellij.lang.Language

class SurrealQLLanguage private constructor() : Language("SurrealQL") {
    companion object {
        val INSTANCE = SurrealQLLanguage()
    }
}
