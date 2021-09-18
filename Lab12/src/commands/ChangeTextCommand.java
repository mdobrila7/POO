package commands;

import diagram.DiagramCanvas;

public class ChangeTextCommand implements DrawCommand {

    private DiagramCanvas diagramCanvas;
    private String text;
    private String oldText;
    private int index;

    public ChangeTextCommand(DiagramCanvas diagramCanvas, int index, String text) {

        this.diagramCanvas = diagramCanvas;
        this.text = text;
        this.index = index;
    }

    @Override
    public void execute() {

        oldText = diagramCanvas.getComponent(index).getText();
        diagramCanvas.getComponent(index).setText(text);
    }

    @Override
    public void undo() {

        diagramCanvas.getComponent(index).setText(oldText);
    }
}
