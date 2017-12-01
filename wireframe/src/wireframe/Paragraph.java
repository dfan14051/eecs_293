package wireframe;

public class Paragraph extends Text {
	Paragraph(int x, int y, Component parent, Canvas canvas, int width, int height) {
		super(x, y, parent, canvas, width, height);
	}

	Paragraph(int x, int y, Component parent, Canvas canvas, int width, int height, Alignment alignment) {
		super(x, y, parent, canvas, width, height, alignment);
	}
}
