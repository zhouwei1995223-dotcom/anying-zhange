import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import javassist.CannotCompileException;

public class Bag128Patch {
    static final int BAG_SIZE = 128;
    static final int ROWS = 16;
    static final int HEIGHT = 678;

    public static void main(String[] args) throws Exception {
        String root = args[0];
        patchServer(root);
        patchClient(root);
    }

    static void patchServer(String root) throws Exception {
        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(root + "/server/server_bag64.zip");

        CtClass depot = cp.get("app.island.data.Depot");
        CtConstructor ctor = depot.getDeclaredConstructor(new CtClass[0]);
        ctor.insertAfter("{ this.goodsList = new app.island.data.Goods[" + BAG_SIZE + "]; }");
        depot.writeFile(root + "/.codex_tmp_bag64/server_bag128_classes");
    }

    static void patchClient(String root) throws Exception {
        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(root + "/client/client_bag64.zip");

        CtClass heroDepot = cp.get("b.a.e.h");
        CtConstructor heroDepotCtor = heroDepot.getDeclaredConstructor(new CtClass[0]);
        heroDepotCtor.insertAfter("{ this.fr = new b.a.e.j[" + BAG_SIZE + "]; }");
        heroDepot.writeFile(root + "/.codex_tmp_bag64/client_bag128_classes");

        CtClass bagWindow = cp.get("b.a.c.b.a5");
        CtConstructor bagCtor = bagWindow.getDeclaredConstructor(new CtClass[] { cp.get("b.a.c.b"), CtClass.booleanType });
        bagCtor.insertAfter(
            "{ " +
            "this.setBounds(232, 40, 232, " + HEIGHT + "); " +
            "this.kZ = new int[" + BAG_SIZE + "][2]; " +
            "int __idx = 0; " +
            "int __y = 202; " +
            "for (int __row = 0; __row < " + ROWS + "; __row++) { " +
            "  int __x = 4; " +
            "  for (int __col = 0; __col < 8; __col++) { " +
            "    this.kZ[__idx][0] = __x; " +
            "    this.kZ[__idx][1] = __y; " +
            "    __idx++; " +
            "    __x += 28; " +
            "  } " +
            "  __y += 28; " +
            "} " +
            "}"
        );

        CtMethod draw = bagWindow.getDeclaredMethod("a", new CtClass[] { cp.get("a.b.c") });
        draw.insertAfter(
            "{ " +
            "if (this.k9 != null && this.k9.fr != null && this.kZ != null && this.kZ.length >= " + BAG_SIZE + ") { " +
            "  try { " +
            "  java.lang.Class __drawClass = java.lang.Class.forName(\"b.a.c.b.e\"); " +
            "  java.lang.reflect.Method __drawCell = __drawClass.getMethod(\"a\", new java.lang.Class[] { java.lang.Class.forName(\"a.b.c\"), java.lang.Integer.TYPE, java.lang.Integer.TYPE }); " +
            "  java.lang.reflect.Method __drawGoods = __drawClass.getMethod(\"a\", new java.lang.Class[] { java.lang.Class.forName(\"a.b.c\"), java.lang.Class.forName(\"b.a.e.j\"), java.lang.Integer.TYPE, java.lang.Integer.TYPE }); " +
            "  int __max = this.k9.fr.length < " + BAG_SIZE + " ? this.k9.fr.length : " + BAG_SIZE + "; " +
            "  for (int __i = 64; __i < __max; __i++) { " +
            "    __drawCell.invoke(null, new java.lang.Object[] { $1, new java.lang.Integer(this.kZ[__i][0]), new java.lang.Integer(this.kZ[__i][1]) }); " +
            "    if (this.k9.fr[__i] != null) __drawGoods.invoke(null, new java.lang.Object[] { $1, this.k9.fr[__i], new java.lang.Integer(this.kZ[__i][0] + 2), new java.lang.Integer(this.kZ[__i][1] + 1) }); " +
            "  } " +
            "  } catch (java.lang.Throwable __ignored) {} " +
            "} " +
            "}"
        );

        bagWindow.writeFile(root + "/.codex_tmp_bag64/client_bag128_classes");
    }
}
