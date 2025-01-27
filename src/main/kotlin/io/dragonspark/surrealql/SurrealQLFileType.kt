package io.dragonspark.surrealql

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class SurrealQLFileType private constructor() : LanguageFileType(SurrealQLLanguage.INSTANCE) {
    companion object {
        val INSTANCE = SurrealQLFileType()
    }

    override fun getName(): String {
        return "SurrealQL File"
    }

    override fun getDescription(): String {
        return "SurrealDB SurQL file"
    }

    override fun getDefaultExtension(): String {
        return "surql"
    }

    override fun getIcon(): Icon {
        return SurrealQLIcons.FILE
    }
}

