/*
 * Decompiled with CFR 0.152.
 */
package game;

import a.a.b;
import a.a.h;
import a.a.i;
import a.a.n;
import a.a.o;
import a.a.q;
import a.c.a;
import a.e.c;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class GameApplet
extends Applet
implements b.a.c.c,
Runnable,
o,
a {
    String if = "client.cfg";
    boolean case;
    q goto = new q();
    q try = new q();
    q byte = new q();
    c else;
    b.a.c.b new;
    a.b.h char;
    Rectangle a = new Rectangle();
    String long = "127.0.0.1";
    int for = 12345;
    String int = "Loading...";
    boolean do;

    public void stop() {
        System.out.println("stop client");
        this.new.g();
        this.do = false;
    }

    public void playMusic(String string) {
        if (this.case && string.length() > 0) {
            this.a("PlayMusic", new Object[]{string});
        }
    }

    public a int() {
        return this;
    }

    public Object a(String string) {
        if (this.case) {
            try {
                JSObject jSObject = JSObject.getWindow(this);
                return jSObject.eval(string);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void resumeMusic() {
        if (this.case) {
            this.a("ResumeMusic", null);
        }
    }

    public boolean a() {
        return this.case;
    }

    public void update() {
    }

    public void update(Graphics graphics) {
        this.paint(graphics);
    }

    public void start() {
        System.out.println("start client");
        new Thread(this).start();
    }

    public String getAppletInfo() {
        String string = System.getProperty("java.version");
        return string;
    }

    public int getMusicVolume() {
        if (this.case) {
            Object object = this.a("GetMusicVolume", null);
            if (object instanceof Integer) {
                return (Integer)object;
            }
            return 0;
        }
        return 0;
    }

    public void for(String string) {
        try {
            if (this.case) {
                URL uRL = new URL(string);
                this.getAppletContext().showDocument(uRL, "_blank");
            } else {
                File file = new File("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE");
                if (!file.exists()) {
                    file = new File("D:\\Program Files\\Internet Explorer\\IEXPLORE.EXE");
                }
                Runtime.getRuntime().exec(file.getAbsolutePath() + " " + string);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public String getParameter(String string) {
        if (string.equals("mayscript")) {
            return "true";
        }
        String string2 = (String)this.goto.for(string);
        if (!this.case) {
            return string2;
        }
        if (string2 == null) {
            return super.getParameter(string);
        }
        return string2;
    }

    public void setMusicVolume(int n2) {
        if (this.case) {
            this.a("SetMusicVolume", new Object[]{new Integer(n2)});
        }
    }

    public void setBounds(int n2, int n3, int n4, int n5) {
        super.setBounds(n2, n3, n4, n5);
        this.a.setBounds(n2, n3, n4, n5);
        if (this.char != null) {
            this.char.setLocation(n4 / 2 - this.char.getWidth() / 2, n5 / 2 - this.char.getHeight() / 2);
        }
    }

    public String for() {
        if (this.case) {
            try {
                JSObject jSObject = JSObject.getWindow(this);
                this.a("var windowTitle=document.title;");
                return String.valueOf(jSObject.getMember("windowTitle"));
            }
            catch (JSException jSException) {
                jSException.printStackTrace();
                return "";
            }
        }
        Frame frame = (Frame)this.getParent();
        return frame.getTitle();
    }

    public void do(String string) {
        if (this.case) {
            this.a("top.document.title='" + string + "';");
        } else {
            Frame frame = (Frame)this.getParent();
            frame.setTitle(string);
        }
    }

    public int if() {
        return this.for;
    }

    public void pauseMusic() {
        if (this.case) {
            this.a("PauseMusic", null);
        }
    }

    private void byte() {
        String string;
        byte[] byArray = this.else.do(this.if);
        if (byArray != null) {
            String string2;
            String string3;
            int n2;
            int n3;
            string = "";
            try {
                string = new String(byArray, "GB2312");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
            i i2 = n.a().a(string);
            i i3 = i2.a("parameters");
            h h2 = i3.int();
            if (h2 != null) {
                n3 = h2.for();
                n2 = 0;
                while (n2 < n3) {
                    i3 = (i)h2.if(n2);
                    string3 = i3.for("name");
                    string2 = i3.for("value");
                    this.goto.a((Object)string3, (Object)string2);
                    ++n2;
                }
            }
            if ((h2 = (i3 = i2.a("languages")).int()) != null) {
                n3 = h2.for();
                n2 = 0;
                while (n2 < n3) {
                    i3 = (i)h2.if(n2);
                    string3 = i3.do();
                    string2 = i3.for();
                    this.try.a((Object)string3, (Object)string2);
                    ++n2;
                }
            }
        }
        if ((string = this.getParameter("port")) != null && string.length() > 3) {
            this.for = Integer.parseInt(string);
        }
        if ((string = this.getParameter("loadGameText")) != null && string.length() > 1) {
            this.int = string;
        }
    }

    public void repaint(long l2, int n2, int n3, int n4, int n5) {
        Graphics graphics;
        if (n2 >= this.a.width || n3 >= this.a.height || n2 + n4 <= 0 || n3 + n5 <= 0) {
            return;
        }
        if (n2 < 0) {
            n4 += n2;
            n2 = 0;
        }
        if (n3 < 0) {
            n5 += n3;
            n3 = 0;
        }
        if (n2 + n4 > this.a.width) {
            n4 = this.a.width - n2;
        }
        if (n3 + n5 > this.a.height) {
            n5 = this.a.height - n3;
        }
        if ((graphics = this.getGraphics()) != null) {
            graphics.setClip(n2, n3, n4, n5);
            this.paint(graphics);
            graphics.dispose();
        }
    }

    public void paint(Graphics graphics) {
        if (this.do) {
            graphics.translate(this.char.getX(), this.char.getY());
            this.char.paint(graphics);
            graphics.translate(-this.char.getX(), -this.char.getY());
        } else {
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, 65535, 65535);
            graphics.setColor(Color.white);
            int n2 = graphics.getFontMetrics().stringWidth(this.int);
            graphics.drawString(this.int, this.a.width / 2 - n2 / 2, this.a.height / 2);
        }
    }

    public Object a(String string, Object[] objectArray) {
        if (this.case) {
            try {
                JSObject jSObject = JSObject.getWindow(this);
                Object object = jSObject.call(string, objectArray);
                return object;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public String if(String string) {
        String string2 = (String)this.try.for(string);
        if (string2 == null) {
            string2 = "not defined:" + string;
        }
        return string2;
    }

    public String new() {
        return this.long;
    }

    public String try() {
        try {
            JSObject jSObject = JSObject.getWindow(this);
            this.a("var clipboardText=clipboardData.getData('Text');");
            return String.valueOf(jSObject.getMember("clipboardText"));
        }
        catch (JSException jSException) {
            jSException.printStackTrace();
            return "";
        }
    }

    public void int(String string) {
        String string2 = "clipboardData.setData(\"Text\",\"" + string + "\");";
        this.a(string2);
    }

    public c do() {
        return this.else;
    }

    public void stopMusic() {
        if (this.case) {
            this.a("StopMusic", null);
        }
    }

    public void run() {
        this.char = new a.b.h();
        this.char.int(40);
        Dimension dimension = this.getSize();
        this.char.setBounds(0, 0, dimension.width, dimension.height);
        this.add(this.char);
        this.new = new b.a.c.b(this, this.char);
        this.new.n();
        this.new.f();
        this.do = true;
        this.repaint();
    }

    public void play2DSound(String string) {
        if (!this.case) {
            return;
        }
        AudioClip audioClip = (AudioClip)this.byte.for(string);
        if (audioClip == null && (audioClip = this.getAudioClip(this.getCodeBase(), string + ".au")) != null) {
            this.byte.a((Object)string, (Object)audioClip);
        }
        if (audioClip != null) {
            audioClip.play();
        }
    }

    public void init() {
        System.out.println("init client");
        if (this.else == null) {
            this.case = true;
            b.a(this);
            this.long = this.getCodeBase().getHost();
            String string = super.getParameter("config");
            if (string == null || string.length() <= 1) {
                string = (String)this.a("getConfigFile", null);
            }
            if (string != null && string.length() > 1 && !string.equals("undifined")) {
                this.if = string;
            }
            this.else = new a.e.a(this.getCodeBase());
        }
        this.setBackground(Color.black);
        this.setLayout(null);
        this.byte();
    }
}

