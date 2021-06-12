package ru.skillbench.tasks.javaapi.io;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class WordFinderImpl implements WordFinder {

    private String text;
    private Stream<String> wordsStartWith;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        this.text = text;
    }

    @Override
    public void setInputStream(InputStream is) throws IOException {
        if (text != null) {
            throw new IOException();
        }
        if (is == null) {
            throw new IllegalArgumentException();
        }
        text = "";
        int i = 0;
        byte[] buff = new byte[1024];
        while (is.available() > 0) {
            i = is.read(buff, 0, buff.length);
            for (int j = 0; j < i; j++) {
                text += (char) buff[j];
            }
            if (i == -1)
                break;
        }
    }

    @Override
    public void setFilePath(String filePath) throws IOException {
        if (text != null) {
            throw new IOException();
        }
        if (filePath == null) {
            throw new IllegalArgumentException();
        }
        FileInputStream fileInputStream = new FileInputStream(filePath);
        setInputStream(fileInputStream);

    }

    @Override
    public void setResource(String resourceName) throws IOException {
        if (text != null) {
            throw new IOException();
        }
        if (resourceName == null) {
            throw new IllegalArgumentException();
        }
        setInputStream(WordFinder.class.getResourceAsStream(resourceName));
    }

    @Override
    public Stream<String> findWordsStartWith(String begin) {
        if (text == null) {
            throw new IllegalStateException();
        }
        String[] strings = text.split("\\s+");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].toLowerCase();
        }
        if (begin == null || begin.equals("")) {
            wordsStartWith = Arrays.stream(strings);
            return wordsStartWith;
        }
        wordsStartWith = Arrays.stream(strings).filter((string) -> string.startsWith(begin.toLowerCase()));
        return wordsStartWith;
    }

    @Override
    public void writeWords(OutputStream os) throws IOException {
        if (wordsStartWith == null) {
            throw new IllegalStateException();
        }
        Stream<String> stream = wordsStartWith.sorted();
        String[] strings = (String[]) stream.toArray();
        for (String s : strings) {
            os.write((s + " ").getBytes());
        }
    }
}