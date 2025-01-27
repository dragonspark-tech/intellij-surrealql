package io.dragonspark.surrealql.language.psi

import com.intellij.psi.tree.IElementType
import io.dragonspark.surrealql.SurrealQLLanguage
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull

class SurrealQLTokenType(@NotNull @NonNls debugName: String) : IElementType(debugName, SurrealQLLanguage.INSTANCE) {
    override fun toString(): String {
        return "SurrealQLTokenType." + super.toString()
    }
}