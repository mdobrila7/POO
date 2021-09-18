package commands;

import diagram.DiagramCanvas;
import diagram.DiagramComponent;

public class ResizeCommand implements DrawCommand{

    private DiagramCanvas diagramCanvas;
    private double percent;
    private int index;
    private int oldHeight;
    private int oldWeight;

    public ResizeCommand(DiagramCanvas diagramCanvas, double percent, int index) {

        this.diagramCanvas = diagramCanvas;
        this.percent = percent;
        this.index = index;
    }

    @Override
    public void execute() {

        int height = diagramCanvas.getComponent(index).getHeight();
        int weight = diagramCanvas.getComponent(index).getWeight();

        oldHeight = height;
        oldWeight = weight;

        height *= percent;
        weight *= percent;

        diagramCanvas.getComponent(index).setHeight(height);
        diagramCanvas.getComponent(index).setWeight(weight);
    }

    @Override
    public void undo() {

        diagramCanvas.getComponent(index).setHeight(oldHeight);
        diagramCanvas.getComponent(index).setWeight(oldWeight);
    }
}
