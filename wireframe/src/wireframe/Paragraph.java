package wireframe;

/**
 * Paragraph Component
 */
public class Paragraph extends Text {
	/** Instantiates a new Paragraph
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this paragraph
	 * @param canvas Canvas that houses this paragraph
	 * @param width Width of this paragraph
	 * @param height Height of this paragraph
	 */
	Paragraph(int x, int y, Group parent, Canvas canvas, int width, int height) {
		super(x, y, parent, canvas, width, height);
	}

	/** Instantiates a new paragraph
	 * 
	 * @param x X coordinates
	 * @param y Y coordinates
	 * @param parent Group that contains this paragraph
	 * @param canvas Canvas that houses this paragraph
	 * @param width Width of this paragraph
	 * @param height Height of this paragraph
	 * @param alignment Text alignment of this paragraph
	 */
	Paragraph(int x, int y, Group parent, Canvas canvas, int width, int height, Alignment alignment) {
		super(x, y, parent, canvas, width, height, alignment);
	}
}
