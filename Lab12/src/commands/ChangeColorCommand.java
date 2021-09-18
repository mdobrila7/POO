package commands;

import diagram.DiagramCanvas;

public class ChangeColorCommand implements DrawCommand {

    private DiagramCanvas diagramCanvas;
    private String color = "WHITE";
    private String oldColor;
    private int index;

    public ChangeColorCommand(DiagramCanvas diagramCanvas, int index, String color) {

        this.diagramCanvas = diagramCanvas;
        this.color = color;
        this.index = index;
    }

    @Override
    public void execute() {

        oldColor = diagramCanvas.getComponent(index).getColor();
        diagramCanvas.getComponent(index).setColor(color);
    }

    @Override
    public void undo() {

        diagramCanvas.getComponent(index).setColor(oldColor);
    }
}
