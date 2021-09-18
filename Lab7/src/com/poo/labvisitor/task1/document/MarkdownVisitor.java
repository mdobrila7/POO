package com.poo.labvisitor.task1.document;

import java.util.List;

public class MarkdownVisitor implements DocumentVisitor {
    public List<TextSegment> lista ;
    StringBuilder string = new StringBuilder("");

    @Override
    public void visit(TextSegment text) {
        this.string.append(text.getContent());
    }

    @Override
    public void visit(ItalicTextSegment italic) {
        this.string.append("*" + italic.getContent() + "*");
    }

    @Override
    public void visit(BoldTextSegment bold) {
        this.string.append("**" + bold.getContent() + "**");
    }

    @Override
    public void visit(UrlSegment url) {
        this.string.append("[" + url.url_description + "](" +
                url.url + "/)");
    }

    @Override
    public void visit(PlainTextSegment plain) {
        this.string.append(plain.getContent());
    }

    @Override
    public StringBuilder getDocument() {
        return this.string;
    }

}