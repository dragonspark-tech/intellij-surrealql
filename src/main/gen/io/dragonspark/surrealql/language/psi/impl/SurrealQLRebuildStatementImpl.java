// This is a generated file. Not intended for manual editing.
package io.dragonspark.surrealql.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.dragonspark.surrealql.language.psi.SurrealQLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import io.dragonspark.surrealql.language.psi.*;

public class SurrealQLRebuildStatementImpl extends ASTWrapperPsiElement implements SurrealQLRebuildStatement {

  public SurrealQLRebuildStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SurrealQLVisitor visitor) {
    visitor.visitRebuildStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SurrealQLVisitor) accept((SurrealQLVisitor)visitor);
    else super.accept(visitor);
  }

}
