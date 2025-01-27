// This is a generated file. Not intended for manual editing.
package io.dragonspark.surrealql.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import io.dragonspark.surrealql.language.psi.impl.*;

public interface SurrealQLTypes {

  IElementType REBUILD = new SurrealQLElementType("REBUILD");
  IElementType REBUILD_STATEMENT = new SurrealQLElementType("REBUILD_STATEMENT");

  IElementType COMMENT = new SurrealQLTokenType("COMMENT");
  IElementType CRLF = new SurrealQLTokenType("CRLF");
  IElementType NAME = new SurrealQLTokenType("name");
  IElementType REBUILD = new SurrealQLTokenType("REBUILD");
  IElementType TABLE = new SurrealQLTokenType("table");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == REBUILD) {
        return new SurrealQLRebuildImpl(node);
      }
      else if (type == REBUILD_STATEMENT) {
        return new SurrealQLRebuildStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
