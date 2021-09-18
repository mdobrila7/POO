package com.poo.labvisitor.task1.document;

public interface DocumentVisitor {
    public void visit(ItalicTextSegment text);
    public void visit(BoldTextSegment text);
    public void visit(PlainTextSegment text);
    public void visit(UrlSegment text);
    public void visit(TextSegment text);
    public StringBuilder getDocument();
}
