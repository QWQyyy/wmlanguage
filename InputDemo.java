package joker;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class InputDemo {
    public static void main(String[] args) throws AWTException {
        String[] word = new String[16];
        readTxt(word, "D:\\ThinkInJava\\src\\joker\\文明用语.txt");//可以用相对路径，这里直接右键过来 D:\ThinkInJava\src\joker\文明用语.txt
        Robot r = new Robot();
        r.delay(2000);
        while (true) {
            copyString(word);
            pressKey(r);
        }
    }

    //读文件
    public static void readTxt(String[] word, String str) {

        int n = 0;
        File file = new File(str);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

            String temp = null;
            while ((temp = br.readLine()) != null) {
                word[n++] = temp;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyString(String[] word) {
        //随机生成文明用语
        int a = (int) (Math.random() * 16);
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable ts = new StringSelection(word[a]);
        cb.setContents(ts, null);
    }

    public static void pressKey(Robot r) {
        //自动按下ctrl
        r.keyPress(KeyEvent.VK_CONTROL);
        //自动按下V
        r.keyPress(KeyEvent.VK_V);
        //松开V
        r.keyRelease(KeyEvent.VK_V);
        //松开ctrl
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.delay(400);//设定延迟
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        r.delay(100);
    }
}
