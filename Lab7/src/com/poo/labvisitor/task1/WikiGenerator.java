package com.poo.labvisitor.task1;

import com.poo.labvisitor.task1.document.DokuWikiVisitor;
import com.poo.labvisitor.task1.document.MarkdownVisitor;
import com.poo.labvisitor.task1.document.TextSegment;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {

    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        DokuWikiVisitor doku = new DokuWikiVisitor();
        for( TextSegment text : textSegments) {
            text.accept(doku);
        }
        return doku.getDocument();
    }

    public StringBuilder getMarkdownDocument() {
        MarkdownVisitor mark = new MarkdownVisitor();
        for( TextSegment text : textSegments) {
            text.accept(mark);
        }
        return mark.getDocument();
    }
}
