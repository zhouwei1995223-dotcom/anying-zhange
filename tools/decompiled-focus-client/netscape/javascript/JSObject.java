/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.ms.activeX.ActiveXControlServices
 *  com.ms.com.ComFailException
 *  com.ms.com.Dispatch
 *  com.ms.com.IServiceProvider
 *  com.ms.com.Variant
 *  com.ms.com._Guid
 */
package netscape.javascript;

import com.ms.activeX.ActiveXControlServices;
import com.ms.com.ComFailException;
import com.ms.com.Dispatch;
import com.ms.com.IServiceProvider;
import com.ms.com.Variant;
import com.ms.com._Guid;
import java.applet.Applet;
import java.awt.Container;
import netscape.javascript.JSException;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class JSObject {
    private static final _Guid a = new _Guid("{00020400-0000-0000-C000-000000000046}");
    private static final _Guid int = new _Guid("{b722be00-4e68-101b-a2bc-00aa00404770}");
    private static final int do = -2147352570;
    private Object for;
    private Object if;

    public Object getMember(String string) {
        Variant variant;
        block3: {
            if (this.if == null) {
                this.a();
            }
            variant = null;
            try {
                variant = Dispatch.get_casesensitive((Object)this.if, (String)string);
            }
            catch (ComFailException comFailException) {
                if (comFailException.getHResult() == -2147352570) break block3;
                throw comFailException;
            }
        }
        return this.a(variant);
    }

    public void setMember(String string, Object object) {
        if (this.if == null) {
            this.a();
        }
        Dispatch.put_casesensitive((Object)this.if, (String)string, (Object)object);
    }

    public String toString() {
        return "";
    }

    private void if(Object object) {
        this.for = object;
        this.if = null;
    }

    public void removeMember(String string) {
    }

    private void a(Object object) {
        this.if = object;
    }

    public Object getSlot(int n2) {
        return null;
    }

    public void setSlot(int n2, Object object) {
    }

    private void a() {
        if (this.for == null) {
            throw new NullPointerException();
        }
        IServiceProvider iServiceProvider = (IServiceProvider)this.for;
        Object[] objectArray = new Object[1];
        iServiceProvider.QueryService(int, a, objectArray);
        Variant variant = Dispatch.get((Object)objectArray[0], (String)"frames");
        Object object = variant.toObject();
        if (object == null) {
            throw new NullPointerException();
        }
        this.if = object;
    }

    public Object call(String string, Object[] objectArray) {
        Variant variant;
        block3: {
            if (this.if == null) {
                this.a();
            }
            variant = null;
            try {
                variant = Dispatch.callN_casesensitive((Object)this.if, (String)string, (Object[])objectArray);
            }
            catch (ComFailException comFailException) {
                if (comFailException.getHResult() == -2147352570) break block3;
                throw comFailException;
            }
        }
        return this.a(variant);
    }

    private Object a(Variant variant) {
        if (variant == null) {
            return "undefined";
        }
        switch (variant.getvt() & 0xFFF) {
            case 0: 
            case 1: {
                return "undefined";
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 10: 
            case 17: {
                return new Double(variant.toDouble());
            }
            case 8: {
                return variant.toString();
            }
            case 9: {
                JSObject jSObject = new JSObject();
                jSObject.a(variant.toDispatch());
                return jSObject;
            }
            case 11: {
                return new Boolean(variant.toBoolean());
            }
            case 13: {
                return variant.toObject();
            }
        }
        throw new ClassCastException();
    }

    public static JSObject getWindow(Applet applet) throws JSException {
        Container container = applet;
        ActiveXControlServices activeXControlServices = null;
        JSObject jSObject = null;
        while (container != null) {
            if (container instanceof ActiveXControlServices) {
                activeXControlServices = (ActiveXControlServices)container;
                break;
            }
            container = container.getParent();
        }
        if (activeXControlServices == null) {
            throw new NullPointerException();
        }
        String string = applet.getParameter("mayscript");
        if (string == null) {
            throw new JSException("MAYSCRIPT is not enabled for this applet");
        }
        jSObject = new JSObject();
        jSObject.if(activeXControlServices.getClientSite());
        return jSObject;
    }

    public Object eval(String string) throws Exception {
        if (this.if == null) {
            this.a();
        }
        Variant variant = null;
        Object[] objectArray = new Object[]{string, "JavaScript"};
        variant = Dispatch.callN_casesensitive((Object)this.if, (String)"execScript", (Object[])objectArray);
        return this.a(variant);
    }
}

