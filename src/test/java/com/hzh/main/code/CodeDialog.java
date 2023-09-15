package com.hzh.main.code;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * @ClassName CodeDialig
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 14:03
 * @Version 0.0.1
 **/
public class CodeDialog extends Reader {
    private String buffer = null;
    private int pos = 0;

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (buffer == null) {
            String in = showDialog();
            if (in == null) {
                return -1;
            }
            print(in);
            buffer = in + "\n";
            pos = 0;
        }
        int size = 0;
        int length = buffer.length();
        while (pos < length && size < len) {
            cbuf[off + size++] = buffer.charAt(pos++);
        }
        if (pos == length) {
            buffer = null;
        }
        return size;
    }


    protected void print(String s) {
        System.out.println(s);
    }

    @Override
    public void close() throws IOException {

    }

    protected String showDialog() {
        Scanner scanner=new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();

            if ("exit".equals(line.trim())) {
                break; // 退出循环
            }

            input.append(line).append("\n"); // 添加到StringBuilder中
        }

        System.out.println("你输入的字符串是：");
        scanner.close();
        return input.toString();
    }
    public static Reader file() throws FileNotFoundException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            return new BufferedReader(new FileReader(chooser.getSelectedFile()));
        else
            throw new FileNotFoundException("no file specified");
    }
}
