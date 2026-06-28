import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class RuntimeTitleAuraPatch {
    public static void main(String[] args) throws Exception {
        String root = args[0];
        patchServer(root);
        patchClient(root);
    }

    static void patchServer(String root) throws Exception {
        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(root + "/server/server_bag96.zip");

        CtClass depot = cp.get("app.island.data.Depot");
        CtMethod getHaloIndex = depot.getDeclaredMethod("getHaloIndex");
        getHaloIndex.insertBefore(
            "{"
                + "if (this.title != null) return 18;"
                + "if (this.aura != null) return 1;"
            + "}"
        );
        depot.writeFile(root + "/.codex_tmp_bag64/runtime_title_aura_server");
    }

    static void patchClient(String root) throws Exception {
        ClassPool cp = new ClassPool(false);
        cp.appendSystemPath();
        cp.insertClassPath(root + "/client/client_bag96_halo.zip");

        CtClass renderer = cp.get("b.a.b.p");
        CtMethod draw = renderer.getDeclaredMethod("if", new CtClass[] { cp.get("a.b.c") });
        draw.insertAfter(
            "{"
                + "try {"
                    + "if (this.af != null) {"
                        + "int __mark = this.af.aq;"
                        + "int __x = ((java.lang.Integer)this.getClass().getMethod(\"try\", new java.lang.Class[0]).invoke(this, new java.lang.Object[0])).intValue();"
                        + "int __y = ((java.lang.Integer)this.getClass().getMethod(\"char\", new java.lang.Class[0]).invoke(this, new java.lang.Object[0])).intValue();"
                        + "int __frame = (this.Q / 4) % 8;"
                        + "if ((__mark == 1 || __mark == 18) && auraDragon != null) {"
                            + "$1.a(auraDragon, __x, __y, __frame * 150, 0, 150, 150, 0, 0);"
                        + "}"
                        + "if (__mark == 18 && title != null) {"
                            + "$1.a(title, __x, __y - 12, __frame * 150, 0, 150, 150, 0, 0);"
                            + "if (this.ae < 32) {"
                                + "int __frame2 = (this.ae / 4) % 8;"
                                + "$1.a(title, __x, __y - 12, __frame2 * 150, 150, 150, 150, 0, 0);"
                            + "}"
                        + "}"
                    + "}"
                + "} catch (java.lang.Throwable __ignored) {}"
            + "}"
        );
        renderer.writeFile(root + "/.codex_tmp_bag64/runtime_title_aura_client");
    }
}
