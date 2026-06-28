import javassist.*;
import javassist.expr.*;

public class StackPatch {
  public static void main(String[] args) throws Exception {
    String root = args[0];
    patchServer(root);
    patchClient(root);
  }
  static void patchServer(String root) throws Exception {
    ClassPool cp = new ClassPool(false);
    cp.appendSystemPath();
    cp.insertClassPath(root + "/server/server_bag64.zip");
    CtClass goods = cp.get("app.island.data.Goods");
    addField(goods, "public int canStack = 0;");
    addField(goods, "public int stackCount = 1;");
    goods.getDeclaredConstructor(new CtClass[0]).insertAfter("{ this.canStack = 0; this.stackCount = 1; }");
    goods.getDeclaredMethod("readFrom").instrument(new ExprEditor(){
      public void edit(MethodCall m) throws CannotCompileException {
        if (m.getClassName().equals("daff.a.e") && m.getMethodName().equals("case")) {
          m.replace("{ $_ = $proceed($$); this.canStack = ($_ >> 4) & 1; this.stackCount = $_ >> 5; if (this.stackCount < 1) this.stackCount = 1; }");
        }
      }
    });
    goods.getDeclaredMethod("writeTo").instrument(new ExprEditor(){
      int n = 0;
      public void edit(MethodCall m) throws CannotCompileException {
        if (m.getClassName().equals("daff.a.e") && m.getMethodName().equals("a") && m.getSignature().equals("(I)V")) {
          n++;
          if (n == 3) m.replace("{ $proceed($1 | (this.canStack << 4) | ((this.stackCount < 1 ? 1 : this.stackCount) << 5)); }");
        }
      }
    });
    goods.getDeclaredMethod("copyFrom").insertAfter("{ app.island.data.Goods g = (app.island.data.Goods)$1; this.canStack = g.canStack; this.stackCount = g.stackCount < 1 ? 1 : g.stackCount; }");
    addMethod(goods, "public boolean isStackable(){ return this.canStack == 1 && this.goodsType != 1 && this.goodsType != 2 && this.goodsType != 3 && this.goodsType != 6; }");
    goods.getDeclaredMethod("parseExtrInfo").insertBefore("{ if (this.isStackable() && $1 != null && $1.length() > 0) { try { this.stackCount = Integer.parseInt($1); if (this.stackCount < 1) this.stackCount = 1; } catch (Exception e) { this.stackCount = 1; } return; } }");
    goods.getDeclaredMethod("getExtraInfo").insertBefore("{ if (this.isStackable() && this.stackCount > 1) return String.valueOf(this.stackCount); }");
    goods.writeFile(root + "/.codex_stack_patch/server_classes");

    CtClass sp = cp.get("app.island.data.SpecialProperty");
    sp.getDeclaredMethod("parseExtrInfo").insertBefore("{ if (this.isStackable() && $1 != null && $1.length() > 0) { try { this.stackCount = Integer.parseInt($1); if (this.stackCount < 1) this.stackCount = 1; } catch (Exception e) { this.stackCount = 1; } return; } }");
    sp.getDeclaredMethod("getExtraInfo").insertBefore("{ if (this.isStackable() && this.stackCount > 1) return String.valueOf(this.stackCount); }");
    sp.writeFile(root + "/.codex_stack_patch/server_classes");

    CtClass depot = cp.get("app.island.data.Depot");
    addMethod(depot,
      "public void compactStacks(){" +
      " if (this.goodsList == null) return;" +
      " for (int i=0;i<this.goodsList.length;i++){" +
      "  app.island.data.Goods g=this.goodsList[i];" +
      "  if (g==null || !g.isStackable()) continue;" +
      "  if (g.stackCount<1) g.stackCount=1;" +
      "  for (int j=i+1;j<this.goodsList.length;j++){" +
      "   app.island.data.Goods h=this.goodsList[j];" +
      "   if (h!=null && h.isStackable() && h.id==g.id && h.getClass()==g.getClass()){ g.stackCount += (h.stackCount<1?1:h.stackCount); this.goodsList[j]=null; }" +
      "  }" +
      " }" +
      "}"
    );
    depot.getDeclaredMethod("writeGoods").insertBefore("{ this.compactStacks(); }");
    depot.getDeclaredMethod("getNextFreePos").insertBefore("{ this.compactStacks(); }");
    depot.getDeclaredMethod("getGoodsCount", new CtClass[0]).insertBefore("{ this.compactStacks(); }");
    depot.getDeclaredMethod("getGoodsCount", new CtClass[]{CtClass.intType}).insertBefore("{ this.compactStacks(); }");
    depot.writeFile(root + "/.codex_stack_patch/server_classes");
  }
  static void patchClient(String root) throws Exception {
    ClassPool cp = new ClassPool(false);
    cp.appendSystemPath();
    cp.insertClassPath(root + "/client/client_bag64.zip");
    CtClass goods = cp.get("b.a.e.j");
    addField(goods, "public int canStack = 0;");
    addField(goods, "public int stackCount = 1;");
    goods.getDeclaredConstructor(new CtClass[0]).insertAfter("{ this.canStack = 0; this.stackCount = 1; }");
    goods.getDeclaredMethod("a", new CtClass[]{cp.get("a.a.e")}).instrument(new ExprEditor(){
      public void edit(MethodCall m) throws CannotCompileException {
        if (m.getClassName().equals("a.a.e") && m.getMethodName().equals("case")) {
          m.replace("{ $_ = $proceed($$); this.canStack = ($_ >> 4) & 1; this.stackCount = $_ >> 5; if (this.stackCount < 1) this.stackCount = 1; }");
        }
      }
    });
    goods.getDeclaredMethod("if", new CtClass[]{cp.get("a.a.e")}).instrument(new ExprEditor(){
      int n = 0;
      public void edit(MethodCall m) throws CannotCompileException {
        if (m.getClassName().equals("a.a.e") && m.getMethodName().equals("a") && m.getSignature().equals("(I)V")) {
          n++;
          if (n == 3) m.replace("{ $proceed($1 | (this.canStack << 4) | ((this.stackCount < 1 ? 1 : this.stackCount) << 5)); }");
        }
      }
    });
    goods.getDeclaredMethod("do", new CtClass[]{cp.get("b.a.b")}).insertAfter("{ b.a.e.j g = (b.a.e.j)$1; this.canStack = g.canStack; this.stackCount = g.stackCount < 1 ? 1 : g.stackCount; }");
    addMethod(goods, "public boolean isStackable(){ return this.canStack == 1 && this.fW != 1 && this.fW != 2 && this.fW != 3 && this.fW != 6; }");
    goods.getDeclaredMethod("byte").insertBefore("{ if (this.isStackable() && $1 != null && $1.length() > 0) { try { this.stackCount = Integer.parseInt($1); if (this.stackCount < 1) this.stackCount = 1; } catch (Exception e) { this.stackCount = 1; } return; } }");
    goods.getDeclaredMethod("U").insertBefore("{ if (this.isStackable() && this.stackCount > 1) return String.valueOf(this.stackCount); }");
    goods.writeFile(root + "/.codex_stack_patch/client_classes");

    CtClass sp = cp.get("b.a.e.t");
    sp.getDeclaredMethod("byte").insertBefore("{ if (this.isStackable() && $1 != null && $1.length() > 0) { try { this.stackCount = Integer.parseInt($1); if (this.stackCount < 1) this.stackCount = 1; } catch (Exception e) { this.stackCount = 1; } return; } }");
    sp.getDeclaredMethod("U").insertBefore("{ if (this.isStackable() && this.stackCount > 1) return String.valueOf(this.stackCount); }");
    sp.writeFile(root + "/.codex_stack_patch/client_classes");
  }
  static void addField(CtClass c, String src) throws Exception { try { c.addField(CtField.make(src, c)); } catch (Exception ignored) {} }
  static void addMethod(CtClass c, String src) throws Exception { try { c.addMethod(CtNewMethod.make(src, c)); } catch (Exception ignored) {} }
}
