package com.poo.labvisitor.task1.document;

public class UrlSegment extends TextSegment {
    public String url, url_description;
    public UrlSegment(String content1, String content2) {
        super(content1 + content2);
        this.url = content1;
        this.url_description = content2;
    }
    public void accept(DocumentVisitor doc) {
        doc.visit(this);
    }
}
