package planning;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import planning.Assignment.Dependency;
import planning.Assignment.Dependency.Type;

public class PlanningTest {

	@Test
	public void test() {
		Assignment a = new Assignment(5);
		Assignment b = new Assignment(8);
		Assignment c = new Assignment(9);
		Assignment d = new Assignment(7);
		a.dependencies.add(new Dependency(b, Type.BEGINBEGIN));
		a.dependencies.add(new Dependency(c, Type.ENDBEGIN));
		b.dependencies.add(new Dependency(d, Type.BEGINEND));
		d.dependencies.add(new Dependency(c, Type.BEGINBEGIN));
		List<Assignment> assignments = new ArrayList<Assignment>();
		assignments.add(a);
		assignments.add(b);
		assignments.add(c);
		assignments.add(d);
		int deliveryTime = Planning.calculateEstimatedDeliveryTime(assignments);
		assertEquals(14, deliveryTime);
	}

}
