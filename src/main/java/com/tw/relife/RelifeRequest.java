package com.tw.relife;

import java.util.Objects;

public class RelifeRequest {
    private final String path;
    private final RelifeMethod method;
    private final String content;
    private final String contentType;

    public RelifeRequest(String path, RelifeMethod method) {
        this(path, method, null, null);
    }

    public RelifeRequest(String path, RelifeMethod method, String content, String contentType) {
        this.path = path;
        this.method = method;
        this.content = content;
        this.contentType = contentType;
    }

    public String getPath() {
        return path;
    }

    public RelifeMethod getMethod() {
        return method;
    }

    public String getContent() {
        return content;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelifeRequest that = (RelifeRequest) o;
        return Objects.equals(path, that.path) &&
                method == that.method &&
                Objects.equals(content, that.content) &&
                Objects.equals(contentType, that.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, method, content, contentType);
    }
}
