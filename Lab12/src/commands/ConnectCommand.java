package commands;

import diagram.DiagramCanvas;

public class ConnectCommand implements DrawCommand {

    private DiagramCanvas diagramCanvas;
    private int indexFirst;
    private int indexSecond;
    private int indexFirstOld;
    private int indexSecondOld;

    public ConnectCommand(DiagramCanvas diagramCanvas, int indexFirst, int indexSecond) {

        this.diagramCanvas = diagramCanvas;
        this.indexFirst = indexFirst;
        this.indexSecond = indexSecond;
    }

    @Override
    public void execute() {

        diagramCanvas.getComponent(indexFirst).connectTo(Integer.toString(indexSecond));
        diagramCanvas.getComponent(indexSecond).connectTo(Integer.toString(indexFirst));
    }

    @Override
    public void undo() {

        diagramCanvas.getComponent(indexFirst).removeConnection(Integer.toString(indexSecond));
        diagramCanvas.getComponent(indexSecond).removeConnection(Integer.toString(indexFirst));
    }
}
