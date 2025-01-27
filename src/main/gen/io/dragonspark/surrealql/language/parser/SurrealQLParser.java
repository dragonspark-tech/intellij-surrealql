// This is a generated file. Not intended for manual editing.
package io.dragonspark.surrealql.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static io.dragonspark.surrealql.language.psi.SurrealQLTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SurrealQLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return surqlFile(b, l + 1);
  }

  /* ********************************************************** */
  // rebuild| " " |COMMENT|CRLF
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = rebuild(b, l + 1);
    if (!r) r = consumeToken(b, " ");
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    return r;
  }

  /* ********************************************************** */
  // REBUILD rebuild_statement
  public static boolean rebuild(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rebuild")) return false;
    if (!nextTokenIs(b, REBUILD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REBUILD);
    r = r && rebuild_statement(b, l + 1);
    exit_section_(b, m, REBUILD, r);
    return r;
  }

  /* ********************************************************** */
  // "INDEX" ["IF EXISTS"] name "ON" ["TABLE"] table
  public static boolean rebuild_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rebuild_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REBUILD_STATEMENT, "<rebuild statement>");
    r = consumeToken(b, "INDEX");
    r = r && rebuild_statement_1(b, l + 1);
    r = r && consumeToken(b, NAME);
    r = r && consumeToken(b, "ON");
    r = r && rebuild_statement_4(b, l + 1);
    r = r && consumeToken(b, TABLE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ["IF EXISTS"]
  private static boolean rebuild_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rebuild_statement_1")) return false;
    consumeToken(b, "IF EXISTS");
    return true;
  }

  // ["TABLE"]
  private static boolean rebuild_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rebuild_statement_4")) return false;
    consumeToken(b, "TABLE");
    return true;
  }

  /* ********************************************************** */
  // item_*
  static boolean surqlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "surqlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "surqlFile", c)) break;
    }
    return true;
  }

}
