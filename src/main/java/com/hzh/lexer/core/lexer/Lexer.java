package com.hzh.lexer.core.lexer;

import com.hzh.lexer.core.token.IdToken;
import com.hzh.lexer.core.token.NumToken;
import com.hzh.lexer.core.token.StrToken;
import com.hzh.lexer.core.token.Token;
import com.hzh.lexer.excpetion.ParseException;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Lexer
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/9/14 12:59
 * @Version 0.0.1
 * 词法分析器
 **/
public class Lexer {

    /**
     * \\s*：匹配零个或多个空白字符（如空格、制表符、换行符等）。
     * <p>
     * (//.*)：匹配以//开始的注释，直到行尾。
     * <p>
     * ([0-9]+)：匹配一个或多个数字字符，即一个整数。
     * <p>
     * \"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\"：匹配一个字符串字面量。字符串以双引号开始和结束，并可以包含以下内容：
     * <p>
     * \\\\\"：匹配一个转义的双引号字符（即\"）。
     * \\\\\\\\：匹配一个转义的反斜杠字符（即\\）。
     * \\\\n：匹配一个转义的换行符（即\n）。
     * [^\"]：匹配任何非双引号字符。
     * [A-Z_a-z][A-Z_a-z0-9]*：匹配一个标识符。标识符以一个大写字母、小写字母或下划线开始，后跟零个或多个大写字母、小写字母、数字或下划线。
     * <p>
     * ==|<=|>=|&&|\\|\\|：匹配一些双字符的操作符，如==、<=、>=、&&或||。
     * <p>
     * \\p{Punct}：匹配任何一个标点符号。
     * <p>
     * 最后的?表示整个正则表达式是可选的，即它可以匹配零个或一个模式。
     */
    public static String regexPat = "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
            + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";

    private Pattern pattern = Pattern.compile(regexPat);

    private ArrayList<Token> queue = new ArrayList<>();
    private boolean hasMore;
    private LineNumberReader reader;

    public Lexer(Reader reader) {
        this.hasMore = true;
        this.reader = new LineNumberReader(reader);
    }

    public Token read() throws ParseException {
        if (fillQueue(0)) {
            return queue.remove(0);
        }
        return Token.EOF;
    }

    public Token peek(int i) throws ParseException {
        if (fillQueue(i)) {
            return queue.remove(i);
        }
        return Token.EOF;
    }

    private boolean fillQueue(int i) throws ParseException {
        while (i >= queue.size()) {
            if (hasMore) {
                readLine();
            } else {
                return false;
            }
        }
        return true;
    }

    protected void readLine() throws ParseException {
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new ParseException(e);
        }
        if (line == null) {
            hasMore = false;
            return;
        }
        int lineNo = reader.getLineNumber();
        Matcher matcher = pattern.matcher(line);
        matcher.useTransparentBounds(true).useAnchoringBounds(false);
        int pos = 0;
        int endPos = line.length();
        while (pos < endPos) {
            matcher.region(pos, endPos);
            if (matcher.lookingAt()) {
                addToken(lineNo, matcher);
                pos = matcher.end();
            } else {
                throw new ParseException("bad token at line " + lineNo);
            }
            queue.add(new IdToken(lineNo, Token.EOL));
        }
    }

    protected void addToken(int lineNo, Matcher matcher) {
        String m = matcher.group(1);
        if (m != null) {
            if (matcher.group(2) == null) { //if not a comment
                Token token;
                if (matcher.group(3) != null) {
                    token = new NumToken(lineNo, Integer.parseInt(m));
                } else if (matcher.group(4) != null) {
                    token = new StrToken(lineNo, toStringLiteral(m));
                } else {
                    token = new IdToken(lineNo, m);
                }
                queue.add(token);
            }
        }
    }

    protected String toStringLiteral(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length() - 1;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '\\' && i + 1 < len) {
                int c2 = s.charAt(i + 1);
                if (c2 == '"' || c2 == '\\') {
                    c = s.charAt(++i);
                } else if (c2 == 'n') {
                    ++i;
                    c = '\n';
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

}
