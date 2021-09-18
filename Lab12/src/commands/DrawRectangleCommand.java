package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class DrawRectangleCommand implements DrawCommand {

    private DiagramCanvas diagramCanvas;
    private DiagramComponent componentForUndo;
    private int indexForUndo;

    public DrawRectangleCommand(DiagramCanvas diagramCanvas) {

        this.diagramCanvas = diagramCanvas;
    }

    @Override
    public void execute() {

        DiagramComponent diagramComponent = new DiagramComponent();
        indexForUndo++;
        diagramCanvas.addComponent(diagramComponent);
    }

    @Override
    public void undo() {

        componentForUndo = diagramCanvas.getComponent(indexForUndo);
        diagramCanvas.removeComponent(componentForUndo);
    }
}
