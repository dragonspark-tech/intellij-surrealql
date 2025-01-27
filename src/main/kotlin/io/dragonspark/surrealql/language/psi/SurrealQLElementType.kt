package io.dragonspark.surrealql.language.psi

import com.intellij.psi.tree.IElementType
import io.dragonspark.surrealql.SurrealQLLanguage
import org.jetbrains.annotations.NonNls
import org.jetbrains.annotations.NotNull

class SurrealQLElementType(@NotNull @NonNls debugName: String) : IElementType(debugName, SurrealQLLanguage.INSTANCE)