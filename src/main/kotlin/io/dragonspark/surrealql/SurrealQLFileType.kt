package io.dragonspark.surrealql

import com.intellij.openapi.fileTypes.LanguageFileType
import org.jetbrains.annotations.NotNull
import javax.swing.Icon

class SurrealQLFileType private constructor() : LanguageFileType(SurrealQLLanguage.INSTANCE) {
    companion object {
        val INSTANCE = SurrealQLFileType()
    }

    @NotNull
    override fun getName(): String {
        return "SurrealQL File"
    }

    @NotNull
    override fun getDescription(): String {
        return "SurrealDB SurQL file"
    }

    @NotNull
    override fun getDefaultExtension(): String {
        return "surql"
    }

    override fun getIcon(): Icon {
        return SurrealQLIcons.FILE
    }
}

