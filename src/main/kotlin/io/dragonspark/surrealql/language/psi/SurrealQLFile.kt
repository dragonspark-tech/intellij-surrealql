package io.dragonspark.surrealql.language.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import org.jetbrains.annotations.NotNull
import io.dragonspark.surrealql.SurrealQLLanguage
import io.dragonspark.surrealql.SurrealQLFileType

class SurrealQLFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SurrealQLLanguage.INSTANCE)  {
    @NotNull
    override fun getFileType(): SurrealQLFileType {
        return SurrealQLFileType.INSTANCE
    }

    override fun toString(): String {
        return "SurrealDB QL File"
    }
}