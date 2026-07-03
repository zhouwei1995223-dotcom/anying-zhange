/*
 * Decompiled with CFR 0.152.
 */
package game;

import a.e.a;
import a.e.b;
import a.e.c;
import game.GameApplet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GameFrame
extends Frame {
    private static final byte[] a(URL uRL) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        int n2 = httpURLConnection.getContentLength();
        if (n2 <= 0) {
            n2 = inputStream.available();
        }
        if (n2 <= 0) {
            return null;
        }
        byte[] byArray = new byte[n2];
        int n3 = 0;
        while (n3 < n2) {
            n3 += inputStream.read(byArray, n3, n2 - n3);
        }
        return byArray;
    }

    public GameFrame(String string) {
        super(string);
        this.enableEvents(64L);
    }

    protected void processWindowEvent(WindowEvent windowEvent) {
        int n2 = windowEvent.getID();
        switch (n2) {
            case 201: 
            case 202: {
                System.exit(0);
            }
        }
        super.processWindowEvent(windowEvent);
    }

    public static void main(String[] stringArray) throws Exception {
        int n2;
        Object object;
        Object object2;
        Object object3;
        Object object4 = "127.0.0.1";
        Object object5 = 12345;
        Object object6 = "\u5ba2\u6237\u7aef";
        Object object7 = "client.cfg";
        c c2 = null;
        if (stringArray.length == 0) {
            object3 = new String[]{"127.0.0.1"};
            object2 = new int[]{12345, 12345, 12345, 12345};
            String[] stringArray2 = new String[]{"\u672c\u673a\u670d\u52a1\u5668"};
            System.out.println("\u670d\u52a1\u5668\u5217\u8868\uff1a");
            int n3 = 0;
            while (n3 < ((String[])object3).length) {
                System.out.print(String.valueOf(n3 + 1) + "\u3001");
                System.out.println(stringArray2[n3]);
                ++n3;
            }
            System.out.println(String.valueOf(((String[])object3).length + 1) + "\u3001\u6211\u81ea\u5df1\u8f93\u5165\u670d\u52a1\u5668\u5730\u5740");
            System.out.print("\u8bf7\u8f93\u5165\u4f60\u7684\u9009\u62e9(1-" + (((String[])object3).length + 1) + "\uff0c\u76f4\u63a5\u56de\u8f66\u7b49\u4e8e\u9009\u7b2c\u4e00\u4e2a)\uff1a");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            object = bufferedReader.readLine();
            n2 = 0;
            if (((String)object).length() > 0) {
                n2 = ((String)object).charAt(0) - 49;
            }
            if (n2 >= 0 && n2 < ((String[])object3).length) {
                object4 = object3[n2];
                object5 = object2[n2];
                object6 = stringArray2[n2];
            } else if (n2 >= ((String[])object3).length) {
                System.out.print("\u8bf7\u8f93\u5165\u5730\u5740(\u9ed8\u8ba4\u662f\u672c\u673a)\uff1a");
                object = bufferedReader.readLine();
                if (((String)object).length() > 3) {
                    object4 = object;
                }
                System.out.print("\u8bf7\u8f93\u5165\u914d\u7f6e\u6587\u4ef6(\u9ed8\u8ba4\u4e3aclient.cfg)\uff1a");
                object = bufferedReader.readLine();
                if (((String)object).length() > 2) {
                    object7 = object;
                }
                object6 = object4;
            }
        }
        object3 = "";
        if (stringArray != null) {
            int n4 = 0;
            while (n4 < stringArray.length) {
                if (stringArray[n4].startsWith("host:")) {
                    object4 = stringArray[n4].substring(stringArray[n4].indexOf(58) + 1);
                } else if (stringArray[n4].startsWith("port:")) {
                    object5 = Integer.parseInt(stringArray[n4].substring(stringArray[n4].indexOf(58) + 1));
                } else if (stringArray[n4].startsWith("url:")) {
                    object3 = stringArray[n4].substring(stringArray[n4].indexOf(58) + 1);
                } else if (stringArray[n4].startsWith("title:")) {
                    object6 = stringArray[n4].substring(stringArray[n4].indexOf(58) + 1);
                } else if (stringArray[n4].startsWith("config:")) {
                    object7 = stringArray[n4].substring(stringArray[n4].indexOf(58) + 1);
                }
                ++n4;
            }
        }
        if (c2 == null) {
            if (object3.length() == 0) {
                object2 = new File(System.getProperty("user.dir"));
                c2 = new b((File)object2);
            } else if (object3.startsWith("http://")) {
                object2 = new URL((String)object3);
                c2 = new a((URL)object2);
            }
        }
        object2 = Toolkit.getDefaultToolkit().getScreenSize();
        int n5 = 2000;
        int n6 = 1060;
        object = new GameFrame((String)object6);
        ((Component)object).setBackground(Color.black);
        n2 = n5 + 8;
        int n7 = n6 + 28;
        ((Component)object).setBounds(((Dimension)object2).width / 2 - n2 / 2, ((Dimension)object2).height / 2 - n7 / 2, n2, n7);
        GameApplet gameApplet = new GameApplet();
        gameApplet.else = c2;
        ((Container)object).add((Component)gameApplet, "Center");
        ((Component)object).setVisible(true);
        gameApplet.case = false;
        gameApplet.long = object4;
        gameApplet.for = object5;
        gameApplet.if = object7;
        gameApplet.init();
        gameApplet.start();
    }

    private static final void a(String string) {
        try {
            File file;
            URL uRL = new URL(string);
            byte[] byArray = GameFrame.a(uRL);
            if (!(byArray == null || byArray.length <= 0 || (file = new File("launcher.zip")).exists() && file.length() == (long)byArray.length)) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byArray);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}

