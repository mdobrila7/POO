package main;

public class Test {
    public static void main(String[] args) {
        Client client = new Client();

        // Execute various tests

        testDraw(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testTextAndColor(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testResize(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testConnect(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testAllCommands(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testSimpleUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));

        testComplexUndoRedo(client);
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }

    private static void testDraw(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");

        client.showDiagram();
    }

    private static void testTextAndColor(Client client) {
        testDraw(client);
        client.executeAction("change color", "0", "RED");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "MyClass1");
        client.executeAction("change text", "5", "MyClass2");
        client.showDiagram();
    }

    private static void testConnect(Client client) {
        testDraw(client);
        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "4", "3");
        client.showDiagram();
    }

    private static void testResize(Client client) {
        testDraw(client);
        client.executeAction("resize", "1.20", "0");
        client.executeAction("resize", "0.00", "1");
        client.executeAction("resize", "1.41", "2");
        client.executeAction("resize", "1.00", "3");
        client.executeAction("resize", "2.00", "4");
        client.showDiagram();
    }

    private static void testAllCommands(Client client) {
        client.newDiagram();
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "PURPLE");
        client.executeAction("change color", "1", "BLUE");
        client.executeAction("draw rectangle");
        client.executeAction("change text", "0", "CLASS1");
        client.executeAction("change text", "5", "CLASS2");
        client.executeAction("resize", "1.30", "0");
        client.executeAction("resize", "0.00", "1");
        client.executeAction("resize", "1.89", "2");
        client.executeAction("resize", "2.25", "3");
        client.executeAction("resize", "3.00", "4");
        client.executeAction("connect", "1", "2");
        client.executeAction("connect", "3", "5");
        client.showDiagram();
    }

    private static void testSimpleUndoRedo(Client client) {
        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("change color", "0", "ORANGE");
        client.showDiagram();

        client.executeAction("draw rectangle");
        client.showDiagram();

        client.undo();
        client.showDiagram();

        client.redo();
        client.showDiagram();
    }

    private static void testComplexUndoRedo(Client client) {
        // TODO

        client.newDiagram();

        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("draw rectangle");
        client.executeAction("resize", "1.5", "1");
        client.executeAction("resize", "2.25", "1");
        client.showDiagram();
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();
        client.executeAction("change color", "0", "Magenta");
        client.executeAction("change color", "1", "Green");
        client.showDiagram();
        client.undo();
        client.undo();
        client.showDiagram();
        client.executeAction("change text", "2", "Merge");
        client.executeAction("change text", "1", "Sau nu");
        client.showDiagram();
        client.undo();
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();
        client.redo();
        client.showDiagram();

        client.executeAction("connect", "0", "1");
        client.executeAction("connect", "0", "2");
        client.showDiagram();
        client.undo();
        client.showDiagram();
        client.redo();
        client.showDiagram();




    }
}
